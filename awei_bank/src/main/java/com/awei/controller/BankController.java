package com.awei.controller;

import com.awei.bankservice.BankService;
import com.awei.domain.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 阿伟
 * @since 2023-08-06
 */
@RestController
@RequestMapping("/ssm_bank")
@CrossOrigin(origins = "http://localhost:8080")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping
    public Result selelctAll() {
        System.out.println(bankService.selectAll());
        return new Result(bankService.selectAll(),
                bankService.selectAll().isEmpty() ? Code.SELECT_ERR : Code.SELECT_RIGHT,
                bankService.selectAll().isEmpty() ? Code.SELECT_ERR_MASSAGE : Code.SELECT_RIGHT_MASSAGE);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        System.out.println(bankService.selectById(id));
        return new Result(bankService.selectById(id),
                bankService.selectById(id) == null ? Code.SELECT_ERR : Code.SELECT_RIGHT,
                bankService.selectById(id) == null ? Code.SELECT_ERR_MASSAGE : Code.SELECT_RIGHT_MASSAGE);
    }

    @DeleteMapping("/{id}")
    public Result ResultdeleteById(@PathVariable Integer id) {
        bankService.deleteById(id);
        System.out.println("删除成功");
        return new Result(bankService.selectById(id),
                bankService.selectById(id) == null ? Code.DELECTE_ERR : Code.DELETE_RIGHT,
                bankService.selectById(id) == null ? Code.DELETE_ERR_MASSAGE : Code.DELETE_RIGHT_MASSAGE);
    }

    @PostMapping
    public Result Insert(@RequestBody User user) {
        bankService.insert(user);
        System.out.println("注册成功");
        return new Result(bankService.selectById(user.getId()),
                bankService.selectById(user.getId()) == null ? Code.INSERT_ERR : Code.INSERT_RIGHT,
                bankService.selectById(user.getId()) == null ? Code.INSERT_ERR_MASSAGE : Code.INSERT_RIGHT_MASSAGE);
    }

    @PutMapping
    public Result Updata(@RequestBody User user) {
        bankService.updateById(user);
        System.out.println("修改成功");
        return new Result(bankService.selectById(user.getId()),
                bankService.selectById(user.getId()) == null ? Code.UPDATA_ERR : Code.UPDATD_RIGHT,
                bankService.selectById(user.getId()) == null ? Code.UPDATA_RIGHT_MASSAGE : Code.UPDATD_ERR_MASSAGE);
    }

    @GetMapping({"{account}/{password}"})
    public Result log_in(@PathVariable String account, @PathVariable String password) {
        Object object = bankService.log_in(account, password);
        System.out.println(object);
        return new Result(object, bankService.log_in(account, password)==null?
                Code.LOG_IN_ERR : Code.LOG_IN_RIGHT, bankService.log_in(account, password)
               ==null ? Code.LOG_IN_ERR_MASSAGE : Code.LOG_IN_RIGHT_MASSAGE);
    }
}

