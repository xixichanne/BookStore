/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-12 01:20:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class movie_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Movie</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("    <meta name=\"keywords\" content=\"Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,\r\n");
      out.write("Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\"/>\r\n");
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
      out.write("    <link href='http://fonts.useso.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet'\r\n");
      out.write("          type='text/css'>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"container_wrap\">\r\n");
      out.write("        <div class=\"header_top\">\r\n");
      out.write("            <div class=\"col-sm-3 logo\"><a href=\"index.jsp\"><img src=\"images/logo.png\" alt=\"\"/></a></div>\r\n");
      out.write("            <div class=\"col-sm-6 nav\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><span class=\"simptip-position-bottom simptip-movable\" data-tooltip=\"comic\"><a\r\n");
      out.write("                            href=\"movie.jsp\"> </a></span></li>\r\n");
      out.write("                    <li><span class=\"simptip-position-bottom simptip-movable\" data-tooltip=\"movie\"><a\r\n");
      out.write("                            href=\"movie.jsp\"> </a> </span></li>\r\n");
      out.write("                    <li><span class=\"simptip-position-bottom simptip-movable\" data-tooltip=\"video\"><a\r\n");
      out.write("                            href=\"movie.jsp\"> </a></span></li>\r\n");
      out.write("                    <li><span class=\"simptip-position-bottom simptip-movable\" data-tooltip=\"game\"><a\r\n");
      out.write("                            href=\"movie.jsp\"> </a></span></li>\r\n");
      out.write("                    <li><span class=\"simptip-position-bottom simptip-movable\" data-tooltip=\"tv\"><a\r\n");
      out.write("                            href=\"movie.jsp\"> </a></span></li>\r\n");
      out.write("                    <li><span class=\"simptip-position-bottom simptip-movable\" data-tooltip=\"more\"><a\r\n");
      out.write("                            href=\"movie.jsp\"> </a></span></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-3 header_right\">\r\n");
      out.write("                <ul class=\"header_right_box\">\r\n");
      out.write("                    <li><img src=\"images/p1.png\" alt=\"\"/></li>\r\n");
      out.write("                    <li><p><a href=\"login.jsp\">Carol Varois</a></p></li>\r\n");
      out.write("                    <li class=\"last\"><i class=\"edit\"> </i></li>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <h2 class=\"m_3\">Now in the Movie</h1>\r\n");
      out.write("                <div class=\"movie_top\">\r\n");
      out.write("                    <div class=\"col-md-9 movie_box\">\r\n");
      out.write("                        <!-- Movie variant with time -->\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-dark movie-test-left\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/1.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Movie variant with time -->\r\n");
      out.write("                        <!-- Movie variant with time -->\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-dark movie-test-left\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/2.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-light movie-test-right\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/3.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-light movie-test-right\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/4.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-dark movie-test-left\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/5.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-dark movie-test-left\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/6.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-light movie-test-right\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/7.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"#\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"movie movie-test movie-test-light movie-test-right\">\r\n");
      out.write("                            <div class=\"movie__images\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie-beta__link\">\r\n");
      out.write("                                    <img alt=\"\" src=\"images/8.jpg\" class=\"img-responsive\" alt=\"\"/>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"movie__info\">\r\n");
      out.write("                                <a href=\"single.jsp\" class=\"movie__title\">Ipsum (2015) </a>\r\n");
      out.write("                                <p class=\"movie__time\">80 min</p>\r\n");
      out.write("                                <p class=\"movie__option\"><a href=\"single.jsp\">Contray</a> | <a href=\"single.jsp\">Dolor\r\n");
      out.write("                                    sit</a> | <a href=\"single.jsp\">Drama</a></p>\r\n");
      out.write("                                <ul class=\"list_6\">\r\n");
      out.write("                                    <li><i class=\"icon1\"> </i>\r\n");
      out.write("                                        <p>2,548</p></li>\r\n");
      out.write("                                    <li><i class=\"icon3\"> </i>\r\n");
      out.write("                                        <p>546</p></li>\r\n");
      out.write("                                    <li>Rating : &nbsp;&nbsp;<p><img src=\"images/rating1.png\" alt=\"\"></p></li>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                        <!-- Movie variant with time -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-3\">\r\n");
      out.write("                        <div class=\"movie_img\">\r\n");
      out.write("                            <div class=\"grid_2\">\r\n");
      out.write("                                <img src=\"images/pic6.jpg\" class=\"img-responsive\" alt=\"\">\r\n");
      out.write("                                <div class=\"caption1\">\r\n");
      out.write("                                    <ul class=\"list_5 list_7\">\r\n");
      out.write("                                        <li><i class=\"icon5\"> </i>\r\n");
      out.write("                                            <p>3,548</p></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                    <i class=\"icon4 icon6 icon7\"> </i>\r\n");
      out.write("                                    <p class=\"m_3\">Guardians of the Galaxy</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"grid_2 col_1\">\r\n");
      out.write("                            <img src=\"images/pic2.jpg\" class=\"img-responsive\" alt=\"\">\r\n");
      out.write("                            <div class=\"caption1\">\r\n");
      out.write("                                <ul class=\"list_3 list_7\">\r\n");
      out.write("                                    <li><i class=\"icon5\"> </i>\r\n");
      out.write("                                        <p>3,548</p></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <i class=\"icon4 icon7\"> </i>\r\n");
      out.write("                                <p class=\"m_3\">Guardians of the Galaxy</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"grid_2 col_1\">\r\n");
      out.write("                            <img src=\"images/pic9.jpg\" class=\"img-responsive\" alt=\"\">\r\n");
      out.write("                            <div class=\"caption1\">\r\n");
      out.write("                                <ul class=\"list_3 list_7\">\r\n");
      out.write("                                    <li><i class=\"icon5\"> </i>\r\n");
      out.write("                                        <p>3,548</p></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <i class=\"icon4 icon7\"> </i>\r\n");
      out.write("                                <p class=\"m_3\">Guardians of the Galaxy</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <h1 class=\"recent\">Recently Viewed</h3>\r\n");
      out.write("                    <ul id=\"flexiselDemo3\">\r\n");
      out.write("                        <li><img src=\"images/1.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Syenergy 2mm</a>\r\n");
      out.write("                                <p>22.10.2014 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/2.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Surf Yoke</a>\r\n");
      out.write("                                <p>22.01.2015 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/3.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Salty Daiz</a>\r\n");
      out.write("                                <p>22.10.2013 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/4.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Cheeky Zane</a>\r\n");
      out.write("                                <p>22.10.2014 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/5.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Synergy</a>\r\n");
      out.write("                                <p>22.10.2013 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <script type=\"text/javascript\">\r\n");
      out.write("                        $(window).load(function () {\r\n");
      out.write("                            $(\"#flexiselDemo3\").flexisel({\r\n");
      out.write("                                visibleItems: 4,\r\n");
      out.write("                                animationSpeed: 1000,\r\n");
      out.write("                                autoPlay: true,\r\n");
      out.write("                                autoPlaySpeed: 3000,\r\n");
      out.write("                                pauseOnHover: true,\r\n");
      out.write("                                enableResponsiveBreakpoints: true,\r\n");
      out.write("                                responsiveBreakpoints: {\r\n");
      out.write("                                    portrait: {\r\n");
      out.write("                                        changePoint: 480,\r\n");
      out.write("                                        visibleItems: 1\r\n");
      out.write("                                    },\r\n");
      out.write("                                    landscape: {\r\n");
      out.write("                                        changePoint: 640,\r\n");
      out.write("                                        visibleItems: 2\r\n");
      out.write("                                    },\r\n");
      out.write("                                    tablet: {\r\n");
      out.write("                                        changePoint: 768,\r\n");
      out.write("                                        visibleItems: 3\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("\r\n");
      out.write("                        });\r\n");
      out.write("                    </script>\r\n");
      out.write("                    <script type=\"text/javascript\" src=\"js/jquery.flexisel.js\"></script>\r\n");
      out.write("                    <ul id=\"flexiselDemo1\">\r\n");
      out.write("                        <li><img src=\"images/8.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Syenergy 2mm</a>\r\n");
      out.write("                                <p>22.10.2014 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/7.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Surf Yoke</a>\r\n");
      out.write("                                <p>22.01.2015 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/6.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Salty Daiz</a>\r\n");
      out.write("                                <p>22.10.2013 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/1.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Cheeky Zane</a>\r\n");
      out.write("                                <p>22.10.2014 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><img src=\"images/2.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                            <div class=\"grid-flex\"><a href=\"#\">Synergy</a>\r\n");
      out.write("                                <p>22.10.2013 | 14:40</p></div>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <script type=\"text/javascript\">\r\n");
      out.write("                        $(window).load(function () {\r\n");
      out.write("                            $(\"#flexiselDemo1\").flexisel({\r\n");
      out.write("                                visibleItems: 4,\r\n");
      out.write("                                animationSpeed: 1000,\r\n");
      out.write("                                autoPlay: true,\r\n");
      out.write("                                autoPlaySpeed: 3000,\r\n");
      out.write("                                pauseOnHover: true,\r\n");
      out.write("                                enableResponsiveBreakpoints: true,\r\n");
      out.write("                                responsiveBreakpoints: {\r\n");
      out.write("                                    portrait: {\r\n");
      out.write("                                        changePoint: 480,\r\n");
      out.write("                                        visibleItems: 1\r\n");
      out.write("                                    },\r\n");
      out.write("                                    landscape: {\r\n");
      out.write("                                        changePoint: 640,\r\n");
      out.write("                                        visibleItems: 2\r\n");
      out.write("                                    },\r\n");
      out.write("                                    tablet: {\r\n");
      out.write("                                        changePoint: 768,\r\n");
      out.write("                                        visibleItems: 3\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                            });\r\n");
      out.write("\r\n");
      out.write("                        });\r\n");
      out.write("                    </script>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <footer id=\"footer\">\r\n");
      out.write("        <div id=\"footer-3d\">\r\n");
      out.write("            <div class=\"gp-container\">\r\n");
      out.write("                <span class=\"first-widget-bend\"></span>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"footer-widgets\" class=\"gp-footer-larger-first-col\">\r\n");
      out.write("            <div class=\"gp-container\">\r\n");
      out.write("                <div class=\"footer-widget footer-1\">\r\n");
      out.write("                    <div class=\"wpb_wrapper\">\r\n");
      out.write("                        <img src=\"images/f_logo.png\" alt=\"\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <p>It is a long established fact that a reader will be distracted by the readable content of a\r\n");
      out.write("                        page.</p>\r\n");
      out.write("                    <p class=\"text\">There are many variations of passages of Lorem Ipsum available, but the majority\r\n");
      out.write("                        have suffered.</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"footer_box\">\r\n");
      out.write("                    <div class=\"col_1_of_3 span_1_of_3\">\r\n");
      out.write("                        <h3>Categories</h3>\r\n");
      out.write("                        <ul class=\"first\">\r\n");
      out.write("                            <li><a href=\"#\">Dance</a></li>\r\n");
      out.write("                            <li><a href=\"#\">History</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Specials</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col_1_of_3 span_1_of_3\">\r\n");
      out.write("                        <h3>Information</h3>\r\n");
      out.write("                        <ul class=\"first\">\r\n");
      out.write("                            <li><a href=\"#\">New products</a></li>\r\n");
      out.write("                            <li><a href=\"#\">top sellers</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Specials</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col_1_of_3 span_1_of_3\">\r\n");
      out.write("                        <h3>Follow Us</h3>\r\n");
      out.write("                        <ul class=\"first\">\r\n");
      out.write("                            <li><a href=\"#\">Facebook</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Twitter</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Youtube</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <div class=\"copy\">\r\n");
      out.write("                            <p>Copyright &copy; 2015.Company name All rights reserved.<a target=\"_blank\" href=\"#\">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clearfix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
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
