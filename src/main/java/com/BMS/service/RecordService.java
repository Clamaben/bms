package com.BMS.service;

import com.BMS.dao.BorrowRecordDAO;
import com.BMS.dao.BorrowRecordDAOImp;
import com.BMS.module.BorrowRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RecordService {
    @Autowired
    BorrowRecordDAOImp borrowRecordDAO;
    private static Logger logger = LoggerFactory.getLogger(RecordService.class);

    public List<BorrowRecord> findAllAlreadById(String borrowerId) {
        List<BorrowRecord> res = null;
        try {
            res=borrowRecordDAO.findAllAlreadById(borrowerId);

        } catch (Exception E) {
            logger.error(E.getMessage());
        }
        finally {
            return res;

        }
    }


    public List<BorrowRecord> findAllById(String borrowerId) {
        List<BorrowRecord> res = null;
        try {
            res=borrowRecordDAO.findAllByBorrowerId(borrowerId);

        } catch (Exception E) {
            logger.error(E.getMessage());
        }
        finally {
            return res;

        }
    }

    public boolean borrowBook(String Bookid,String status) {
        boolean res=true;
        try {
            BorrowRecord br = borrowRecordDAO.findByBookId(Bookid);
            br.setStatus(status);
            borrowRecordDAO.doModifyById(Bookid, br);
        } catch (Exception e) {
            res = false;
        }finally {
            return res;
        }
    }
}
