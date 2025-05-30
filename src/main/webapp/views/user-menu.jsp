<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ようこそ</title>
</head>
<body>

	<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
	
	<p>「ようこそ、${customer.memberId }さん！」</p>
	
	<p><input type = "submit" value = "修正"></p>
	<p><input type = "submit" value = "削除"></p>
	
	<!-- ログアウト -->
	<form action = "Logout" method = "post">
	<p><input type = "submit" value = "ログアウト"></p>
	</form>

</body>
</html>