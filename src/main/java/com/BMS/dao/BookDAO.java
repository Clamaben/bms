package com.BMS.dao;

import com.BMS.module.Book;

import java.util.List;

public interface BookDAO {
    public boolean doInsert(Book book) throws Exception;

    public boolean doModifyById(String bookId,Book newBook) throws Exception;

    public boolean doDeleteById(String bookId) throws Exception;

    public List<Book> findAll() throws Exception;

    public Book findById(String bookId) throws Exception;

    public List<Book> findByName(String bookName) throws Exception;



    public List<Book> getAllRecomendBook() throws Exception;
}
