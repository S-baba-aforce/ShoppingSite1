<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
</head>
<body>

	<h2>削除してもよろしいですか？</h2>
	
	<p>${customer.fullName }さん</p>
	
	<form action = "user-delete-confirm" method = "post">
	
	<button type = "submit" name = "confirm" value = "はい">はい</button>
	<button type = "submit" name = "confirm" value = "いいえ">いいえ</button> 
	
	</form>

</body>
</html>