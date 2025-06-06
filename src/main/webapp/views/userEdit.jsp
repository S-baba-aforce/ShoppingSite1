<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報編集</title>
</head>
<body>

	<h2>会員情報編集画面</h2>
	
	<form action = "user-edition" method = "post">
	
	<p>名前（姓）:<input type = "text" name = "last_name" required></p>
	<p>名前（名）:<input type = "text" name = "first_name" required></p>
	<p>住所:<input type = "text" name = "address" required></p>
	<p>メールアドレス<input type = "email" name = "mail_address" required></p>
	
	<input type = "submit" value = "確認">
	
	</form>
	
	<a href = "user-menu.jsp">会員メニュー画面へ戻る</a>

</body>
</html>