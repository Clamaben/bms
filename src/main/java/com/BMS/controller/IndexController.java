package com.BMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping("/operator/Home")
    public String showIndex() {

        return "/test/operator/Home_operator";
    }
    @RequestMapping("/admin/Home")
    public String showIndex1() {

        return "/test/admin/Home_operator";
    }
    @RequestMapping(value = "/admin/AddUser")
    public String AddUser() {
        return "/test/admin/addUser";
    }
    @RequestMapping(value = "/admin/UpdataUser")
    public String UpdataUser() {
        return "/test/admin/updataUser";
    }
    @RequestMapping("/test/borrower/Home_borrower")
    public String showtest() {

        return "";
    }
}
