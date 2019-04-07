package com.BMS.dao;

import com.BMS.module.*;
import org.apache.velocity.runtime.directive.Foreach;

import java.util.Date;
import java.util.List;

public class TestDAO {
    public static void main(String args[]) throws Exception {
        // findAll()接口测试
        DBConnection dbConnection = new DBConnection();
        AdminDAOImp adminDAOImp = new AdminDAOImp();
        OperatorDAOImp operatorDAOImp = new OperatorDAOImp();
        BorrowerDAOImp borrowerDAOImp = new BorrowerDAOImp();
        LoginTicketDAOImp loginTicketDAOImp = new LoginTicketDAOImp();

//        List<User> userList = null;
//        userList = adminDAOImp.findAll();

//        List<Borrower> borrowerList=null;
//        borrowerList=borrowerDAOImp.findAll();
//        for (int i = 0; i < borrowerList.size(); i++) {
//            Borrower b = borrowerList.get(i);
//            b.showBasicInfo();
//        }


        // findById()接口测试
//        String userId = "4";
//        Borrower borrower=borrowerDAOImp.findById(userId);
//        borrower.showBasicInfo();
//
//        // findByName()接口测试
//        String userName = "andy";
//        Borrower borrower1=borrowerDAOImp.findByName(userName);
//        borrower1.showBasicInfo();

//        // doInsert()接口测试
//        Borrower borrowerToInsert = new Borrower("6", "test", "123456","teacher","");
//        boolean insertResult = borrowerDAOImp.doInsert(borrowerToInsert);
//        if (insertResult)
//        {
//            System.out.println("insert "+borrowerToInsert.getName()+" succeed!");
//        }

//        // doDeleteById()接口测试
//        String deleteId = "2";
//        boolean deleteResult = borrowerDAOImp.doDeleteById(deleteId);
//        if (deleteResult)
//        {
//            System.out.println("delete No. "+deleteId+" succeed!");
//        }


        // doModifyById()接口测试
//        Borrower borrowerToModify = new Borrower("6", "test", "123456","teacher","");
//        boolean ModifyResult = adminDAOImp.doModifyById(borrowerToModify.getId(),borrowerToModify   );
//        if (ModifyResult)
//        {
//            System.out.println("Modify "+borrowerToModify.getName()+" info succeed!");
//            borrowerToModify.showBasicInfo();
//        }
//        else
//        {
//            System.out.println("modify failed!");
//        }
//        Date now = new Date();
//        LoginTicket loginTicket = new LoginTicket("123abcabc", "1", "admin", now, 1);
//        boolean result = loginTicketDAOImp.insertLoginTicket(loginTicket);
//        if (result) {
//            System.out.println("succeed!");
//        }

        LoginTicket loginTicket = loginTicketDAOImp.selectByTicket("123abcabc");
        System.out.println(loginTicket.getExpired());

    }
}
