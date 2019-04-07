package com.BMS.service;

import com.BMS.dao.AdminDAOImp;
import com.BMS.dao.BorrowerDAOImp;
import com.BMS.dao.OperatorDAOImp;

import com.BMS.module.LoginTicket;
import com.BMS.module.Admin;
import com.BMS.module.Borrower;
import com.BMS.module.Operator;

import com.BMS.module.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    AdminDAOImp adminDAOImp;
    @Autowired
    BorrowerDAOImp borrowerDAOImp;
    @Autowired
    OperatorDAOImp operatorDAOImp;
    @Autowired
    LoginTicketService loginTicketService;
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean addBorrower(Borrower borrower) {
        boolean res=false;
        try {

            res=borrowerDAOImp.doInsert(borrower);
        } catch (Exception e) {
            logger.error(e.getMessage()
            );
        }finally {
            return res;

        }
    }
    public boolean addOperator(Operator operator) {
        boolean res=false;
        try {
            res=operatorDAOImp.doInsert(operator);
        } catch (Exception e) {
            logger.error(e.getMessage()
            );
        }finally {
            return res;

        }
    }
    public boolean addAdmin(Admin admin) {
        boolean res=false;
        try {

            res=adminDAOImp.doInsert(admin);
        } catch (Exception e) {
            logger.error(e.getMessage()
            );
        }finally {
            return res;

        }
    }


    public Map<String, Object> doCheck(User user, String passwd, String role) {
        Map<String, Object> map = new HashMap<>();
        if (user == null || !user.getPassword().equals(passwd)) {
            map.put("res", "-1");
            return map;
        } else {
            map.put("res", "0");
            LoginTicket loginTicket = new LoginTicket();
            Date date = new Date();
            date.setTime(date.getTime() + 1000 * 3600 * 24 * 1);//1天的过期时间
            loginTicket.setExpired(date);
            loginTicket.setRole(role);
            loginTicket.setStatus(0);
            loginTicket.setTicket(UUID.randomUUID().toString().substring(0, 5).replaceAll("-", ""));
            loginTicket.setUserId(user.getId());
            loginTicketService.saveLoginTicket(loginTicket);

            map.put("ticket", loginTicket.getTicket());


            return map;
        }
    }

    public User findByUserIdAndRole(String userId, String role) {
        User user = null;
        try {

            if (role.equals("admin")) {
                user = (User) adminDAOImp.findById(userId);
            }
            if (role.equals("operator")) {
                user = (User) operatorDAOImp.findById(userId);
            }
            if (role.equals("borrower")) {
                user = (User) borrowerDAOImp.findById(userId);
            }


            return user;
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            return user;
        }
    }

    public boolean doUpdate(User user, String role, String id) {

        try {
            switch (role) {
                case "admin":
                    return adminDAOImp.doModifyById(id, (Admin) user);
                case "borrower":
                    return borrowerDAOImp.doModifyById(id, (Borrower) user);
                case "operator":
                    return operatorDAOImp.doModifyById(id, (Operator) user);

            }
            return false;
        } catch (Exception e) {
            logger.error("修改用户失败:  " + e.getMessage());

        }
        return false;
    }

    public Map<String, Object> doLogin(String userName, String passwd, String role) {

        Map<String, String> map = new HashMap<>();
        try {
            User user;
            switch (role) {
                case "admin":
                    user = adminDAOImp.findByName(userName);
                    return doCheck(user, passwd, role);
                case "borrower":
                    user = borrowerDAOImp.findByName(userName);
                    return doCheck(user, passwd, role);
                case "operator":
                    user = operatorDAOImp.findByName(userName);
                    return doCheck(user, passwd, role);

            }
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());

        }
        return null;
    }

    /**
     * @param userName
     * @param passwd
     * @param type
     * @param degree
     * @param role
     * @return java.util.Map<java.lang.String , java.lang.String>
     * @description 向数据库添加新用户
     * @author getianao
     * @date 2018/12/2 21:13
     */
    public Map<String, String> doRegister(String userName, String passwd, String type, String degree, String role) {

        Map<String, String> map = new HashMap<>();
        try {
            switch (role) {
                case "admin":
                    Admin admin = new Admin(UUID.randomUUID().toString(), userName, passwd);
                    adminDAOImp.doInsert(admin);
                    map.put("res", admin.getId());
                    return map;
                case "borrower":
                    Borrower borrower = new Borrower(UUID.randomUUID().toString(), userName, type, degree, passwd);
                    borrowerDAOImp.doInsert(borrower);
                    map.put("res", borrower.getId());
                    return map;
                case "operator":
                    Operator operator = new Operator(UUID.randomUUID().toString(), userName, passwd);
                    operatorDAOImp.doInsert(operator);
                    map.put("res", operator.getId());
                    return map;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        map.put("res", "-1");
        return map;
    }


}
