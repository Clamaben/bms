package com.BMS.dao;

import com.BMS.module.User;

import java.util.List;

public interface AdminDAO{
    public boolean doInsert(User user) throws Exception;

    public boolean doModifyById(String userId,User newUser) throws Exception;

    public boolean doDeleteById(String userId) throws Exception;

    public List<User> findAll() throws Exception;

    public User findById(String userId) throws Exception;

    public User findByName(String userName) throws Exception;
}
