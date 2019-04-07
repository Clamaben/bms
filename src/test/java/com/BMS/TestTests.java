package com.BMS;

import com.BMS.dao.BookDAOImp;
import com.BMS.module.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BMSApplication.class)

public class TestTests {
    @Autowired
    BookDAOImp bookDAO;

    @Test
    public void contextLoads() {
        try {
            String bookId = "11";
            Book book = bookDAO.findById(bookId);
            book.setStatus("1");
            bookDAO.doModifyById(bookId, book);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
