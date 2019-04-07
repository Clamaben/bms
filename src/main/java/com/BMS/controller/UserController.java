package com.BMS.controller;

import com.BMS.module.Admin;
import com.BMS.module.Borrower;
import com.BMS.module.Operator;
import com.BMS.service.UserService;
import com.BMS.util.BMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/{role}/doAddUser")
    public String userSetting(@PathVariable("role") String role, @RequestParam(value = "type",required = false) String type, @RequestParam(value = "degree",required = false) String degree, String id, String name, String password) {
        if (role.equals("borrower")) {
            Borrower borrower = new Borrower(id, name, password, type, degree);
            if (userService.addBorrower(borrower)) {
                return BMSUtil.getJSONString(0, "添加成功");
            } else {
                return BMSUtil.getJSONString(1, "添加失败");

            }
        }
        if (role.equals("admin")) {
            Admin admin = new Admin(id, name, password);
            if (userService.addAdmin(admin)) {
                return BMSUtil.getJSONString(0, "添加成功");
            } else {
                return BMSUtil.getJSONString(1, "添加失败");

            }
        }if (role.equals("operator")) {
            Operator operator= new Operator(id, name, password);
            if (userService.addOperator(operator)) {
                return BMSUtil.getJSONString(0, "添加成功");
            } else {
                return BMSUtil.getJSONString(1, "添加失败");

            }
        }

        return BMSUtil.getJSONString(1, "添加失败");
    }

}
