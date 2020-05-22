<%@page import="Models.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="row" style="margin-top: 4%;">
		<div class="col-sm-2">
			<div class="container">
				<ul class="nav flex-column">
					<li class="nav-item"><a class="nav-link" href="/visitCard/MyServlet">Главная</a></li>
					<li class="nav-item"><a class="nav-link" href="/visitCard/SkillsServlet">Образование</a></li>
					<li class="nav-item"><a class="nav-link" href="/visitCard/ExperiensServlet">Опыт работы</a></li>
				</ul>
			</div>
		</div>
		<div class="col-sm-8">

			<div>
				<%
					User user = User.getUser();
					Date date = new Date();
					int age = date.getYear() - new SimpleDateFormat("yyyy-MM-dd").parse(user.getBirthday()).getYear();
				%>
				<h2><%=user.getFirst_name() + " " + user.getSecond_name()%></h2>
				<img src="WEB-INF/View/pic2.png">
				<h3>
					Возраст
					<%=age%></h3>
			</div>
			<div>
				<h3><%=user.getInfo()%></h3>
			</div>
		</div>
		<div class="col-sm-2"></div>
	</div>


</body>
</html>