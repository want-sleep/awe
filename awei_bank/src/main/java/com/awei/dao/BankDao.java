package com.awei.dao;

import com.awei.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BankDao extends BaseMapper <User>{
}
