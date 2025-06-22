<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報修正</title>
</head>
<body>

	<h2>会員情報修正</h2>

    <form action="user-edit-confirm" method="post">
        <p>会員ID：${user.memberId}
            <input type="hidden" name="memberId" value="${user.memberId}" />
        </p>

        <p>パスワード：${user.password}
            <input type="hidden" name="password" value="${user.password}" />
        </p>

        <p>姓：<input type="text" name="lastName" value="${user.lastName}" required /></p>
        <p>名：<input type="text" name="firstName" value="${user.firstName}" required /></p>
        <p>住所：<input type="text" name="address" value="${user.address}" required /></p>
        <p>メール：<input type="email" name="mailAddress" value="${user.mailAddress}" required /></p>

        <input type="submit" value="修正する" />
    </form>

    <br>
    <a href="<c:url value='/user-list' />"> 会員一覧に戻る</a>
</body>
</html>