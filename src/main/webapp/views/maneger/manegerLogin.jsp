<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用ログイン</title>
</head>
<body>

<!-- ログイン -->
	
	<h2>管理者用ログイン</h2>
	<form action = "maneger-login" method = "post">
	
	<p>ID<input type = "text" name = "id" pattern = "[A-Za-z0-9]+" required></p>
	<p>パスワード<input type = "password" name = "password" required></p>
	<p><input type = "submit" value = "ログイン"></p>
	</form>
	
	<c:if test="${not empty errorMessage}">
    	<p style="color:red;">${errorMessage}</p>
	</c:if>

</body>
</html>