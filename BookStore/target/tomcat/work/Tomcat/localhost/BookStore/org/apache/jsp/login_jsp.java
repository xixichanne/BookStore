/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-17 13:36:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Login</title>\r\n");
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
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n");
      out.write("          integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css\">\r\n");
      out.write("    <script src=\"http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://cdn.bootcss.com/angular-ui-bootstrap/1.3.2/ui-bootstrap-tpls.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css'/>\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\r\n");
      out.write("    <!-- start plugins -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://apps.bdimg.com/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet'\r\n");
      out.write("          type='text/css'>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"container_wrap\">\r\n");
      out.write("        <div class=\"header_top\">\r\n");
      out.write("            <div class=\"col-sm-3 logo\"><a href=\"home.jsp\"><img src=\"images/logo2.png\" alt=\"\" height=\"30\"/></a></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <div class=\"register\">\r\n");
      out.write("                <div class=\"col-md-6 login-left\">\r\n");
      out.write("                    <h3>New Users</h3>\r\n");
      out.write("                    <p>By creating an account with our system,you will be able to browse all the pages,search the movie\r\n");
      out.write("                        infomation,give marks on movies,and we will recommend something you like.</p>\r\n");
      out.write("                    <a class=\"acount-btn\" href=\"register.jsp\">Create an Account</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 login-right\">\r\n");
      out.write("                    <h3>Registered Users</h3>\r\n");
      out.write("                    <p>If you have an account with us, please log in.</p>\r\n");
      out.write("                    <form>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <span>UserID<label>*</label></span>\r\n");
      out.write("                            <input type=\"text\" id=\"id\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <span>Password<label>*</label></span>\r\n");
      out.write("                            <input type=\"password\" id=\"pwd\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input type=\"button\" value=\"Login\" onclick=\"login()\">\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clearfix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/login.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    function login() {\r\n");
      out.write("        var id = document.getElementById(\"id\").value;\r\n");
      out.write("        var pwd = document.getElementById(\"pwd\").value;\r\n");
      out.write("        var url = \"http://localhost:10080/BookStore/user?id=\";\r\n");
      out.write("        var xmlhttp = new XMLHttpRequest();\r\n");
      out.write("        xmlhttp.open(\"POST\", \"login\", true);\r\n");
      out.write("        xmlhttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\r\n");
      out.write("        xmlhttp.send(\"id=\" + id + \"&pwd=\" + pwd);\r\n");
      out.write("        xmlhttp.onreadystatechange = function () {\r\n");
      out.write("            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\r\n");
      out.write("                var response = xmlhttp.responseText;\r\n");
      out.write("                response = JSON.parse(response);\r\n");
      out.write("                if (response.flag) {\r\n");
      out.write("                    window.open(url + id,\"_self\");\r\n");
      out.write("                }\r\n");
      out.write("                else {\r\n");
      out.write("                    alert(response.content);\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        };\r\n");
      out.write("    }\r\n");
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
