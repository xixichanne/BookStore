<%@ page import="java.util.List" %>
<%@ page import="com.zucc.demo.model.BookVo" %>
<%@ page import="com.zucc.demo.model.BookRatingVo" %>
<%@ page import="com.zucc.demo.model.UserVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>SearchResults</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900'
          rel='stylesheet'
          type='text/css'>
</head>
<body>

<%
    String id = request.getParameter("id");
    UserVo userdetail = (UserVo) request.getSession().getAttribute("userdetail");
    String text1 = "Location: " + userdetail.getLocation() + "\n";
    String text2 = "Age: " + userdetail.getAge();

%>

<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="http://localhost:10080/BookStore/user?id=<%=id%>"
                                          class="simptip-position-bottom simptip-movable" data-tooltip="home"><img
                    src="images/logo2.png" alt="" height="30"/></a></div>
            <div class="col-sm-6 nav" style="float:right">

            </div>
            <div class="col-sm-3 header_right" style="float:right">
                <ul class="header_right_box">
                    <li><a class="simptip-position-bottom simptip-movable" id="information"
                           data-tooltip="<%=text1%><%=text2%>"> <img src="images/p1.png" alt=""/></a></li>
                    <li><p><a id="log" href="http://localhost:10080/BookStore/"
                              class="simptip-position-bottom simptip-movable">Your ID:<%=id%>
                    </a></p></li>
                    <%--<li class="last"><i class="edit"> </i></li>>--%>
                    <div class="clearfix"></div>
                </ul>
            </div>

            <div class="clearfix"></div>

        </div>
        <div class="content">

            <div class="box_1">
                <h2 class="m_3">Search Results</h2>
                <div class="search">
                    <form>
                        <input type="text" value="Search..." onfocus="this.value='';"
                               onblur="if (this.value == '') {this.value ='';}" id="title">

                        <img src="images/search.png" onclick="search()">
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="movie_top">
                <div class="col-md-12 movie_box">
                    <%
                        List<BookRatingVo> ratinglist = (List) request.getSession().getAttribute("ratinglist");
                        List<BookVo> objlist = (List) request.getSession().getAttribute("objlist1");
                        if (objlist != null) {
                            for (int i = 0; i < objlist.size(); i++) {
                                if (i % 4 == 0) {
                                    BookVo book = objlist.get(i);

                    %>
                    <div class="movie movie-test movie-test-dark movie-test-left">
                        <div class="movie__images">
                            <a class="movie-beta__link"
                               href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="pic" target="_blank">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="movie__title" target="_blank"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <ul class="list_6">
                                <% for (int j = 0; j < ratinglist.size(); j++) {
                                    BookVo book1 = ratinglist.get(j).getBook();
                                    int rating = ratinglist.get(j).getRating();
                                    if (book1.getId() == book.getId()) {
                                %>
                                <li><i class="icon1"> </i>
                                    <p>Your Rating:<%=rating%>
                                    </p></li>
                                <% }
                                } %>
                                <div class="clearfix"></div>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <%
                        }
                        if (i % 4 == 1) {
                            BookVo book = objlist.get(i);
                    %>
                    <div class="movie movie-test movie-test-dark movie-test-left">
                        <div class="movie__images">
                            <a class="movie-beta__link"
                               href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="pic" target="_blank">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="movie__title" target="_blank"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <ul class="list_6">
                                <% for (int j = 0; j < ratinglist.size(); j++) {
                                    BookVo book1 = ratinglist.get(j).getBook();
                                    int rating = ratinglist.get(j).getRating();
                                    if (book1.getId() == book.getId()) {
                                %>
                                <li><i class="icon1"> </i>
                                    <p>Your Rating:<%=rating%>

                                    </p></li>  <% }
                            } %>
                                <div class="clearfix"></div>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <%
                        }
                        if (i % 4 == 2) {
                            BookVo book = objlist.get(i);

                    %>

                    <div class="movie movie-test movie-test-light movie-test-right">
                        <div class="movie__images">
                            <a class="movie-beta__link"
                               href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="pic" target="_blank">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="movie__title" target="_blank"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <ul class="list_6">
                                <% for (int j = 0; j < ratinglist.size(); j++) {
                                    BookVo book1 = ratinglist.get(j).getBook();
                                    int rating = ratinglist.get(j).getRating();
                                    if (book1.getId() == book.getId()) {
                                %>
                                <li><i class="icon1"> </i>
                                    <p>Your Rating:<%=rating%>

                                    </p></li>
                                <% }
                                } %>
                                <div class="clearfix"></div>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <%
                        }
                        if (i % 4 == 3) {
                            BookVo book = objlist.get(i);
                    %>
                    <div class="movie movie-test movie-test-light movie-test-right">
                        <div class="movie__images">
                            <a class="movie-beta__link"
                               href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="pic" target="_blank">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>"
                               class="movie__title" target="_blank"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <ul class="list_6">
                                <% for (int j = 0; j < ratinglist.size(); j++) {
                                    BookVo book1 = ratinglist.get(j).getBook();
                                    int rating = ratinglist.get(j).getRating();
                                    if (book1.getId() == book.getId()) {
                                %>
                                <li><i class="icon1"> </i>
                                    <p>Your Rating:<%=rating%>
                                    </p></li>
                                <% }
                                } %>
                                <div class="clearfix"></div>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <%
                                }
                            }
                        }
                    %>
                    <div class="clearfix"></div>
                </div>

                <div class="clearfix"></div>
            </div>

        </div>
    </div>
</div>
</body>


<script type="text/javascript">
    if (<%=id%>) {
        document.getElementById("log").innerText = "Your ID:" +<%=id%>;
        var test = document.getElementById('log');
        test.dataset.tooltip = 'exit';
    }

    function search() {
        var title = document.getElementById("title").value;
        var url = "http://localhost:10080/BookStore/search?title=";
        var id =<%=id%>;
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "search", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("title=" + title);
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var response = xmlhttp.responseText;
                response = JSON.parse(response);
                if (response.flag) {
                    window.open("http://localhost:10080/BookStore/search?id=" + id + "&title=" + title, target = "_self");
                }
                else {
                    alert(response.content);
                }
            }
        };
    }
</script>

</html>