package com.BMS.dao;

import com.BMS.module.LoginTicket;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginTicketDAO {

    public LoginTicket selectByTicket(String ticket) throws Exception;

    public boolean insertLoginTicket(LoginTicket loginTicket) throws Exception;

    public boolean doModifyById(String ticket, LoginTicket newLoginTicket) throws Exception;
}
