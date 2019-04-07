package com.BMS.service;

import com.BMS.dao.BookDAOImp;
import com.BMS.dao.BorrowRecordDAOImp;
import com.BMS.module.Book;
import com.BMS.module.BorrowRecord;
import com.BMS.util.BMSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    @Autowired
    BookDAOImp bookDAO;
    @Autowired
    BorrowRecordDAOImp borrowRecordDAO;
    private final static Logger logger = LoggerFactory.getLogger(BookService.class);

    public String bookOrder(String bookId, String borrowerId) {
        try {
            Book book = bookDAO.findById(bookId);
            book.setStatus("2");
            bookDAO.doModifyById(bookId, book);
            BorrowRecord br = new BorrowRecord();
            br.setBookId(bookId);
            br.setBorrowerId(borrowerId);
            Date date = new Date();
            Date dueDate=new Date(date.getTime()+1000*60*60*24*30);
            br.setBorrowTime(date);
            br.setDueTime(dueDate);
            br.setStatus("2");//预定状态
            borrowRecordDAO.doInsert(br);
            return BMSUtil.getJSONString(0, "添加书籍成功");
        } catch (Exception e) {
            logger.error("预定书籍发生错误:  " + e.getMessage());
            return BMSUtil.getJSONString(1, "添加书籍失败");

        }

    }
    public Book findBooksById(String id) {
        Book book=null;
        try {
            book = bookDAO.findById(id);
            return book;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    /**
     * @param bookName
     * @return java.util.List<com.BMS.module.Book>
     * @description 按照书名通过数据库找书
     * @author getianao
     * @date 2018/12/2 19:37
     */
    public List<Book> findBooksByName(String bookName) {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.findByName(bookName);
            return bookList;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public List<Book> recommendBook() {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.getAllRecomendBook();
            return bookList;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    /**
     * @param
     * @return java.util.List<com.BMS.module.Book>
     * @description 通过数据库找所有书
     * @author getianao
     * @date 2018/12/2 22:22
     */
    public List<Book> findAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.findAll();
            return bookList;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * @param name
     * @param ISBN
     * @param type
     * @param descp
     * @param img_url
     * @return java.util.Map<java.lang.String , java.lang.Object> 操作状态
     * @description 向数据库添加一本新书
     * @author getianao
     * @date 2018/12/2 19:42
     */
    public Map<String, Object> addBook(String name, String ISBN, String type, String descp, String img_url,String status) {
        Book book = new Book(UUID.randomUUID().toString(), name, ISBN, type, descp, img_url,status);
        Map<String, Object> map = new HashMap<>();
        try {
            if (bookDAO.doInsert(book)) {
                map.put("res", "0");//成功
            } else {
                map.put("res", "-1");
            }
        } catch (Exception e) {
            map.put("res", "-1");
            logger.error(e.getMessage());
        }
        return map;
    }

    /**
     * @param id
     * @param name
     * @param ISBN
     * @param type
     * @param descp
     * @param img_url
     * @return java.util.Map<java.lang.String , java.lang.Object> 返回操作状态
     * @description 通过id修改数据库书籍信息，原id不变
     * @author getianao
     * @date 2018/12/2 19:52
     */
    public Map<String, Object> modifyBookById(String id, String name, String ISBN,
                                              String type, String descp, String img_url,String status) {
        Book book = new Book(id, name, ISBN, type, descp, img_url,status);
        Map<String, Object> map = new HashMap<>();
        try {
            if (bookDAO.doModifyById(id, book)) {
                map.put("res", "0");//成功
            } else {
                map.put("res", "-1");
            }
        } catch (Exception e) {
            map.put("res", "-1");
            logger.error(e.getMessage());
        }
        return map;
    }
    public Map<String, Object> modifyBookById(String id, Book book) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (bookDAO.doModifyById(id, book)) {
                map.put("res", "0");//成功
            } else {
                map.put("res", "-1");
            }
        } catch (Exception e) {
            map.put("res", "-1");
            logger.error(e.getMessage());
        }
        return map;
    }

    /**
     * @param id
     * @return java.util.Map<java.lang.String , java.lang.Object>
     * @description 删除数据库中书籍
     * @author getianao
     * @date 2018/12/2 19:57
     */
    public Map<String, Object> deleteBookById(String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (bookDAO.doDeleteById(id)) {
                map.put("res", "0");//成功
            } else {
                map.put("res", "-1");
            }
        } catch (Exception e) {
            map.put("res", "-1");
            logger.error(e.getMessage());
        }
        return map;
    }
}

