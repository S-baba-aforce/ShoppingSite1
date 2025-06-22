<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報削除確認</title>
</head>
<body>

	<h2>この会員情報を削除しますか？</h2>
	
	<form action = "user-delete-execute" method = "post">
		<p>
			会員ID：${user.memberId} <input type="hidden" name="member_id"
				value="${user.memberId}" />
		</p>

		<p>氏名：${user.lastName} ${user.firstName}</p>
		<input type="hidden" name="last_name" value="${user.lastName}" /> 
		<input type="hidden" name="first_name" value="${user.firstName}" />

		<p>住所：${user.address}</p>
		<input type="hidden" name="address" value="${user.address}" />

		<p>メールアドレス：${user.mailAddress}</p>
		<input type="hidden" name="mail_address" value="${user.mailAddress}" /> <input type="submit" value="削除する" />
	</form>

	<br>
	<a href="<c:url value='/user-list' />">一覧に戻る</a>
</body>
</html>