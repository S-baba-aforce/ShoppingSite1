<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login-Error</title>
<link rel = "stylesheet" href = "<c:url value = '/css/login-error.css' />">
</head>
<body>

	<main>
		<div class="container">
			<h2>${error}</h2>

			<a href="login-in.jsp">ログイン画面へ戻る</a>
		</div>
	</main>

	<footer>
		<p>musicLife.inc</p>
	</footer>

</body>
</html>