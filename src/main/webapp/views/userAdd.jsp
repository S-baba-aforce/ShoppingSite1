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
	
	<p>ユーザーID:<input type = "text" name = "member_id" required>半角英数字</p>
	<p>パスワード:<input type = "password" name = "password" required>半角英数字</p>
	<p>名前（姓）:<input type = "text" name = "last_name" required></p>
	<p>名前（名）:<input type = "text" name = "first_name" required></p>
	<p>住所:<input type = "text" name = "address" required></p>
	<p>メールアドレス<input type = "mail" name = "mail_address" required></p>
	
	<input type = "submit" value = "確認">
	<input type = "reset" value = "リセット">
	
	</form>
	
	<hr>
	
	<a href = "login-in.jsp">ログイン画面へ戻る</a>

</body>
</html>