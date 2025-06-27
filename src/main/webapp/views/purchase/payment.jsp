<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, jp.co.aforce.beans.MusicBean" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お支払い - Underground × StarTunes</title>
<link rel = "stylesheet" href = "<c:url value = '/css/payment.css' />">
<script>
	const sessionPaymentMethod = "${sessionScope.paymentMethod}";
	console.log("JSPから渡された支払い方法:",sessionPaymentMethod);
</script>
<script src="<c:url value='/js/payment.js' />" defer></script>
</head>
<body>

<header>
    <h1>お支払い</h1>
</header>

	<main>
		<c:choose>
			<c:when test="${empty sessionScope.cartItems}">
				<p>カートに商品がありません。</p>
			</c:when>
			<c:otherwise>

				<h2>カート内商品</h2>
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
						<c:forEach var="music" items="${sessionScope.cartItems}">
							<tr>
								<td>￥${music.price}</td>
								<td>${music.title}</td>
								<td>${music.name}</td>
								<td>${music.genre}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<h3>支払い方法</h3>
				<form action="<c:url value='/payment-confirm' />" method="post" id="paymentForm">
					<div class="select-wrapper">
						<label for="paymentMethod">支払い方法選択</label>
						<select name="paymentMethod" id="paymentMethod">
							<option value="credit" ${sessionScope.paymentMethod == 'credit' ? 'selected' : ''}>クレジットカード</option>
							<option value="prepaid" ${sessionScope.paymentMethod == 'prepaid' ? 'selected' : ''}>プリペイドカード</option>
							<option value="convenience" ${sessionScope.paymentMethod == 'convenience' ? 'selected' : ''}>コンビニ支払い（手数料+￥300）</option>
						</select>
						
					</div>
					<c:set var="total" value="0" />
					<c:forEach var="music" items="${sessionScope.cartItems}">
						<c:set var="total" value="${total + music.price}" />
					</c:forEach>

					<input type="hidden" id="baseTotal" value="${total}" />

					<p>
						合計金額：<span id="totalAmount">￥${total}</span>
					</p>

					<button type="submit">確認</button>
				</form>

				<a href="<c:url value = '/views/purchase/cart.jsp' />">カートに戻る</a>
<!--					<a href="<c:url value='/views/purchase/payment-confirm?action=backToCart' />">カートに戻る</a>-->

			</c:otherwise>
		</c:choose>
	</main>

	<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>
