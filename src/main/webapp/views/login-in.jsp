<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン/新規会員登録</title>
</head>
<body>
	<!-- ログイン -->
	<form action = "login" method = "post">
	
	<p>ID<input type = "text" name = "id"></p>
	<p>パスワード<input type = "password" name = "password"></p>
	<p><input type = "submit" value = "ログイン"></p>
	</form>
	
	<br>
	
	<!-- 新規登録 -->
	<form action = "register-member" method = "get">
	<p><input type = "submit" value = "新規会員登録"></p>
	</form>

</body>
</html>