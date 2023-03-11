package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.LoginUser;

@Mapper
public interface LoginMapper {

    public LoginUser findUser(String empId);

}
