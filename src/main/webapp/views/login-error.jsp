<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login-Error</title>
</head>
<body>

	
	<%@taglib prefix = "c" uri = "jakarta.tags.core" %>

	<h2>${errorMessage}</h2>
	
	<a href = "login-in.jsp">ログイン画面へ戻る</a>

</body>
</html>