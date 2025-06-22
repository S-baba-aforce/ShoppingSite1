<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報更新完了</title>
</head>
<body>

	<div class="container">
        <h2>会員情報の更新が完了しました</h2>
        <p>以下の内容で更新されました：</p>
        <ul>
            <li>会員ID：${user.memberId}</li>
            <li>氏名：${user.lastName} ${user.firstName}</li>
            <li>住所：${user.address}</li>
            <li>メールアドレス：${user.mailAddress}</li>
        </ul>

        <a href="<c:url value='/views/maneger/manegerMenu.jsp' />" class="btn">管理者用メニュー画面に戻る</a>
    </div>

</body>
</html>