<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- start plugins -->
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>


<%--<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"--%>
                   <%--url="jdbc:mysql://localhost:3306/bx?useUnicode=true&characterEncoding=utf-8"--%>
                   <%--user="root"  password="123456"/>--%>
<%--<sql:query dataSource="${snapshot}" var="result">--%>
    <%--select max(user_id) from users;--%>
<%--</sql:query>--%>

<%
    //加载驱动程序
    String driverName="com.mysql.jdbc.Driver";
//数据库信息
    String userName="root";
//密码
    String userPasswd="123456";
//数据库名
    String dbName="bx";
//将数据库信息字符串连接成为一个完整的url（也可以直接写成url，分开写是明了可维护性强）
    String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn=DriverManager.getConnection(url);
    Statement stmt = conn.createStatement();
    String sql=" select max(user_id) from users";
    ResultSet rs = stmt.executeQuery(sql);
%>

<div class="container">
	<div class="container_wrap">
		<div class="header_top">
		    <div class="col-sm-3 logo"><a href="home.jsp"><img src="images/logo2.png" alt="" height="30"/></a></div>

			<div class="clearfix"> </div>
	      </div>
	      <div class="content">
      	     <div class="register">
		  	  <form> 
				 <div class="register-top-grid">
					<h3>Register</h3>
					 <div>
						<span>UserID</span>
                         <%while(rs.next()){%>
						<input type="text" readonly="readonly" id="id" value=<%=1+rs.getInt(1)%>>
                         <%}%>
					 </div>
					 <div>
						<span>Password<label>*</label></span>
						<input type="password" id="pwd">
					 </div>
					 <div>
						 <span>Location<label>*</label></span>
						 <input type="text" id="location">
					 </div>
					 <div>
						 <span>Age<label>*</label></span>
						 <input type="text" id="age">
					 </div>
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>It's just for test！</label>
					   </a>
					 </div>

				</form>
				<div class="clearfix"> </div>
				<div class="register-but">
				   <form>
					   <%--<input type="submit" value="submit">--%>
						   <input type="button" value="submit" onclick="register()">
					   <div class="clearfix"> </div>
				   </form>
				</div>
		   </div>
           </div>
    </div>
</div>

</body>


<script src="js/register.js"></script>
<script type="text/javascript">
    function register(){
        var id = document.getElementById("id").value;
        var location = document.getElementById("location").value;
        var age = document.getElementById("age").value;
        var pwd = document.getElementById("pwd").value;
        var url = "http://localhost:10080/BookStore/user?id="
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("POST", "register", true);
        xmlhttp.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded");
        xmlhttp.send("id=" + id +"&pwd=" + pwd + "&location=" + location + "&age=" + age );
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var response = xmlhttp.responseText;
                response = JSON.parse(response);
                if (response.flag) {
                    window.open(url+response.content);
                }
                else{
                    alert(response.content);
                }
            }
        };
    }
</script>




</html>