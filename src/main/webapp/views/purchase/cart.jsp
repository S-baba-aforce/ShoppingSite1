<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, jp.co.aforce.beans.MusicBean" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入楽曲 - Underground × StarTunes</title>
<!--<script src="js/cart.js" defer></script>-->
<link rel = "stylesheet" href = "<c:url value = '/css/cart.css' />">
</head>
<body>

<header>
    <h1>購入楽曲</h1>
</header>

<main>
	<c:if test="${not empty error}">
  		<p class="error">${error}</p>
	</c:if>
    <c:choose>
        <c:when test="${empty sessionScope.cartItems}">
            <p>カートに商品がありません。</p>
        </c:when>
        <c:otherwise>
            <table id="cartTable">
                <thead>
                    <tr>
                        <th>価格</th>
                        <th>タイトル</th>
                        <th>アーティスト</th>
                        <th>ジャンル</th>
                        <th>削除</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="music" items="${sessionScope.cartItems}" varStatus="status">
                        <tr data-index="${status.index}" data-price="${music.price}">
                            <td>￥${music.price}</td>
                            <td>${music.title}</td>
                            <td>${music.name}</td>
                            <td>${music.genre}</td>
                            <td>
                                <form action="cart-delete" method="post" style="display:inline;">
                                    <input type="hidden" name="music_id" value="${music.music_id}">
                                    <button type="submit">削除</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p>合計金額：<span id="totalPrice">￥${totalPrice}</span></p>

				<form action="cart-reset" method="post" style="display: inline;">
					<button type="submit" id="resetCartBtn">カートを空にする</button>
				</form>
				
				<br>

<!--				<a href="<c:url value = '/views/music/musicHome.jsp' />">楽曲を探す</a>-->
				
<!--				<br>-->
				<br>
				
            	<form action="<c:url value='/payment' />" method="post" style="display: inline;">
                	<button type="submit">支払いへ進む</button>
            	</form>
            	<br>
            	<br>
        </c:otherwise>
    </c:choose>
</main>

<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>
