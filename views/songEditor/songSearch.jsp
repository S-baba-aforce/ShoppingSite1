<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>楽曲情報検索</title>
<link rel = "stylesheet" href = "<c:url value = '/css/songSearch.css' />">
</head>
<body>

	<h2>楽曲情報変更</h2>

	    <form action="song-update" method="post">
        <p>変更したい楽曲のIDを入力してください：</p>
        <input type="number" name="music_id" required>
        <input type="submit" value="検索">
    </form>

    <br>
    <a href="<c:url value='/views/songRegister/song-register.jsp' />">戻る</a>
    
    <c:if test="${not empty errorMessage}">
    	<p style="color:red;">${errorMessage}</p>
	</c:if>

</body>
</html>