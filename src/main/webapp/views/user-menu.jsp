<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそ</title>
</head>
<body>
	
	<h2>会員メニュー</h2>
	
	<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
	
	<p>「ようこそ、${customer.fullName}さん！」</p>
	
	<a href = "userEdit.jsp">編集</a>
	<br>
	<a href = "userDeleteConfirm.jsp">削除</a>
	
	<!-- ログアウト -->
	<form action = "Logout" method = "post">
	<p><input type = "submit" value = "ログアウト"></p>
	</form>

</body>
</html>