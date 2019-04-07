package com.BMS.dao;

import com.BMS.module.*;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BorrowerDAOImp implements BorrowerDAO {
    private static Connection con;
    private PreparedStatement stmt = null;

    static {
        con = DBConnection.getConnection();
    }


    @Override
    public boolean doInsert(Borrower borrower) throws Exception {
        // sqlÓï¾ä
        String sql = "INSERT INTO borrower(id,name,password,type,degree) VALUES(?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, borrower.getId());
        stmt.setString(2, borrower.getName());
        stmt.setString(3, borrower.getPassword());
        stmt.setString(4, borrower.getType());
        stmt.setString(5, borrower.getDegree());
        // sqlÖ´ÐÐÓï¾ä
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doModifyById(String userId, Borrower newBorrower) throws Exception {
        // sqlÓï¾ä
        String sql = "UPDATE borrower set id=?,name=?,password=?,type=?,degree=? where id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(6, userId);
        stmt.setString(1, newBorrower.getId());
        stmt.setString(2, newBorrower.getName());
        stmt.setString(3, newBorrower.getPassword());
        stmt.setString(4, newBorrower.getType());
        stmt.setString(5, newBorrower.getDegree());
        // sqlÖ´ÐÐÓï¾ä
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doDeleteById(String userId) throws Exception {
        // sqlÓï¾ä
        String sql = "DELETE from borrower where id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, userId);
        // sqlÖ´ÐÐÓï¾ä
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }


    @Override
    public List<Borrower> findAll() throws Exception {
        String sql = "SELECT id,name,password,type,degree FROM borrower";
        stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Borrower> list = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String pwd = rs.getString(3);
            String type = rs.getString(4);
            String degree = rs.getString(5);

            Borrower borrower = new Borrower(id, name, pwd, type, degree);
            list.add(borrower);
        }
        return list;
    }

    @Override
    public Borrower findById(String borrowerId) throws Exception {
        String sql = "SELECT id,name,password,type,degree FROM borrower WHERE id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, borrowerId);
        ResultSet rs = stmt.executeQuery();
        Borrower borrower = null;
        if (rs.next()) {
            String name = rs.getString(2);
            String pwd = rs.getString(3);
            String type = rs.getString(4);
            String degree = rs.getString(5);
            borrower = new Borrower(borrowerId, name, pwd, type, degree);

        }
        return borrower;
    }

    @Override
    public Borrower findByName(String borrowerName) throws Exception {
        String sql = "SELECT id,name,password,type,degree FROM borrower WHERE name=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, borrowerName);
        ResultSet rs = stmt.executeQuery();
        Borrower borrower = null;
        if (rs.next()) {
            String id = rs.getString(1);
            String pwd = rs.getString(3);
            String type = rs.getString(4);
            String degree = rs.getString(5);
            borrower = new Borrower(id, borrowerName, pwd, type, degree);

        }
        return borrower;
    }
}
