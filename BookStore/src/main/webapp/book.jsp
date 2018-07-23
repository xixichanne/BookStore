<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page import="com.zucc.demo.model.BookVo" %>
<%@ page import="com.zucc.demo.model.UserVo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Book</title>
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
    String isbn =  request.getParameter("isbn");

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
                              class="simptip-position-bottom simptip-movable">Your ID:<%=id%></a></p></li>
                    <%--<li class="last"><i class="edit"> </i></li>>--%>
                    <div class="clearfix"></div>
                </ul>
            </div>

            <div class="clearfix"></div>

        </div>
        <div class="content">
            <div class="movie_top">
                <div class="col-md-9 movie_box">
                    <%
                        BookVo objlist = (BookVo) request.getSession().getAttribute("book");
                        if (objlist != null) {
                    %>

                    <div class="grid images_3_of_2">
                        <div class="movie_image" style="height:514px">
                            <img src="images/404.png" id="img404" class="img-responsive" alt=""
                                 style="position:absolute ;z-index:1"/>
                            <img src="<%=objlist.getImage_url_l()%>" class="img-responsive" alt=""
                                 style="position:absolute ;z-index:11"/>
                        </div>

                    </div>

                    <div class="desc1 span_3_of_2">

                        <p class="movie_option"><strong>BookTitle: </strong><a href="#"><%=objlist.getTitle()%>
                        </a></p>
                        <p class="movie_option"><strong>Author: </strong><a href="#"><%=objlist.getAuthor()%>
                        </a></p>
                        <p class="movie_option"><strong>Year-Of-Publication: </strong><%=objlist.getYear()%>
                        </p>
                        <p class="movie_option"><strong>Publisher: </strong><%=objlist.getPublisher()%>
                        </p>
                        <p class="movie_option"><strong>ISBN: </strong><a href="#"><%=objlist.getIsbn()%>
                        </a></p>

                        <%
                            }
                        %>

                        <form method="post" action="contact-post.html">

                            <div class="text">
                                <textarea id="nn" value="Rating:0-10" onfocus="this.value = '';"
                                          onblur="if (this.value == '') {this.value = 'Score:0-10';}">Score:0-10</textarea>
                            </div>
                            <div class="form-submit1">
                                <input name="submit" title="<%=isbn%>" type="button" id="submit" value="Submit Your Rating"
                                       onclick="rating(title)"><br>
                            </div>
                            <div class="clearfix"></div>
                        </form>
                    </div>

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

    function rating(isbn) {
        var rating = document.getElementById("nn").value;
        <%--var id =<%=id%>;--%>
        <%--var isbn =<%=isbn%>;--%>
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "rate", true);
        xmlhttp.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded");
        xmlhttp.send("id=" + <%=id%> +"&isbn=" + isbn +"&rating=" + rating);
        // xmlhttp.send("id=" + id +"&isbn=" + isbn +"&rating=" + rating);
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var response = xmlhttp.responseText;
                response = JSON.parse(response);
                if (response.flag) {
                    alert("Success!");
                }
                else {
                    alert(response.content);
                }
            }
        };
    }
</script>


</html>