package com.BMS.dao;


import com.BMS.module.Borrower;

import java.util.List;

public interface BorrowerDAO  {
    public boolean doInsert(Borrower borrower) throws Exception;

    public boolean doModifyById(String userId, Borrower newBorrower) throws Exception;

    public boolean doDeleteById(String userId) throws Exception;

    public List<Borrower> findAll() throws Exception;

    public Borrower findById(String borrowerId) throws Exception;

    public Borrower findByName(String borrowerName) throws Exception;
}
