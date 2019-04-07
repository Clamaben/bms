package com.BMS.service;

import com.BMS.dao.LoginTicketDAO;
import com.BMS.module.LoginTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginTicketService {
    @Autowired
    LoginTicketDAO loginTicketDAO;
    private final static Logger logger = LoggerFactory.getLogger(LoginTicketService.class);

    public boolean updateLoginTicket(String ticket, Date date) {
        try {
            LoginTicket loginTicket = loginTicketDAO.selectByTicket(ticket);
            loginTicket.setExpired(date);//设为注销状态
            loginTicketDAO.doModifyById(ticket, loginTicket);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }



    public boolean updateLoginTicket(String ticket, int status) {
        try {
            LoginTicket loginTicket = loginTicketDAO.selectByTicket(ticket);
            loginTicket.setStatus(1);//设为注销状态
            loginTicketDAO.doModifyById(ticket, loginTicket);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public LoginTicket findLoginTicketById(String ticket) {
        try {
            return loginTicketDAO.selectByTicket(ticket);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public boolean saveLoginTicket(LoginTicket loginTicket) {
        try {
            return loginTicketDAO.insertLoginTicket(loginTicket);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

}
