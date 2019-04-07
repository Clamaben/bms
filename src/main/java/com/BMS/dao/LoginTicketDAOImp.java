package com.BMS.dao;


import com.BMS.module.LoginTicket;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.sql.Date;

@Repository
public class LoginTicketDAOImp implements LoginTicketDAO {


    private static Connection con;
    private PreparedStatement stmt = null;

    static {
        con = DBConnection.getConnection();
    }

    @Override
    public LoginTicket selectByTicket(String ticket) throws Exception {
        String sql = "SELECT ticket,userid,role,expired,status FROM loginticket WHERE ticket=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1,ticket);
        ResultSet rs = stmt.executeQuery();
        LoginTicket loginTicket = null;
        if (rs.next()) {
            String userId = rs.getString(2);
            String role= rs.getString(3);
            Date expired=rs.getDate(4);
            int status=rs.getInt(5);
            loginTicket=new LoginTicket(ticket,userId,role,expired,status);
        }
        return loginTicket;

    }

    @Override
    public boolean insertLoginTicket(LoginTicket loginTicket) throws Exception {
        // sql语句
        String sql = "INSERT INTO loginticket(ticket,userid,role,expired,status) VALUES(?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, loginTicket.getTicket());
        stmt.setString(2, loginTicket.getUserId());
        stmt.setString(3, loginTicket.getRole());
        stmt.setDate(4, new java.sql.Date(loginTicket.getExpired().getTime()));
        stmt.setInt(5, loginTicket.getStatus());
        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doModifyById(String ticket, LoginTicket newLoginTicket) throws Exception {

        // sql语句
        String sql = "UPDATE loginTicket set ticket=?,userid=?,role=?,expired=?,status=? where ticket=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(6, ticket);
        stmt.setString(1, newLoginTicket.getTicket());
        stmt.setString(2, newLoginTicket.getUserId());
        stmt.setString(3, newLoginTicket.getRole());
        stmt.setDate(4, new java.sql.Date(newLoginTicket.getExpired().getTime()));
        stmt.setInt(5, newLoginTicket.getStatus());
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }
}

