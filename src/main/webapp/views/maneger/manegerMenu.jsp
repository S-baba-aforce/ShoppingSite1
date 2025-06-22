<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用ログイン</title>
</head>
<body>

	<h2>管理者用メニュー</h2>

	<P>${admin.name }のメニュー画面</P>
	
	<a href = "<c:url value='/user-list'/>">会員情報</a>
	<br>
	<a href = "<c:url value='/views/songRegister/song-register.jsp' />">楽曲情報</a>
	<br>
	<a href = "<c:url value='/views/artistRegister/artist-register.jsp' />">アーティスト情報</a>
	<br>
	
		<!-- ログアウト -->
	<form action = "maneger-logout" method = "post">
	<p><input type = "submit" value = "ログアウト"></p>
	</form>


</body>
</html>