package com.BMS.dao;

import com.BMS.module.*;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminDAOImp implements AdminDAO {
    private static Connection con;
    private PreparedStatement stmt = null;

    static {
        con = DBConnection.getConnection();
    }


    @Override
    public boolean doInsert(User user) throws Exception {
        // sql语句
        String sql = "INSERT INTO admin(id,name,password) VALUES(?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, user.getId());
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getPassword());
        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doDeleteById(String userId) throws Exception {
        // sql语句
        String sql = "DELETE from admin where id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, userId);
        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doModifyById(String userId,User newUser) throws Exception {
        // sql语句
        String sql = "UPDATE admin set id=?,name=?,password=? where id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(4, userId);
        stmt.setString(1,newUser.getId());
        stmt.setString(2,newUser.getName());
        stmt.setString(3,newUser.getPassword());
        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public List<User> findAll() throws Exception {
        String sql = "SELECT id,name,password FROM admin";
        stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<User> list = new ArrayList<>();
        while (rs.next()) {
            String adminId = rs.getString(1);
            String adminName = rs.getString(2);
            String adminPwd = rs.getString(3);

            User user = new Admin(adminId, adminName, adminPwd);

            list.add(user);
        }
        return list;
    }

    @Override
    public Admin findById(String userId) throws Exception {
        String sql = "SELECT id,name,password FROM admin WHERE id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, userId);
        ResultSet rs = stmt.executeQuery();
        Admin admin = null;
        if (rs.next()) {
            String userName = rs.getString(2);
            String userPwd = rs.getString(3);
            admin = new Admin(userId, userName, userPwd);

        }
        return admin;
    }

    @Override
    public Admin findByName(String userName) throws Exception {
        String sql = "SELECT id,name,password FROM admin WHERE name=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, userName);
        ResultSet rs = stmt.executeQuery();
        Admin admin = null;
        if (rs.next()) {
            String userId = rs.getString(1);
            String userPwd = rs.getString(3);
            admin =new Admin(userId,userName,userPwd);
        }
        return admin;
    }

}
