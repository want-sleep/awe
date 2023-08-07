package com.awei.bankservice.Imp;

import com.awei.bankservice.BankService;
import com.awei.dao.BankDao;
import com.awei.domain.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BankServiceImp implements BankService {
    @Autowired
    private BankDao bankDao;

    @Override
    public List<User> selectAll() {

        return bankDao.selectList(null);
    }

    @Override
    public User selectById(Integer id) {
        return bankDao.selectById(id);
    }

    @Override
    public boolean updateById(User user) {
        bankDao.updateById(user);
        return true;
    }

    @Override
    public boolean insert(User user) {
        bankDao.insert(user);
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        bankDao.deleteById(id);
        return true;
    }

    @Override
    public User log_in(String account, String password) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getAccount, account)
                .eq(User::getPassword, password);
        return bankDao.selectList(lambdaQueryWrapper).isEmpty() ? null : bankDao.selectById(bankDao.selectList(lambdaQueryWrapper).get(0).getId());
    }
}
