<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支払い確認 - Underground × StarTunes</title>
<link rel = "stylesheet" href = "<c:url value = '/css/paymentConfirm.css' />">
</head>
<body>

<header>
    <h1>支払い確認</h1>
</header>

<main>
    <h2>以下の内容で購入しますか？</h2>

    <table>
        <thead>
            <tr>
                <th>価格</th>
                <th>タイトル</th>
                <th>アーティスト</th>
                <th>ジャンル</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="music" items="${cartItems}">
                <tr>
                    <td>￥${music.price}</td>
                    <td>${music.title}</td>
                    <td>${music.name}</td>
                    <td>${music.genre}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
	<div class="summary">
    <p>支払い方法： 
    	<strong>
        <c:choose>
            <c:when test="${sessionScope.paymentMethod == 'credit'}">クレジットカード</c:when>
            <c:when test="${sessionScope.paymentMethod == 'prepaid'}">プリペイドカード</c:when>
            <c:when test="${sessionScope.paymentMethod == 'convenience'}">コンビニ支払い（手数料+￥300）</c:when>
            <c:otherwise>不明</c:otherwise>
        </c:choose>
        </strong>
    </p>

    <p>合計金額：<strong class = "total">￥${sessionScope.totalAmount}</strong></p>

    <form action="payment-success" method="post">
        <input type="hidden" name="paymentMethod" value="${sessionScope.paymentMethod}">
        <button type="submit">購入</button>
    </form>

    <a href="<c:url value = '/views/purchase/payment.jsp' />">支払い方法を修正する</a>
</main>

<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>
