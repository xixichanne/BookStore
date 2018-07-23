package com.zucc.demo.dao;

import com.zucc.demo.model.UserVo;
import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public UserVo addUser(UserVo user) throws Exception {
        Connection con = getConnection();
        try {
//            con.setAutoCommit(false);
            PreparedStatement st = null;
//            ResultSet rs = st.executeQuery("select max(user_id) from users");
//            if (rs.next()) {
//                int id = rs.getInt(1) + 1;
//                user.setId(id);
//            }
            String sql = "insert into users(user_id,password,location,age) values(?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setInt(1, user.getId());
            st.setString(2, user.getPassword());
            st.setString(3, user.getLocation());
            st.setString(4, user.getAge());
            st.execute();

//            con.commit();
        } catch (SQLException ex) {
//            con.rollback();
            ex.printStackTrace();
            throw new SQLException("数据库错误");
        }
        return user;
    }

    @Override
    public UserVo readUser(int userid) throws Exception {
        UserVo result = new UserVo();
        try {
            Connection con = getConnection();
            Statement st = null;
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where user_id=" + userid );
            if (rs.next()) {
                result.setPassword(rs.getString(2));
                result.setLocation(rs.getString(3));
                result.setAge(rs.getString(4));
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
