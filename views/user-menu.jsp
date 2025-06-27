<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそ</title>
<link rel = "stylesheet" href = "<c:url value = '/css/user-menu.css' />">
</head>
<body>
	
	<h2>会員メニュー</h2>

	<div class="center">
		<p>「ようこそ、${customer.fullName} さん」</p>

		<br>
		<form action="music-home" method="get">
			<input type="submit" value="ホームへ">
		</form>

		<a href="userEdit.jsp">編集</a> <br> 
		<a href="userDeleteConfirm.jsp">削除</a>

		<!-- ログアウト -->
		<form action="Logout" method="post">
			<p>
				<input type="submit" value="ログアウト">
			</p>
		</form>
	</div>

	<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>