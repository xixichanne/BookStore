<%@ page import="java.util.List" %>
<%@ page import="com.zucc.demo.model.BookVo" %>
<%@ page import="com.zucc.demo.model.UserVo" %>
<%@ page import="com.zucc.demo.model.BookRatingVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>RatedBooks</title>
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
                              class="simptip-position-bottom simptip-movable">Log In</a></p></li>
                    <%--<li class="last"><i class="edit"> </i></li>>--%>
                    <div class="clearfix"></div>
                </ul>
            </div>

            <div class="clearfix"></div>

        </div>
        <div class="content">
            <h2 class="m_3">Rated Books</h2>
            <div class="movie_top">
                <div class="col-md-12 movie_box">
                    <%
                        List<BookRatingVo> objlist = (List) request.getSession().getAttribute("objlist");
//                        List<BookRatingVo> objlist=result;
                        if (objlist != null) {
//                            for (Map.Entry<BookVo, Integer> entry : map.entrySet()) {
                            for (int i = 0; i < objlist.size(); i++) {
                                if (i % 4 == 0) {
                                    BookVo book = objlist.get(i).getBook();
                                    int rating = objlist.get(i).getRating();
                    %>
                    <div class="movie movie-test movie-test-dark movie-test-left">
                        <div class="movie__images">
                            <a class="movie-beta__link">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a class="movie__title"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <p class="movie__time">Publisher: <%=book.getPublisher()%>
                            </p>
                            <p class="movie__time">ISBN: <%=book.getIsbn()%>
                            </p>

                            <ul class="list_6">
                                <li><i class="icon1"> </i>
                                    <p><%=rating%>
                                    </p></li>
                                <div class="clearfix"></div>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <%
                        }
                        if (i % 4 == 1) {
                            BookVo book = objlist.get(i).getBook();
                            int rating = objlist.get(i).getRating();
                    %>
                    <!-- Movie variant with time -->
                    <div class="movie movie-test movie-test-dark movie-test-left">
                        <div class="movie__images">
                            <a class="movie-beta__link">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a class="movie__title"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <p class="movie__time">Publisher: <%=book.getPublisher()%>
                            </p>
                            <p class="movie__time">ISBN: <%=book.getIsbn()%>
                            </p>

                            <ul class="list_6">
                                <li><i class="icon1"> </i>
                                    <p><%=rating%>
                                    </p></li>
                                <div class="clearfix"></div>
                            </ul>


                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <%
                        }
                        if (i % 4 == 2) {
                            BookVo book = objlist.get(i).getBook();
                            int rating = objlist.get(i).getRating();
                    %>

                    <div class="movie movie-test movie-test-light movie-test-right">
                        <div class="movie__images">
                            <a class="movie-beta__link">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a class="movie__title"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <p class="movie__time">Publisher: <%=book.getPublisher()%>
                            </p>
                            <p class="movie__time">ISBN: <%=book.getIsbn()%>
                            </p>

                            <ul class="list_6">
                                <li><i class="icon1"> </i>
                                    <p><%=rating%>
                                    </p></li>
                                <div class="clearfix"></div>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <%
                        }
                        if (i % 4 == 3) {
                            BookVo book = objlist.get(i).getBook();
                            int rating = objlist.get(i).getRating();
                    %>
                    <div class="movie movie-test movie-test-light movie-test-right">
                        <div class="movie__images">
                            <a class="movie-beta__link">
                                <img alt="" src="<%=book.getImage_url_m()%>" class="img-responsive pics" alt=""/>
                            </a>
                        </div>
                        <div class="movie__info">
                            <a class="movie__title"><%=book.getTitle()%>
                            </a>
                            <p class="movie__time">Author: <%=book.getAuthor()%>
                            </p>
                            <p class="movie__time">Year: <%=book.getYear()%>
                            </p>
                            <p class="movie__time">Publisher: <%=book.getPublisher()%>
                            </p>
                            <p class="movie__time">ISBN: <%=book.getIsbn()%>
                            </p>

                            <ul class="list_6">
                                <li><i class="icon1"> </i>
                                    <p><%=rating%>
                                    </p></li>
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
                    <!-- Movie variant with time -->
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

</script>

</html>