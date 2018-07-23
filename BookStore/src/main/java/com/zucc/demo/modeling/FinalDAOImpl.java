package com.zucc.demo.modeling;

import java.sql.*;

public class FinalDAOImpl {
    public static void main(String args[]) throws Exception {
        FinalDAOImpl finalDAO = new FinalDAOImpl();
        if (!finalDAO.getBook(73285))
            System.out.println("1");

    }

    public float getAvgScore_userbook(int userid, int bookid) throws Exception {
        float avg = 0;
        Connection con = getConnection();
        try {
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select avg(score) from ratings_train where user_id=" + userid + " or item_id=" + bookid);
            if (rs.next()) {
                avg = rs.getFloat(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        } finally {
            con.close();
        }

        return avg;
    }


    public float getAvgScore_user(int userid) throws Exception {
        float avg = 0;
        Connection con = getConnection();
        try {
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select avg(score) from ratings_train where user_id=" + userid);
            if (rs.next()) {
                avg = rs.getFloat(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        } finally {
            con.close();
        }

        return avg;
    }

    public float getAvgScore_book(int bookid) throws Exception {
        float avg = 0;
        Connection con = getConnection();
        try {
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select avg(score) from ratings_train where item_id=" + bookid);
            if (rs.next()) {
                avg = rs.getFloat(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        } finally {
            con.close();
        }

        return avg;
    }


    public float getAvgScore_all() throws Exception {
        Connection con = getConnection();
        float avg = 0;
        try {

            Statement st = null;
            st = con.createStatement();

            ResultSet rs = st.executeQuery("select avg(score) from ratings_train ");
            if (rs.next()) {
                avg = rs.getFloat(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        } finally {
            con.close();
        }

        return avg;
    }

    public boolean getUser(int userid) throws Exception {
        Connection con = getConnection();
        try {

            Statement st = null;
            st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from ratings_train where user_id=" + userid);
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        } finally {
            con.close();
        }

        return false;
    }


    public boolean getBook(int bookid) throws Exception {
        Connection con = getConnection();
        try {
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ratings_train where item_id=" + bookid);
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("数据库查询错误");
        } finally {
            con.close();
        }
        return false;
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
