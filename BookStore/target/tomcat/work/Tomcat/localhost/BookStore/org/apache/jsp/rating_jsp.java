/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-18 11:47:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.zucc.demo.model.BookVo;
import com.zucc.demo.model.UserVo;
import com.zucc.demo.model.BookRatingVo;

public final class rating_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>RatedBooks</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"application/x-javascript\"> addEventListener(\"load\", function () {\r\n");
      out.write("        setTimeout(hideURLbar, 0);\r\n");
      out.write("    }, false);\r\n");
      out.write("\r\n");
      out.write("    function hideURLbar() {\r\n");
      out.write("        window.scrollTo(0, 1);\r\n");
      out.write("    } </script>\r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css'/>\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\r\n");
      out.write("    <!-- start plugins -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://apps.bdimg.com/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900'\r\n");
      out.write("          rel='stylesheet'\r\n");
      out.write("          type='text/css'>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

    String id = request.getParameter("id");
    UserVo userdetail = (UserVo) request.getSession().getAttribute("userdetail");
    String text1 = "Location: " + userdetail.getLocation() + "\n";
    String text2 = "Age: " + userdetail.getAge();


      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"container_wrap\">\r\n");
      out.write("        <div class=\"header_top\">\r\n");
      out.write("            <div class=\"col-sm-3 logo\"><a href=\"http://localhost:10080/BookStore/user?id=");
      out.print(id);
      out.write("\"\r\n");
      out.write("                                          class=\"simptip-position-bottom simptip-movable\" data-tooltip=\"home\"><img\r\n");
      out.write("                    src=\"images/logo2.png\" alt=\"\" height=\"30\"/></a></div>\r\n");
      out.write("            <div class=\"col-sm-6 nav\" style=\"float:right\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-3 header_right\" style=\"float:right\">\r\n");
      out.write("                <ul class=\"header_right_box\">\r\n");
      out.write("                    <li><a class=\"simptip-position-bottom simptip-movable\" id=\"information\"\r\n");
      out.write("                           data-tooltip=\"");
      out.print(text1);
      out.print(text2);
      out.write("\"> <img src=\"images/p1.png\" alt=\"\"/></a></li>\r\n");
      out.write("                    <li><p><a id=\"log\" href=\"http://localhost:10080/BookStore/\"\r\n");
      out.write("                              class=\"simptip-position-bottom simptip-movable\">Log In</a></p></li>\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <h2 class=\"m_3\">Rated Books</h2>\r\n");
      out.write("            <div class=\"movie_top\">\r\n");
      out.write("                <div class=\"col-md-12 movie_box\">\r\n");
      out.write("                    ");

                        List<BookRatingVo> objlist = (List) request.getSession().getAttribute("objlist");
//                        List<BookRatingVo> objlist=result;
                        if (objlist != null) {
//                            for (Map.Entry<BookVo, Integer> entry : map.entrySet()) {
                            for (int i = 0; i < objlist.size(); i++) {
                                if (i % 4 == 0) {
                                    BookVo book = objlist.get(i).getBook();
                                    int rating = objlist.get(i).getRating();
                    
      out.write("\r\n");
      out.write("                    <div class=\"movie movie-test movie-test-dark movie-test-left\">\r\n");
      out.write("                        <div class=\"movie__images\">\r\n");
      out.write("                            <a class=\"movie-beta__link\">\r\n");
      out.write("                                <img alt=\"\" src=\"");
      out.print(book.getImage_url_m());
      out.write("\" class=\"img-responsive pics\" alt=\"\"/>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie__info\">\r\n");
      out.write("                            <a class=\"movie__title\">");
      out.print(book.getTitle());
      out.write("\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <p class=\"movie__time\">Author: ");
      out.print(book.getAuthor());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Year: ");
      out.print(book.getYear());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Publisher: ");
      out.print(book.getPublisher());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">ISBN: ");
      out.print(book.getIsbn());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("\r\n");
      out.write("                            <ul class=\"list_6\">\r\n");
      out.write("                                <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                    <p>");
      out.print(rating);
      out.write("\r\n");
      out.write("                                    </p></li>\r\n");
      out.write("                                <div class=\"clearfix\"></div>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                        }
                        if (i % 4 == 1) {
                            BookVo book = objlist.get(i).getBook();
                            int rating = objlist.get(i).getRating();
                    
      out.write("\r\n");
      out.write("                    <!-- Movie variant with time -->\r\n");
      out.write("                    <div class=\"movie movie-test movie-test-dark movie-test-left\">\r\n");
      out.write("                        <div class=\"movie__images\">\r\n");
      out.write("                            <a class=\"movie-beta__link\">\r\n");
      out.write("                                <img alt=\"\" src=\"");
      out.print(book.getImage_url_m());
      out.write("\" class=\"img-responsive pics\" alt=\"\"/>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie__info\">\r\n");
      out.write("                            <a class=\"movie__title\">");
      out.print(book.getTitle());
      out.write("\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <p class=\"movie__time\">Author: ");
      out.print(book.getAuthor());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Year: ");
      out.print(book.getYear());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Publisher: ");
      out.print(book.getPublisher());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">ISBN: ");
      out.print(book.getIsbn());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("\r\n");
      out.write("                            <ul class=\"list_6\">\r\n");
      out.write("                                <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                    <p>");
      out.print(rating);
      out.write("\r\n");
      out.write("                                    </p></li>\r\n");
      out.write("                                <div class=\"clearfix\"></div>\r\n");
      out.write("                            </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        }
                        if (i % 4 == 2) {
                            BookVo book = objlist.get(i).getBook();
                            int rating = objlist.get(i).getRating();
                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"movie movie-test movie-test-light movie-test-right\">\r\n");
      out.write("                        <div class=\"movie__images\">\r\n");
      out.write("                            <a class=\"movie-beta__link\">\r\n");
      out.write("                                <img alt=\"\" src=\"");
      out.print(book.getImage_url_m());
      out.write("\" class=\"img-responsive pics\" alt=\"\"/>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie__info\">\r\n");
      out.write("                            <a class=\"movie__title\">");
      out.print(book.getTitle());
      out.write("\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <p class=\"movie__time\">Author: ");
      out.print(book.getAuthor());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Year: ");
      out.print(book.getYear());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Publisher: ");
      out.print(book.getPublisher());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">ISBN: ");
      out.print(book.getIsbn());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("\r\n");
      out.write("                            <ul class=\"list_6\">\r\n");
      out.write("                                <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                    <p>");
      out.print(rating);
      out.write("\r\n");
      out.write("                                    </p></li>\r\n");
      out.write("                                <div class=\"clearfix\"></div>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                        }
                        if (i % 4 == 3) {
                            BookVo book = objlist.get(i).getBook();
                            int rating = objlist.get(i).getRating();
                    
      out.write("\r\n");
      out.write("                    <div class=\"movie movie-test movie-test-light movie-test-right\">\r\n");
      out.write("                        <div class=\"movie__images\">\r\n");
      out.write("                            <a class=\"movie-beta__link\">\r\n");
      out.write("                                <img alt=\"\" src=\"");
      out.print(book.getImage_url_m());
      out.write("\" class=\"img-responsive pics\" alt=\"\"/>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie__info\">\r\n");
      out.write("                            <a class=\"movie__title\">");
      out.print(book.getTitle());
      out.write("\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <p class=\"movie__time\">Author: ");
      out.print(book.getAuthor());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Year: ");
      out.print(book.getYear());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">Publisher: ");
      out.print(book.getPublisher());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("                            <p class=\"movie__time\">ISBN: ");
      out.print(book.getIsbn());
      out.write("\r\n");
      out.write("                            </p>\r\n");
      out.write("\r\n");
      out.write("                            <ul class=\"list_6\">\r\n");
      out.write("                                <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                    <p>");
      out.print(rating);
      out.write("\r\n");
      out.write("                                    </p></li>\r\n");
      out.write("                                <div class=\"clearfix\"></div>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                                }
                            }
                        }
                    
      out.write("\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                    <!-- Movie variant with time -->\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"clearfix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    if (");
      out.print(id);
      out.write(") {\r\n");
      out.write("        document.getElementById(\"log\").innerText = \"Your ID:\" +");
      out.print(id);
      out.write(";\r\n");
      out.write("        var test = document.getElementById('log');\r\n");
      out.write("        test.dataset.tooltip = 'exit';\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
