package com.BMS.controller;

import com.BMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/doRegister", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String doRegister(@RequestParam("userName") String userName,
                             @RequestParam("passwd") String passwd,
                             @RequestParam("type") String type,
                             @RequestParam("degree") String degree,
                             @RequestParam("role") String role) {
        System.out.println("----" + userName + "----" + passwd + "----" + role);
        Map<String, String> map = new HashMap<>();
        map=userService.doRegister( userName,  passwd,  type,  degree,  role);
        if (map.get("res").equals("-1")) {
            return "redirect:/register?pop=1";//提示失败
        }else{
            return "/register";
        }
    }


    @RequestMapping(value = "/register/", method = {RequestMethod.GET, RequestMethod.POST})
    public String showRegister() {
        return "samples/register";
    }


}
