package com.BMS.dao;

import com.BMS.module.BorrowRecord;

import java.util.List;

public interface BorrowRecordDAO {
    public boolean doInsert(BorrowRecord borrowRecord) throws Exception;

    public boolean doModifyById(String recordId,BorrowRecord newBorrowRecord) throws Exception;

    public boolean doDeleteById(String recordId) throws Exception;

    public List<BorrowRecord> findAll() throws Exception;

    public BorrowRecord findById(String recordId) throws Exception;

    public BorrowRecord findByBookId(String bookId) throws Exception;

    public List<BorrowRecord> findAllAlreadById(String borrowerId) throws Exception;

    public List<BorrowRecord> findAllByBorrowerId(String borrowerId) throws Exception;

}
