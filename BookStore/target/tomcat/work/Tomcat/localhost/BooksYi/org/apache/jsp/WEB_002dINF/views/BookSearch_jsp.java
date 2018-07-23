/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-07-09 12:16:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class BookSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>图书搜索</title>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css\">\n");
      out.write("    <script src=\"http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js\"></script>\n");
      out.write("\n");
      out.write("    <script src=\"https://cdn.bootcss.com/angular-ui-bootstrap/1.3.2/ui-bootstrap-tpls.js\"></script>\n");
      out.write("    \t<link rel=\"stylesheet\" href=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\t<script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("\t<script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<style type=\"text/css\">\n");
      out.write("    .position{\n");
      out.write("      text-align:right;\n");
      out.write("      position:absolute;\n");
      out.write("      right: 40%;\n");
      out.write("      bottom: 0%;\n");
      out.write("      margin-bottom:0px;\n");
      out.write("      margin-right:150px;\n");
      out.write("      font-size:18px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body style=\"background:#424c50\">\n");
      out.write("\n");
      out.write("<div ng-app=\"myApp\" ng-controller=\"myCtrl\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"jumbotron\" style=\"background:#424c50\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <input type=\"text\" ng-model=\"selected\"  uib-typeahead=\"n.title as n.title+'<'+n.score+'>' for n in suggestWords($viewValue)\"\n");
      out.write("                           typeahead-loading=\"loadingLocations\" typeahead-no-results=\"noResults\" class=\"form-control\" style=\"height:45px;font-size:18px;color:#789262\">\n");
      out.write("                <i ng-show=\"loadingLocations\" class=\"glyphicon glyphicon-refresh\"></i>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"btn-group\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-success dropdown-toggle btn-lg\" data-toggle=\"dropdown\" style=\"background:#789262;border-color:#789262\">Search\n");
      out.write("                    <span class=\"caret\"></span>\n");
      out.write("                </button>\n");
      out.write("                <ul class=\"dropdown-menu\" role=\"menu\">\n");
      out.write("                    <li>\n");
      out.write("                    <a href=\"#\" ng-click=\"getTitlePages();getNum();getTime()\">书名</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                     <a href=\"#\" ng-click=\"getAuthorPages();getNum();getTime()\">作者</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                    <a href=\"#\" ng-click=\"getIsbnPages();getNum();getTime()\">ISBN</a>\n");
      out.write("                    </li>\n");
      out.write("                 </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"searchword\">\n");
      out.write("            <table width=\"50%\" frame=void rules=none align=left style=\"border-collapse:separate;border-spacing:10px\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                    <td ng-repeat=\"hot in list\" style=\"font-size:18px;color:#fff\">\n");
      out.write("                        <a ng-click=\"hotsearch(hot.type,hot.word);getNum();getTime()\">#{{hot.word}}</a>\n");
      out.write("                    </td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("         </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("        <div class=\"row marketing\" >\n");
      out.write("            ");
//<p style="font-size:12px;color:#789262">共查找到{{num}}个结果，耗时{{time}}ms</p>
      out.write("\n");
      out.write("            <table width=\"60%\" frame=void rules=none align=center style=\"float:left;border-collapse:separate;border-spacing:10px\">\n");
      out.write("                <thead>\n");
      out.write("                <tr bgcolor=\"#789262\" style=\"font-size:20px;color:white\">\n");
      out.write("                    <th width=\"60%\"</th>\n");
      out.write("                    <th></th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                <tr ng-repeat=\"page in records | startFrom:currentPage*pageSize | limitTo:pageSize\" style=\"font-size:18px;color:#789262\">\n");
      out.write("                    <td><a href=\"javascript:void(0)\" title=\"{{page.isbn}}\" onclick=\"check(title)\">《{{page.title}}》</a></td>\n");
      out.write("                    <td>{{page.author}}</td>\n");
      out.write("                </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <div class=\"position \" id=\"d1\" style=\"font-size:20px;color:white\">\n");
      out.write("                <button class=\"btn btn-success\" ng-disabled=\"currentPage == 0\" ng-click=\"currentPage=currentPage-1\">\n");
      out.write("                    Previous\n");
      out.write("                </button>\n");
      out.write("                {{currentPage+1}}/{{numberOfPages()}}\n");
      out.write("                <button class=\"btn btn-info\" ng-disabled=\"currentPage >= records.length/pageSize - 1\" ng-click=\"currentPage=currentPage+1\">\n");
      out.write("                    Next\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("            <table width=\"25%\" frame=void rules=none style=\"float:right;border-collapse:separate;border-spacing:10px\">\n");
      out.write("                <thead>\n");
      out.write("                <tr bgcolor=\"#424c50\" style=\"font-size:20px;color:white\">\n");
      out.write("                    <th><a ng-click=\"getListByHot()\">热门</a>|<a ng-click=\"getListByScore()\">高分</a></th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                <tr ng-repeat=\"book in books\" style=\"font-size:18px;color:#789262\">\n");
      out.write("                    <td><a href=\"javascript:void(0)\" title=\"{{book.isbn}}\" onclick=\"check(title)\">《{{book.title}}》</a></td>\n");
      out.write("                </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var app = angular.module('myApp', ['ui.bootstrap']);\n");
      out.write("    app.controller('myCtrl', function($scope, $http) {\n");
      out.write("        $scope.num = 0;\n");
      out.write("        $scope.time = 0;\n");
      out.write("        $scope.currentPage = 0;\n");
      out.write("        $scope.pageSize = 10;\n");
      out.write("        $scope.searchword = \"\";\n");
      out.write("        $scope.words = [];\n");
      out.write("\n");
      out.write("        window.onload = function() {\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getSearchwords.do\",\n");
      out.write("                data: {word: null}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.list = data;\n");
      out.write("            })\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getListByHot.do\",\n");
      out.write("                data: {word: null}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.books = data;\n");
      out.write("            })\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        $scope.getNum = function(){\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getNum.do\",\n");
      out.write("                data: {word: null}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.num = data;\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("        $scope.getTime = function(){\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getTime.do\",\n");
      out.write("                data: {word: null}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.time = data;\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("        $scope.getListByHot = function(){\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getListByHot.do\",\n");
      out.write("                data: {word: null}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.books = data;\n");
      out.write("            })\n");
      out.write("        };\n");
      out.write("        $scope.getListByScore = function(){\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getListByScore.do\",\n");
      out.write("                data: {word: null}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.books = data;\n");
      out.write("            })\n");
      out.write("        };\n");
      out.write("        $scope.getTitlePages = function(){\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getTitlePages.do\",\n");
      out.write("                data: {word: $scope.selected}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.records = data;\n");
      out.write("            })\n");
      out.write("        };\n");
      out.write("        $scope.getAuthorPages = function(){\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getAuthorPages.do\",\n");
      out.write("                data: {word: $scope.selected}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.records = data;\n");
      out.write("            })\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        $scope.getIsbnPages = function(){\n");
      out.write("            $http({\n");
      out.write("                method: \"POST\",\n");
      out.write("                url: \"http://localhost:8080/BooksYi/book-pages/getIsbnPages.do\",\n");
      out.write("                data: {word: $scope.selected}\n");
      out.write("            }).success(function (data){\n");
      out.write("                $scope.records = data;\n");
      out.write("            })\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        $scope.numberOfPages=function(){\n");
      out.write("            return Math.ceil($scope.records.length/$scope.pageSize);\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        $scope.suggestWords = function(searchword) {\n");
      out.write("            return $http.post('/BooksYi/book-pages/suggestWord.do', {\n");
      out.write("            word: searchword\n");
      out.write("            })\n");
      out.write("            .then(function (response) {\n");
      out.write("                return response.data;\n");
      out.write("            });\n");
      out.write("        };\n");
      out.write("        $scope.hotsearch = function(type,word){\n");
      out.write("            if(type.match(\"title\") != null){\n");
      out.write("                $http({\n");
      out.write("                    method: \"POST\",\n");
      out.write("                    url: \"http://localhost:8080/BooksYi/book-pages/getTitlePages.do\",\n");
      out.write("                    data: {word: word}\n");
      out.write("                }).success(function (data){\n");
      out.write("                    $scope.records = data;\n");
      out.write("                })\n");
      out.write("            }\n");
      out.write("            else{\n");
      out.write("                $http({\n");
      out.write("                    method: \"POST\",\n");
      out.write("                    url: \"http://localhost:8080/BooksYi/book-pages/getAuthorPages.do\",\n");
      out.write("                    data: {word: word}\n");
      out.write("                }).success(function (data){\n");
      out.write("                    $scope.records = data;\n");
      out.write("                })\n");
      out.write("            }\n");
      out.write("       }\n");
      out.write("\n");
      out.write("    });\n");
      out.write("    app.filter('startFrom', function() {\n");
      out.write("        return function(input, start) {\n");
      out.write("            start = +start; //parse to int\n");
      out.write("            return input.slice(start);\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("    function check(value){\n");
      out.write("        var url = 'http://localhost:8080/BooksYi/book-pages/details?isbn=';\n");
      out.write("        window.open(url+value);\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("</body>\n");
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
