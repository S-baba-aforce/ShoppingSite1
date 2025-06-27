<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録確認</title>
<link rel = "stylesheet" href = "<c:url value = '/css/userAddConfirm.css' />">
</head>
<body>

	<div class="container">
		<h2>登録する内容はこちらでよろしいですか？</h2>

		<p>ユーザーID:${customer.memberId }</p>
		<p>パスワード:${customer.password }</p>
		<p>名前（姓）:${customer.lastName }</p>
		<p>名前（名）:${customer.firstName }</p>
		<p>住所:${customer.address }</p>
		<p>メールアドレス:${customer.mailAddress}</p>

		<form action="user-add" method="post">
			<input type="submit" value="登録">
		</form>


		<a href="userAdd.jsp">もどる</a>
	</div>
	
	<br>
	<br>
	<br>

<!--	<footer>-->
<!--		<p>musicLife.inc</p>-->
<!--	</footer>-->

</body>
</html>