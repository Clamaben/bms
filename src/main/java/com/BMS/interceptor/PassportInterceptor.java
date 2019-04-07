package com.BMS.interceptor;

import com.BMS.dao.LoginTicketDAOImp;
import com.BMS.module.HostHolder;
import com.BMS.module.LoginTicket;
import com.BMS.module.User;
import com.BMS.service.LoginTicketService;
import com.BMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class PassportInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginTicketService loginTicketService;

    @Autowired
    private UserService userService;


    @Autowired
    HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(httpServletRequest.getRequestURI());

        String ticket = null;
        //判断是否有cookie
        if (httpServletRequest.getCookies() != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if (cookie.getName().equals("ticket")) {
                    ticket = cookie.getValue();
                }
            }
        }
        //判断ticket是否有效
        if (ticket != null) {


            LoginTicket loginTicket = loginTicketService.findLoginTicketById(ticket);
            if (loginTicket == null || loginTicket.getExpired().before(new Date()) || loginTicket.getStatus() != 0) {
                return true;
            }
            String role = loginTicket.getRole();
            User user = userService.findByUserIdAndRole(loginTicket.getUserId(), role);


            //保存user到线程中

            hostHolder.setUser(user);
        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && null != hostHolder.getUser()) {
            //视图中加入user

            modelAndView.addObject("user", hostHolder.getUser());
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        hostHolder.removeUser();
    }
}
