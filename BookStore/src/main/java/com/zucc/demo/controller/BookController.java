package com.zucc.demo.controller;

import com.zucc.demo.dao.BookDAO;
import com.zucc.demo.model.BookVo;
import com.zucc.demo.dao.RatingDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookDAO bookDAO;
    @Autowired
    RatingDAO ratingDAO;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ModelAndView bookPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("book");
        return mav;
    }

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public ModelAndView searchPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("searchresult");
//        return mav;
//    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String msg = "{\"content\":\"Correct\",\"flag\":true}";
        try {
            if (title == null || title.equals("")){
                throw new Exception("Please enter title.");
            }
//            List<BookVo> result=new ArrayList<>();
//            List<BookVo> books=bookDAO.getAllBooks();
//            for(BookVo book:books){
//                if (book.getTitle().contains(title)) {
//                    result.add(book);
//                }
//            }
            List result=bookDAO.searchBook(title);
            if (result.size() == 0)
                throw new Exception("Book not exist.");
            request.getSession().setAttribute("objlist1", result);
            msg = "{\"content\":\"Correct\",\"flag\":true}";
        } catch (Exception ex) {
            msg = "{\"content\":\""+ex.getMessage()+"\",\"flag\":false}";
        }
        finally {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(msg);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    //@ResponseBody
    private String ratingBooks2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userid = request.getParameter("id");
        String msg = "{\"flag\":true}";
        try {
            int id = Integer.parseInt(userid);
            List result = ratingDAO.loadRatingBooks(id);
            if (result.size() == 0) {
                System.out.print("No rating books");
            }
         /*   if (result == null) {
                throw new Exception("You haven't scored books yet.");
            }*/
            request.getSession().setAttribute("ratinglist", result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(msg);
        }
        return "searchresult";
    }

    @RequestMapping(value = "/bookdetail", method = RequestMethod.GET)
//    @ResponseBody
    private String bookDetail(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        try {
            BookVo book = bookDAO.getBook(isbn);
            request.getSession().setAttribute("book", book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "book";
    }

}
