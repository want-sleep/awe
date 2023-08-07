package com.awei.bankservice;

import com.awei.domain.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.util.List;

public interface BankService {
    List<User> selectAll();

    User selectById(Integer id);

    boolean updateById(User user);

    boolean insert(User user);

    boolean deleteById(Integer id);

    User log_in(String account, String password);

}
