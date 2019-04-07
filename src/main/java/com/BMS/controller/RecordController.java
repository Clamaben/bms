package com.BMS.controller;

import com.BMS.module.Book;
import com.BMS.module.BorrowRecord;
import com.BMS.module.HostHolder;
import com.BMS.service.BookService;
import com.BMS.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class RecordController {
    @Autowired
    RecordService recordService;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    BookService bookService;


    @RequestMapping("/borrowed_list")
    public String borrowedList(Model model) {
        List<BorrowRecord> res=recordService.findAllAlreadById(hostHolder.getUser().getId());
        model.addAttribute("borrowedList", res);
        return "/test/borrower/borrowedbook";
    }

    @RequestMapping("/borrower_record")
    public String borrowerRecord(Model model) {
        List<BorrowRecord> res=recordService.findAllById(hostHolder.getUser().getId());
        model.addAttribute("borrowerRecord", res);
        return "/test/borrower/borrowedrecord";
    }
    //操作员确认借书,把Record的STATUS改成1
    @RequestMapping(value = {"/doBorrowerBook"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String doBorrowerBook(String Bookid, Model model)
    {
        String pop=null;
        if (recordService.borrowBook(Bookid,"0")) {
            pop = "0";
        } else {
            pop = "1";
        }

        return "test/operator/dealbook?pop="+pop;

    }
    //操作员确认借书,把Record的STATUS改成1
    @RequestMapping(value = {"/doReturnBook"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String doReturnBook(String Bookid, Model model)
    {
        String pop=null;
        if (recordService.borrowBook(Bookid,"1")) {
            Book book = bookService.findBooksById(Bookid);
            book.setStatus("1");
            if(bookService.modifyBookById(Bookid,book).get("res").equals("0")){
                pop = "0";
            }
            pop = "1";
        } else {
            pop = "1";
        }

        return "test/operator/dealbook?pop="+pop;

    }
}
