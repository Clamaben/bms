package com.BMS.dao;

import com.BMS.module.BorrowRecord;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Repository
public class BorrowRecordDAOImp implements BorrowRecordDAO {

    private static Connection con;
    private PreparedStatement stmt = null;

    static {
        con = DBConnection.getConnection();
    }

    @Override
    public boolean doInsert(BorrowRecord borrowRecord) throws Exception {
        // sql语句
        String sql = "INSERT INTO borrowrecord(recordID,borrowerID,bookID,borrowTime,dueTime,status) VALUES(?,?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, borrowRecord.getRecordId());
        stmt.setString(2, borrowRecord.getBorrowerId());
        stmt.setString(3, borrowRecord.getBookId());
        stmt.setDate(4, new java.sql.Date(borrowRecord.getBorrowTime().getTime()));
        stmt.setDate(5, new java.sql.Date(borrowRecord.getDueTime().getTime()));
        stmt.setString(6, borrowRecord.getStatus());

        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doModifyById(String recordId, BorrowRecord newBorrowRecord) throws Exception {
        // sql语句
        String sql = "UPDATE borrowrecord set recordID=?,borrowerID=?,bookID=?,borrowTime=?,dueTime=?,status=? where recordID=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(7, recordId);
        stmt.setString(1, newBorrowRecord.getRecordId());
        stmt.setString(2, newBorrowRecord.getBorrowerId());
        stmt.setString(3, newBorrowRecord.getBookId());
        stmt.setDate(4, new java.sql.Date(newBorrowRecord.getBorrowTime().getTime()));
        stmt.setDate(5, new java.sql.Date(newBorrowRecord.getDueTime().getTime()));
        stmt.setString(6, newBorrowRecord.getStatus());
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doDeleteById(String recordId) throws Exception {
        // sql语句
        String sql = "DELETE from borrowrecord where recordID=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, recordId);
        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public List<BorrowRecord> findAll() throws Exception {
        String sql = "SELECT recordID,borrowerID,bookID,borrowTime,dueTime,status FROM borrowrecord";
        stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<BorrowRecord> list = new ArrayList<>();
        while (rs.next()) {
            String recordID = rs.getString(1);
            String borrowerID = rs.getString(2);
            String bookID = rs.getString(3);
            Date borrowTime = rs.getTimestamp(4);
            Date dueTime = rs.getTimestamp(5);
            String status = rs.getString(6);

            BorrowRecord borrowRecord = new BorrowRecord(recordID, borrowerID, bookID, borrowTime, dueTime, status);
            list.add(borrowRecord);
        }
        return list;
    }

    @Override
    public BorrowRecord findById(String recordId) throws Exception {
        String sql = "SELECT recordID,borrowerID,bookID,borrowTime,dueTime,status FROM borrowrecord where recordID=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, recordId);
        ResultSet rs = stmt.executeQuery();
        BorrowRecord borrowRecord = null;
        if (rs.next()) {
            String borrowerID = rs.getString(2);
            String bookID = rs.getString(3);
            Date borrowTime = rs.getTimestamp(4);
            Date dueTime = rs.getTimestamp(5);
            String status = rs.getString(6);

            borrowRecord = new BorrowRecord(recordId, borrowerID, bookID, borrowTime, dueTime, status);
        }
        return borrowRecord;
    }

    /**
     * 已经借阅书籍
     * 0代表已经借阅未还
     * 1 已还
     */
    @Override
    public List<BorrowRecord> findAllAlreadById(String borrowerId) throws Exception {
        String sql = "SELECT recordID,borrowerID,bookID,borrowTime,dueTime,status FROM borrowrecord WHERE borrowerID=? AND status=? ";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, borrowerId);
        stmt.setString(2, "0");
        ResultSet rs = stmt.executeQuery();

        List<BorrowRecord> list = new ArrayList<>();
        while (rs.next()) {
            String recordID = rs.getString(1);
            String borrowerID = rs.getString(2);
            String bookID = rs.getString(3);
            Date borrowTime = rs.getTimestamp(4);
            Date dueTime = rs.getTimestamp(5);
            String status = rs.getString(6);

            BorrowRecord borrowRecord = new BorrowRecord(recordID, borrowerID, bookID, borrowTime, dueTime, status);
            list.add(borrowRecord);
        }
        return list;

    }

    @Override
    public BorrowRecord findByBookId(String bookId) throws Exception {
        String sql = "SELECT recordID,borrowerID,bookID,borrowTime,dueTime,status FROM borrowrecord WHERE bookID=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, bookId);
        ResultSet rs = stmt.executeQuery();
        BorrowRecord borrowRecord=null;

        while (rs.next()) {
            String recordID = rs.getString(1);
            String borrowerID = rs.getString(2);
            String bookID = rs.getString(3);
            Date borrowTime = rs.getTimestamp(4);
            Date dueTime = rs.getTimestamp(5);
            String status = rs.getString(6);

            borrowRecord = new BorrowRecord(recordID, borrowerID, bookID, borrowTime, dueTime, status);

        }
        return borrowRecord;

    }
    @Override
    public List<BorrowRecord> findAllByBorrowerId(String borrowerId) throws Exception {
        String sql = "SELECT recordID,borrowerID,bookID,borrowTime,dueTime,status FROM borrowrecord WHERE borrowerID=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, borrowerId);
        ResultSet rs = stmt.executeQuery();

        List<BorrowRecord> list = new ArrayList<>();
        while (rs.next()) {
            String recordID = rs.getString(1);
            String borrowerID = rs.getString(2);
            String bookID = rs.getString(3);
            Date borrowTime = rs.getTimestamp(4);
            Date dueTime = rs.getTimestamp(5);
            String status = rs.getString(6);

            BorrowRecord borrowRecord = new BorrowRecord(recordID, borrowerID, bookID, borrowTime, dueTime, status);
            list.add(borrowRecord);
        }
        return list;

    }

}
