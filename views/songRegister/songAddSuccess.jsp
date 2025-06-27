<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
<link rel = "stylesheet" href = "<c:url value = '/css/songAddSuccess.css' />">
</head>
<body>

	<h2>楽曲の登録が完了しました。</h2>
	<br>
	<a href = "song-register.jsp">楽曲メニュー画面に戻る</a>
	
	<c:if test="${not empty errorMessage}">
    	<p style="color:red;">${errorMessage}</p>
	</c:if>
	
</body>
</html>