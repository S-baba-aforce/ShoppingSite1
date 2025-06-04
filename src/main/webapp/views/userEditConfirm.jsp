<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修正内容確認</title>
</head>
<body>

	<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
	
	<h2>登録する内容はよろしいですか？</h2>
	
	<p>名前（姓）:${editCustomer.lastName }</p>
	<p>名前（名）:${editCustomer.firstName }</p>
	<p>住所:${editCustomer.address }</p>
	<p>メールアドレス:${editCustomer.mailAddress }</p>
	
	<form action = "user-edit-confirm" method = "post">
	<input type = "submit" value = "登録">
	</form>
	
	<a href = "userEdit.jsp">もどる</a>
	
</body>
</html>