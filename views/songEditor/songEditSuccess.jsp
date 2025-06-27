<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集完了</title>
<link rel = "stylesheet" href = "<c:url value = '/css/songEditSuccess.css' />">
</head>
<body>

    <h2>楽曲の情報が正常に変更されました。</h2>

    <br>
    
    <a href="<c:url value='/views/songRegister/song-register.jsp' />">楽曲メニューに戻る</a>
    
    <c:if test="${not empty errorMessage}">
    	<p style="color:red;">${errorMessage}</p>
	</c:if>
	
</body>
</html>
