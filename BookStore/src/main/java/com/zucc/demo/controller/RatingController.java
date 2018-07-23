package com.zucc.demo.controller;

import com.zucc.demo.dao.BookDAO;
import com.zucc.demo.dao.RatingDAO;
import com.zucc.demo.modeling.Recommend;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RatingController {

    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    RatingDAO ratingDAO;
    @Autowired
    BookDAO bookDAO;

    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public ModelAndView ratingPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("rating");
        return mav;
    }

    @RequestMapping(value = "/bookrating", method = RequestMethod.GET)
//    @ResponseBody
    private String ratingBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userid = request.getParameter("id");
        String msg = "{\"flag\":true}";
        try {
            int id = Integer.parseInt(userid);
            List result = ratingDAO.loadRatingBooks(id);
            if (result.size() == 0) {
                System.out.print("No");
            }
         /*   if (result == null) {
                throw new Exception("You haven't scored books yet.");
            }*/
            request.getSession().setAttribute("objlist", result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(msg);
        }
        return "rating";
    }

    @RequestMapping(value = "/rate", method = RequestMethod.POST)
    private void rateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("rate{}");
        int id = Integer.parseInt(request.getParameter("id"));
        String isbn = request.getParameter("isbn");
        String rating = request.getParameter("rating");
        String msg = "";
        try {
            if (rating == null || rating.equals(""))
                throw new Exception("Please enter your rating.");
            if (!isNumeric(rating)) {
                throw new Exception("Please enter an integer.");
            }
            if (Integer.valueOf(rating).intValue() > 10 || Integer.valueOf(rating).intValue() < 0) {
                throw new Exception("Please enter an integer between 0-10");
            }
            int bookid = ratingDAO.searchRating(id, isbn, Integer.parseInt(rating));
            if (bookid != 0)
                throw new Exception("You have already rated.");
            if (bookid == 0) {
                bookid = bookDAO.getBook(isbn).getId();
                ratingDAO.addRating(id, bookid, isbn, Integer.parseInt(rating));

                Recommend.model = new ReloadFromJDBCDataModel(Recommend.dataModel);
                //书籍相似度
                Recommend.itemsimilarity = new EuclideanDistanceSimilarity(Recommend.model);
                //物品推荐算法
                Recommend.recommender = new GenericItemBasedRecommender(Recommend.model, Recommend.itemsimilarity);
            }
            msg = "{\"content\":\"Correct\",\"flag\":true}";
        } catch (Exception ex) {
            msg = "{\"content\":\"" + ex.getMessage() + "\",\"flag\":false}";
        } finally {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(msg);
        }
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
