<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="http://getbootstrap.com/examples/jumbotron-narrow/jumbotron-narrow.css">
    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>

    <script src="https://cdn.bootcss.com/angular-ui-bootstrap/1.3.2/ui-bootstrap-tpls.js"></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- start plugins -->
    <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet'
          type='text/css'>
</head>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="home.jsp"><img src="images/logo2.png" alt="" height="30"/></a></div>


            <div class="clearfix"></div>
        </div>
        <div class="content">
            <div class="register">
                <div class="col-md-6 login-left">
                    <h3>New Users</h3>
                    <p>By creating an account with our system,you will be able to browse all the pages,search the movie
                        infomation,give marks on movies,and we will recommend something you like.</p>
                    <a class="acount-btn" href="register.jsp">Create an Account</a>
                </div>
                <div class="col-md-6 login-right">
                    <h3>Registered Users</h3>
                    <p>If you have an account with us, please log in.</p>
                    <form>
                        <div>
                            <span>UserID<label>*</label></span>
                            <input type="text" id="id">
                        </div>
                        <div>
                            <span>Password<label>*</label></span>
                            <input type="password" id="pwd">
                        </div>
                        <input type="button" value="Login" onclick="login()">
                        <%--<button ng-click="login()">Login</button>--%>
                        <%--<input type="submit" value="Login" >--%>
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>

</body>

<script src="js/login.js"></script>
<script type="text/javascript">
    function login() {
        var id = document.getElementById("id").value;
        var pwd = document.getElementById("pwd").value;
        var url = "http://localhost:10080/BookStore/user?id=";
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "login", true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("id=" + id + "&pwd=" + pwd);
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var response = xmlhttp.responseText;
                response = JSON.parse(response);
                if (response.flag) {
                    window.open(url + id,"_self");
                }
                else {
                    alert(response.content);
                }
            }
        };
    }
</script>

</html>