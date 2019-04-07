package com.BMS.controller;

import com.BMS.dao.BorrowRecordDAOImp;
import com.BMS.module.Book;
import com.BMS.module.BorrowRecord;
import com.BMS.module.HostHolder;
import com.BMS.module.User;
import com.BMS.service.BookService;
import com.BMS.service.RecordService;
import com.BMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    UserService userService;
    @Autowired
    RecordService recordService;



    @RequestMapping("/borrower/order")
    public String doBookOrder(@RequestParam("bookId") String bookId) {
        bookService.bookOrder(bookId, hostHolder.getUser().getId());

        return "test/borrower/querybook";
    }


    /**
     * @param bookName
     * @return java.util.List<com.BMS.module.Book>
     * @description 按照书名查询图书
     * @author getianao
     * @date 2018/12/2 18:02
     */
//    @RequestMapping(value = "/doQueryBook", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public Model doQueryBook(@RequestParam("bookName") String bookName, Model model) {
//        List<Book> bookList = null;
//        bookList = bookService.findBooksByName(bookName);
//        model.addAttribute("bookList", bookList);
//        model.addAttribute("bookListNum", bookList.size());
//        return model;
//    }


    /**
     * @param model
     * @return org.springframework.ui.Model
     * @description 查询所有图书
     * @author getianao
     * @date 2018/12/2 22:24
     */
    @RequestMapping(value = {"/doQueryBook"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String doQueryAllBook(HttpServletRequest request, HttpServletResponse response, Model model,
                                 @RequestParam(value = "bookName",defaultValue = "null")String keyWord) {
        if (keyWord.equals("null")) {
            List<Book> bookList = null;
            bookList = bookService.findAllBooks();
            model.addAttribute("bookList", bookList);
            return "test/borrower/queryBook";
        }

        List<Book> bookList = null;
        bookList = bookService.findBooksByName(keyWord);
        model.addAttribute("bookList", bookList);
        model.addAttribute("bookName",keyWord);
        return "test/borrower/queryBook";
    }
    @RequestMapping(value = {"/RecommendBook"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String RecommendBook(HttpServletRequest request, HttpServletResponse response, Model model)
    {

        List<Book> bookList = null;
        bookList = bookService.recommendBook();
        model.addAttribute("bookList", bookList);
        return "test/borrower/Home_borrower";

    }
    @RequestMapping(value = {"/doQueryAllBook"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String doQueryAllBook(HttpServletRequest request, HttpServletResponse response, Model model)
       {

            List<Book> bookList = null;
            bookList = bookService.findAllBooks();
            model.addAttribute("bookList", bookList);
            return "test/borrower/Home_borrower";

    }


    @RequestMapping(value = {"/dealbook"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String dealbook(HttpServletRequest request, HttpServletResponse response, Model model,
                           @RequestParam(value = "bookName",defaultValue = "null")String keyWord)
    {
        if (keyWord.equals("null")) {
            List<Book> bookList = null;
            bookList = bookService.findAllBooks();
            model.addAttribute("bookList", bookList);
            return "test/operator/dealbook";
        }

        List<Book> bookList = null;
        bookList = bookService.findBooksByName(keyWord);
        model.addAttribute("bookList", bookList);
        model.addAttribute("bookName",keyWord);
        return "test/operator/dealbook";

    }

    /**
     * @param name
     * @param ISBN
     * @param type
     * @param description
     * @return java.lang.String
     * @description 添加图书
     * @author getianao
     * @date 2018/12/2 18:20
     */
    @RequestMapping(value = "/doAddBook", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String doAddBook(@RequestParam("name") String name,
                            @RequestParam("ISBN") String ISBN,
                            @RequestParam("type") String type,
                            @RequestParam("description") String description,
                            @RequestParam("img_url") String img_url,
                            @RequestParam("status") String status){
        Map map;
        map = bookService.addBook(name, ISBN, type, description, img_url,status);
        if (map.get("res").equals("-1")) {//添加书籍至数据库失败

            return "doAddBook?pop=1";//提示失败
        } else {
            return "doAddBook?pop=2";//提示成功
        }
    }

    @RequestMapping(value = "/admin/AddBook")
    public String AddBook() {
      return "/test/admin/addbook";
    }
    @RequestMapping(value = "/admin/UpdataBook")
    public String UpdataBook() {
        return "/test/admin/updatabook";
    }

    /**
     * @param id
     * @return java.lang.String
     * @description
     * @author getianao
     * @date 2018/12/2 19:49
     */
    @RequestMapping(value = "/doModifyBookById", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String doModifyBookById(@RequestParam("Id") String id,
                                   @RequestParam("name") String name,
                                   @RequestParam("ISBN") String ISBN,
                                   @RequestParam("type") String type,
                                   @RequestParam("description") String description,
                                   @RequestParam("img_url") String img_url,
                                   @RequestParam("status") String status) {
        Map map;
        map = bookService.modifyBookById(id, name, ISBN, type, description, img_url,status);
        if (map.get("res").equals("-1")) {//添加书籍至数据库失败
            return "doModifyBookById?pop=1";//提示失败
        } else {
            return "doModifyBookById?pop=2";//提示成功
        }
    }

    @RequestMapping(value = "/doDeleteBookById", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String doDeleteBookById(@RequestParam("Id") String id) {
        Map map;
        map = bookService.deleteBookById(id);
        if (map.get("res").equals("-1")) {//添加书籍至数据库失败
            return "doDeleteBookById?pop=1";//提示失败
        } else {
            return "doDeleteBookById?pop=2";//提示成功
        }
    }
}
