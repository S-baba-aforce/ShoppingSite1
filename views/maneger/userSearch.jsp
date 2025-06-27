<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報一覧</title>
<link rel = "stylesheet" href = "<c:url value = '/css/userSearch.css' />">
</head>
<body>

	<h2>会員情報一覧</h2>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>パスワード</th>
			<th>姓</th>
			<th>名</th>
			<th>住所</th>
			<th>メール</th>
			<th>操作</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.memberId}</td>
				<td>${user.password}</td>
				<td>${user.lastName}</td>
				<td>${user.firstName}</td>
				<td>${user.address}</td>
				<td>${user.mailAddress}</td>
				<td><a href="user-edit?id=${user.memberId}">修正</a> <a
					href="user-delete-confirm?id=${user.memberId}">削除</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href = "<c:url value = '/views/maneger/manegerMenu.jsp' />">戻る</a>


	<c:if test="${not empty errorMessage}">
    	<p style="color:red;">${errorMessage}</p>
	</c:if>
	
</body>
</html>