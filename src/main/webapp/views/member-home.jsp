<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録ホーム</title>
</head>
<body>

	<h2>会員情報登録</h2>
	
	<form action = "register-member" method = "post">
	
	<p>ID:<input type = "text" name = "member_id" required></p>
	<p>パスワード:<input type = "password" name = "password" required></p>
	<p>姓:<input type = "text" name = "last_name" required></p>
	<p>名:<input type = "text" name = "first_name" required></p>
	<p>住所:<input type = "text" name = "address" required></p>
	<p>メールアドレス<input type = "mail" name = "mail_address" required></p>
	<input type = "submit" value = "登録">
	
	</form>

</body>
</html>