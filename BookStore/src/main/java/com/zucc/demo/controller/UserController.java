package com.zucc.demo.controller;

import com.zucc.demo.dao.*;

import com.zucc.demo.model.BookVo;
import com.zucc.demo.model.RecommendBookVo;
import com.zucc.demo.model.UserVo;
import com.zucc.demo.modeling.Recommend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    BookDAO bookDAO;
    @Autowired
    RatingDAO ratingDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView homePage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("home");
//        return mav;
//    }
//    @RequestMapping(value = "/userdetail", method = RequestMethod.GET)
    private String userDetail(HttpServletRequest request, HttpServletResponse response) {
        String userid = request.getParameter("id");
        try {
            int id = Integer.parseInt(userid);
            UserVo user = userDAO.readUser(id);
            request.getSession().setAttribute("userdetail", user);

            List<RecommendBookVo> recommendBookList = new ArrayList<>();
//            List list=
            if (ratingDAO.loadRatingBooks(id).size() != 0) {
                Recommend recommend = new Recommend();
                recommendBookList = recommend.baseItemCF_jdbc(id);
            }

            if (recommendBookList.size() < 15) {
                List<RecommendBookVo> list1 = new ArrayList<>();
                int n = 15 - recommendBookList.size();
                List<BookVo> books = new BookDAOImpl().getRandomBooks(n);
                for (int i = 0; i < books.size(); i++) {
                    RecommendBookVo recommendBook1 = new RecommendBookVo();
                    recommendBook1.setBook(books.get(i));
                    recommendBook1.setRating(0);
                    list1.add(recommendBook1);
                }
                recommendBookList.addAll(list1);
            }
            request.getSession().setAttribute("list", recommendBookList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("login{}");
        String userid = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String msg = "{\"content\":\"Correct\",\"flag\":true}";
        try {
            if (userid == null || userid.equals(""))
                throw new Exception("Please enter your userid.");
            int id = Integer.parseInt(userid);
            if (pwd == null || userid.equals(""))
                throw new Exception("Please enter your password.");
            UserVo user = userDAO.readUser(id);
            if (user == null)
                throw new Exception("User not exist.");
            if (!pwd.equals(user.getPassword()))
                throw new Exception("Password error.");
//            List result = ratingDAO.loadRatingBooks(id);
//            request.getSession().setAttribute("ratingbooks", result);
        } catch (Exception ex) {
            msg = "{\"content\":\"" + ex.getMessage() + "\",\"flag\":false}";
        } finally {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(msg);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("register{}");
        int id = Integer.parseInt(request.getParameter("id"));
        String pwd = request.getParameter("pwd");
        String location = new String(request.getParameter("location").getBytes("iso-8859-1"), "utf-8");
        String age = request.getParameter("age");
        String msg = "";
        try {
            if (pwd == null || pwd.equals(""))
                throw new Exception("Please enter your password.");
            if (location == null || location.equals(""))
                throw new Exception("Please enter your location.");
            if (age == null || age.equals(""))
                throw new Exception("Please enter your age.");
            UserVo user = new UserVo();
            user.setId(id);
            user.setLocation(location);
            user.setPassword(pwd);
            user.setAge(age);
            user = userDAO.addUser(user);
            msg = "{\"content\":\"" + user.getId() + "\",\"flag\":true}";
        } catch (Exception ex) {
            msg = "{\"content\":\"" + ex.getMessage() + "\",\"flag\":false}";
        } finally {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(msg);
        }
    }


}
