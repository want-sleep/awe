package com.awei;

import com.awei.bankservice.BankService;
import com.awei.bankservice.Imp.BankServiceImp;
import com.awei.dao.BankDao;
import com.awei.domain.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AweiBankApplicationTests {
    @Autowired
    private BankDao bankDao;

    @Test
    void contextLoads() {
    }

    @Test
    void insert() {
        User user = new User();
        user.setAccount("123456789");
        user.setPassword("123456");
        user.setName("阿伟");
        user.setAge(18);
        user.setSex("男");
        bankDao.insert(user);
    }

    @Test
    void selectAll() {
        System.out.println(bankDao.selectList(null));
    }

    @Test
    void updataById() {
        User user = new User();
        user.setId(202076161);
        user.setMoney(999999999);
        bankDao.updateById(user);
    }

    @Test
    void delete() {
        bankDao.deleteById(202076161);
    }

    @Test
    void eq() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAccount,"123456789")
                .eq(User::getPassword,"123456");
        System.out.println(bankDao.selectList(lambdaQueryWrapper));
    }
    @Test
    void test1(){

        Object object= bankDao.selectList(null);
        System.out.println(object);
    }
}
