<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
<link rel = "stylesheet" href = "<c:url value = '/css/songDeleteSuccess.css' />">
</head>
<body>

	<h2>指定した楽曲情報を削除しました</h2>
	
	<br>
	<a href="<c:url value='/views/songRegister/song-register.jsp' />">楽曲メニューに戻る</a>
	
	<c:if test="${not empty errorMessage}">
    	<p style="color:red;">${errorMessage}</p>
	</c:if>

</body>
</html>