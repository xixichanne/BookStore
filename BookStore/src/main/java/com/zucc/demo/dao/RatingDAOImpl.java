package com.zucc.demo.dao;

import com.zucc.demo.model.BookRatingVo;
import com.zucc.demo.model.BookVo;
import com.zucc.demo.model.UserVo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RatingDAOImpl implements RatingDAO {
    @Override
    public List<BookRatingVo> loadRatingBooks(int userid) throws Exception {
//        Map<BookVo, Integer> map = new HashMap<BookVo, Integer>();
        List<BookRatingVo> result = new ArrayList();
//        List<BookRatingVo> result = null;
        try {
            Connection con = getConnection();
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ratings where user_id='" + userid + "' order by book_rating desc");
            while (rs.next()) {
                String ISBN = rs.getString("ISBN");
                int rating = rs.getInt("book_rating");
                Statement st1 = null;
                st1 = con.createStatement();
                ResultSet rs1 = st1.executeQuery("select * from books where ISBN='" + ISBN + "'");
                if (rs1.next()) {
                    BookRatingVo bookRating = new BookRatingVo();
                    BookVo book = new BookVo();
                    book.setId(rs1.getInt("id"));
                    book.setIsbn(rs1.getString("ISBN"));
                    book.setTitle(rs1.getString("book_title"));
                    book.setAuthor(rs1.getString("book_author"));
                    book.setYear(rs1.getString("year_of_publication"));
                    book.setPublisher(rs1.getString("publisher"));
                    book.setImage_url_s(rs1.getString("image_URL_S"));
                    book.setImage_url_m(rs1.getString("image_URL_M"));
                    book.setImage_url_l(rs1.getString("image_URL_L"));
                    bookRating.setBook(book);
                    bookRating.setRating(rating);
                    result.add(bookRating);
//                map.put(book,rating);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        }
        return result;
    }

    @Override
    public void addRating(int userid, int bookid, String ISBN, int rating) throws Exception {
        Connection con = getConnection();
        try {
            PreparedStatement st = null;
            String sql = "insert into ratings(user_id,book_id,ISBN,book_rating) values(?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setInt(1, userid);
            st.setInt(2, bookid);
            st.setString(3, ISBN);
            st.setInt(4, rating);
            st.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("数据库错误");
        }
    }

    @Override
    public int searchRating(int userid, String isbn, int rating) throws Exception {
        Connection con = getConnection();
        try {
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ratings where user_id=  '" + userid + "'  and ISBN='" + isbn + "'");
            if (rs.next()) {
                int book_id = rs.getInt("book_id");
                return book_id;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("数据库错误");
        }
        return 0;
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
