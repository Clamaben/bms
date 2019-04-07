package com.BMS.controller;

import com.BMS.dao.AdminDAOImp;
import com.BMS.dao.BorrowerDAOImp;
import com.BMS.dao.OperatorDAOImp;
import com.BMS.module.*;
import com.BMS.service.UserService;
import com.BMS.util.BMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SettingController {
    @Autowired
    UserService userService;
    @Autowired
    HostHolder hostHolder;
    @RequestMapping("/borrower/setting")
    public String borrowerSetting(Model model){
        model.addAttribute("user", hostHolder.getUser());

        return "/test/borrower/Setting";
    }
    @RequestMapping("/operator/setting")
    public String operatorSetting(Model model){
        model.addAttribute("user", hostHolder.getUser());

        return "/test/operator/Setting";
    }
    @RequestMapping("/admin/setting")
    public String adminSetting(Model model){
        model.addAttribute("user", hostHolder.getUser());

        return "/test/admin/Setting";
    }

    @RequestMapping(value="/doSetting/{role}", method = {RequestMethod.GET, RequestMethod.POST})

    public String userSetting(Model model,@PathVariable("role") String role, String name, String password) throws Exception{
        User user=hostHolder.getUser();
        if (role.equals("borrower")) {
            BorrowerDAOImp BorrowerDAO =new BorrowerDAOImp();
            Borrower borrower = BorrowerDAO.findById(user.getId());
            borrower.setName(name);
            borrower.setPassword(password);
            if (userService.doUpdate(borrower, role, user.getId())) {
                model.addAttribute("information", "修改成功");
                return "/test/borrower/Setting";
            } else {
                model.addAttribute("information", "修改失败");
                return "/test/borrower/Setting";

            }
        }
        if (role.equals("admin")) {
            Admin admin = new AdminDAOImp().findById(user.getId());
            admin.setName(name);
            admin.setPassword(password);
            if (userService.doUpdate(admin, role, user.getId())) {
                model.addAttribute("information", "修改成功");
                return "/test/admin/Setting";
            } else {
                model.addAttribute("information", "修改失败");
                return "/test/admin/Setting";

            }
        }if (role.equals("operator")) {
            Operator operator = new OperatorDAOImp().findById(user.getId());
            operator.setName(name);
            operator.setPassword(password);
                if (userService.doUpdate(operator, role, user.getId())) {
                    model.addAttribute("information", "修改成功");
                    return "/test/operator/Setting";
                } else {
                    model.addAttribute("information", "修改失败");
                    return "/test/operator/Setting";

            }
        }

        return BMSUtil.getJSONString(1, "未知的角色名");
    }


}
