package com.zucc.demo.dao;

import com.zucc.demo.model.BookVo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BookDAOImpl implements BookDAO {
    @Override
    public BookVo getBook(String isbn) {
        BookVo book = new BookVo();
        try {
            Connection con = getConnection();
            Statement stmt = null;

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM books where ISBN='" + isbn+"'");
            if (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setIsbn(rs.getString("ISBN"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setYear(rs.getString("year_of_publication"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage_url_s(rs.getString("image_URL_S"));
                book.setImage_url_m(rs.getString("image_URL_M"));
                book.setImage_url_l(rs.getString("image_URL_L"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    @Override
    public BookVo getBook(int id) {
        BookVo book = new BookVo();
        try {
            Connection con = getConnection();
            Statement stmt = null;

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM books where id=" + id);
            if (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setIsbn(rs.getString("ISBN"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setYear(rs.getString("year_of_publication"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage_url_s(rs.getString("image_URL_S"));
                book.setImage_url_m(rs.getString("image_URL_M"));
                book.setImage_url_l(rs.getString("image_URL_L"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    @Override
    public List<BookVo> getAllBooks() {
        List<BookVo> books = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = null;

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM books ");

            while (rs.next()) {
                BookVo book = new BookVo();
                book.setId(rs.getInt("id"));
                book.setIsbn(rs.getString("ISBN"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setYear(rs.getString("year_of_publication"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage_url_s(rs.getString("image_URL_S"));
                book.setImage_url_m(rs.getString("image_URL_M"));
                book.setImage_url_l(rs.getString("image_URL_L"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<BookVo> getRandomBooks(int n) {
        List<BookVo> books = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = null;

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM books ORDER BY RAND() LIMIT " + n);

            while (rs.next()) {
                BookVo book = new BookVo();
                book.setId(rs.getInt("id"));
                book.setIsbn(rs.getString("ISBN"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setYear(rs.getString("year_of_publication"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage_url_s(rs.getString("image_URL_S"));
                book.setImage_url_m(rs.getString("image_URL_M"));
                book.setImage_url_l(rs.getString("image_URL_L"));
                books.add(book);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List searchBook(String title) throws Exception {
        List<BookVo> result = new ArrayList();
        try {
            Connection con = getConnection();
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from books where book_title like'%" +" "+ title +" "+ "%' or book_title like'%"+" "+title+"%' or book_title like'%"+title+" "+"%' or book_title ='"+title+"'");
            while (rs.next()) {
                BookVo book=new BookVo();
                book.setId(rs.getInt(1));
                book.setIsbn(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setYear(rs.getString(5));
                book.setPublisher(rs.getString(6));
                book.setImage_url_s(rs.getString(7));
                book.setImage_url_m(rs.getString(8));
                book.setImage_url_l(rs.getString(9));
                result.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        }

        return result;
    }


    private Connection getConnection() {
        try {
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
        //连接MySql数据库，用户名和密码都是root
        String url = "jdbc:mysql://localhost:3306/bx";
        String username = "root";
        String password = "123456";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }
        return null;
    }
}
