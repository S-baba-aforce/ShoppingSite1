<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー発生</title>
<link rel = "stylesheet" href = "<c:url value = '/css/manegerError.css' />">
</head>
<body>

	<h3>申し訳ありません。エラーが発生しました。</h3>
	<p>もう一度お試しください。</p>
	<a href = "<c:url value='/views/maneger/manegerLogin.jsp' />">管理者用ログイン画面に戻る</a>

</body>
</html>