package com.BMS.dao;

import com.BMS.module.Book;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDAOImp implements BookDAO {
    private static Connection con;
    private PreparedStatement stmt = null;

    static {
        con = DBConnection.getConnection();
    }


    @Override
    public boolean doInsert(Book book) throws Exception {
        // sql语句
        String sql = "INSERT INTO book(id,name,ISBN,type,description,img_url,status) VALUES(?,?,?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, book.getId());
        stmt.setString(2, book.getName());
        stmt.setString(3, book.getISBN());
        stmt.setString(4, book.getType());
        stmt.setString(5, book.getDescp());
        stmt.setString(6, book.getImg_url());
        stmt.setString(7, book.getType());
        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doModifyById(String bookId, Book newBook) throws Exception {
        // sql语句
        String sql = "UPDATE book set id=?,name=?,ISBN=?,type=?,description=?,img_url=?,status=? where id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(8, bookId);
        stmt.setString(1, newBook.getId());
        stmt.setString(2, newBook.getName());
        stmt.setString(3, newBook.getISBN());
        stmt.setString(4, newBook.getType());
        stmt.setString(5, newBook.getDescp());
        stmt.setString(6, newBook.getImg_url());
        stmt.setString(7, newBook.getStatus());
        // sql执行语句
        int update = stmt.executeUpdate();
        if (update > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean doDeleteById(String bookId) throws Exception {
        // sql语句
            String sql = "DELETE from book where id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, bookId);
            // sql执行语句
            int update = stmt.executeUpdate();
            if (update > 0) {
                return true;
            } else
                return false;
        }

    @Override
    public List<Book> findAll() throws Exception {
        String sql = "SELECT id,name,ISBN,type,description,img_url,status FROM book";
        stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Book> list = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            String ISBN = rs.getString(3);
            String type = rs.getString(4);
            String descp = rs.getString(5);
            String img_url = rs.getString(6);
            String status = rs.getString(7);

            Book book = new Book(id,name,ISBN,type,descp,img_url,status);
            list.add(book);
        }
        return list;
    }

    @Override
    public Book findById(String bookId) throws Exception {
                String sql = "SELECT id,name,ISBN,type,description,img_url,status FROM book WHERE id=?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1, bookId);
        ResultSet rs = stmt.executeQuery();
        Book book = null;
        if (rs.next()) {
            String name = rs.getString(2);
            String ISBN = rs.getString(3);
            String type = rs.getString(4);
            String descp = rs.getString(5);
            String img_url = rs.getString(6);
            String status = rs.getString(7);

            book = new Book(bookId,name,ISBN,type,descp,img_url,status);

        }
        return book;
    }

    @Override
    public List<Book> findByName(String bookName) throws Exception {
        String sql = "SELECT id,name,ISBN,type,description,img_url,status FROM book where name LIKE ?";
        stmt = con.prepareStatement(sql);
        // 模糊查询（包含输入字段）
        String queryStr="%"+bookName+"%";
        stmt.setString(1,queryStr);
        ResultSet rs = stmt.executeQuery();

        List<Book> list = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString(1);
            String searchedBookName=rs.getString(2);
            String ISBN = rs.getString(3);
            String type = rs.getString(4);
            String descp = rs.getString(5);
            String img_url = rs.getString(6);
            String status = rs.getString(7);


            Book book = new Book(id,searchedBookName,ISBN,type,descp,img_url,status);
            list.add(book);
        }
        return list;
    }



    @Override
    public List<Book> getAllRecomendBook() throws Exception {
        String sql = "SELECT id,name,ISBN,type,description,img_url,status FROM book where  status=0";
        stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        List<Book> list = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString(1);
            String searchedBookName=rs.getString(2);
            String ISBN = rs.getString(3);
            String type = rs.getString(4);
            String descp = rs.getString(5);
            String img_url = rs.getString(6);
            String status = rs.getString(7);
            Book book = new Book(id,searchedBookName,ISBN,type,descp,img_url,status);
            list.add(book);
        }
        return list;
    }
}
