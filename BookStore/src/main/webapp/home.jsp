<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page import="com.zucc.demo.model.UserVo" %>
<%@ page import="com.zucc.demo.model.BookRatingVo" %>
<%@ page import="com.zucc.demo.model.RecommendBookVo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zucc.demo.model.BookVo" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
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
    <script src="js/responsiveslides.min.js"></script>
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                nav: true,
                speed: 500,
                namespace: "callbacks",
                pager: true,
            });
        });
    </script>
</head>
<body>

<%
    String id = (String) request.getParameter("id");

    UserVo objlist = (UserVo) request.getSession().getAttribute("userdetail");
    String text1 = "Location: " + objlist.getLocation() + "\n";
    String text2 = "Age: " + objlist.getAge();

    List<RecommendBookVo> recommendList = (List) request.getSession().getAttribute("list");
    if (recommendList != null) {
        BookVo book1 = recommendList.get(0).getBook();
        DecimalFormat df = new DecimalFormat("#.0");
        String rating1 = df.format(recommendList.get(0).getRating());

        BookVo book2 = recommendList.get(1).getBook();
        String rating2 = df.format(recommendList.get(1).getRating());

        BookVo book3 = recommendList.get(2).getBook();
        String rating3 = df.format(recommendList.get(2).getRating());


%>

<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a><img src="images/logo2.png" alt="" height="30"/></a></div>
            <div class="col-sm-6 nav" style="float:right">
                <ul>
                    <li><span onclick="window.open('http://localhost:10080/BookStore/bookrating?id='+<%=id%>)"
                              class="simptip-position-bottom simptip-movable" data-tooltip="rating"><a></a></span></li>
                </ul>
            </div>
            <div class="col-sm-3 header_right" style="float:right">
                <ul class="header_right_box">
                    <li><a class="simptip-position-bottom simptip-movable" id="information"
                           data-tooltip="<%=text1%><%=text2%>"> <img src="images/p1.png" alt=""/></a></li>
                    <li><p><a id="log" href="http://localhost:10080/BookStore/"
                              class="simptip-position-bottom simptip-movable">Log In</a></p></li>

                    <div class="clearfix"></div>
                </ul>
            </div>

            <div class="clearfix"></div>
        </div>
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li>
                        <div style="position: relative;float: left;left: 35%"><img onload="javascript:ifexist(this);" src="<%=book1.getImage_url_l()%>"
                                                                                   class="img-responsive"
                                                                                   alt=""/></div>

                        <div class="button">
                            <a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book1.getIsbn()%>"
                               class="hvr-shutter-out-horizontal" target="_blank">Rate Now</a>
                        </div>
                        <div class="banner_desc">
                            <div class="col-md-9">

                                <ul class="list_1 list_2">
                                    <li style="width:40%">Booktitle <span class="m_1"><%=book1.getTitle()%></span></li>
                                    <li style="width:35%">Author <span class="m_1"><%=book1.getAuthor()%></span></li>
                                    <li style="width:15%"><i class="icon1"> </i>
                                        <p><%=rating1%>
                                        </p></li>
                                </ul>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div style="position: relative;float: left;left: 35%"><img onload="javascript:ifexist(this);" src="<%=book2.getImage_url_l()%>"
                                                                                   class="img-responsive"
                                                                                   alt=""/></div>
                        <div class="button">
                            <a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book2.getIsbn()%>"
                               class="hvr-shutter-out-horizontal" target="_blank">Rate Now</a>
                        </div>
                        <div class="banner_desc">
                            <div class="col-md-9">

                                <ul class="list_1 list_2">
                                    <li style="width:45%">Booktitle <span class="m_1"><%=book2.getTitle()%></span></li>
                                    <li>Author <span class="m_1"><%=book2.getAuthor()%></span></li>
                                    <li style="width:20%"><i class="icon1"> </i>
                                        <p><%=rating2%>
                                        </p></li>
                                </ul>
                            </div>
                        </div>
                    </li>

                    <li>
                        <div style="position: relative;float: left;left: 35%"><img onload="javascript:ifexist(this);" src="<%=book3.getImage_url_l()%>"
                                                                                   class="img-responsive"
                                                                                   alt=""/></div>
                        <div class="button">
                            <a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book3.getIsbn()%>"
                               class="hvr-shutter-out-horizontal" target="_blank">Rate Now</a>
                            <%--onclick="window.open('http://localhost:10080/BookStore/bookdetail?id='+<%=id%>+'&isbn='+<%=isbn%>)"--%>

                        </div>
                        <div class="banner_desc">
                            <div class="col-md-9">

                                <ul class="list_1 list_2">
                                    <li style="width:45%">Booktitle <span class="m_1"><%=book3.getTitle()%></span></li>
                                    <li>Author <span class="m_1"><%=book3.getAuthor()%></span></li>
                                    <li style="width:20%"><i class="icon1"> </i>
                                        <p><%=rating3%>
                                        </p></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>

        </div>

        <div class="content">
            <div class="box_1">
                <h1 class="m_2">Recommended Books</h1>
                <div class="search">
                    <form>
                        <input type="text" value="Search..." onfocus="this.value='';"
                               onblur="if (this.value == '') {this.value ='';}" id="title">

                        <img src="images/search.png" onclick="search()">
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="recommend">
                <%
                    for (int i = 3; i < 15; i++) {
                        BookVo book = recommendList.get(i).getBook();
                        // DecimalFormat df = new DecimalFormat("#.0");
                        String rating = df.format(recommendList.get(i).getRating());
                %>

                <div class="border-wrap">
                    <div class="cover shadow-cover">
                        <a class="pic" href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>" target="_blank">
                            <img src="<%=book.getImage_url_m()%>" alt="" itemprop="image" width="110px" height="175px"></a>
                    </div>
                    <div class="info">
                        <h4 class="title"><a href="http://localhost:10080/BookStore/bookdetail?id=<%=id%>&isbn=<%=book.getIsbn()%>" target="_blank"><%=book.getTitle()%>
                        </a></h4>
                        <div class="author"><span class="orig-author"><%=book.getAuthor()%></span></div>

                        <div class="price-info"><span class="price-tag discount"><i
                                class="icon1"></i><p><%=rating%> </p></span>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </div>
</div>


</body>


<script type="text/javascript">

    if (<%=id%>) {
        document.getElementById("log").innerText = "Your ID:" +<%=id%>;
        var log = document.getElementById('log');
        log.dataset.tooltip = 'exit';
    }

    function ifexist(img){
        if (img.height<5){
            img.src="images/404.png";
            img.style.height = '500' + 'px';
        }
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
                    window.open("http://localhost:10080/BookStore/search?id=" + id + "&title=" + title);
                }
                else {
                    alert(response.content);
                }
            }
        };
    }

</script>


</html>