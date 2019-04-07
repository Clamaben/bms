package com.BMS.controller;

import com.BMS.module.Book;
import com.BMS.module.HostHolder;
import com.BMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FinanceController {
    @Autowired
    BookService bookService;
    @Autowired
    HostHolder hostHolder;

    @RequestMapping(value = {"/dealfinance"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String showDealfinancePage(HttpServletRequest request, HttpServletResponse response) {
        return "test/operator/dealfinance";
    }

}
