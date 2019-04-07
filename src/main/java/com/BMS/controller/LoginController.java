package com.BMS.controller;

import com.BMS.service.LoginTicketService;
import com.BMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    LoginTicketService loginTicketService;


    /**
     * 实现注销功能
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout/")
    public String doLogout(HttpServletRequest request) {
        for (Cookie coockie : request.getCookies()) {
            if (coockie.getName().equals("ticket")) {
                String ticket = coockie.getValue();
                if (loginTicketService.updateLoginTicket(ticket, 1)) {
                        return "redirect:/login/";
                }
            }
        }

        return "redirect:/showIndex?pop=9";//提示注销失败

    }


    @RequestMapping(value = "/doLogin", method = {RequestMethod.GET, RequestMethod.POST})

    public String doLogin(@RequestParam("userName") String userName,
                          @RequestParam("passwd") String passwd,
                          @RequestParam("role") String role,
                          HttpServletResponse response) {


        Map<String, Object> map = userService.doLogin(userName, passwd, role);
        if (map.get("res").equals("-1")) {
            return "redirect:/login/";
        }

        Cookie cookie = new Cookie("ticket", (String) map.get("ticket"));
        cookie.setPath("/");

        response.addCookie(cookie);
        if (role.equals("borrower")){
            return "redirect:/doQueryAllBook";
        }
        return "test/"+role+"/Home_"+role;
    }


    @RequestMapping(value = {"/login/", "/"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String showLogin() {
        return "test/login";

    }


}
