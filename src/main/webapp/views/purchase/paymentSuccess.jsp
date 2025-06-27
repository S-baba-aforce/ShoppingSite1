<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了 - Underground × StarTunes</title>
<link rel = "stylesheet" href = "<c:url value = '/css/paymentSuccess.css' />">
</head>
<body>

<header>
    <h1>ご購入ありがとうございます</h1>
</header>

<main>
    <p class = "message">以下の楽曲をダウンロードできます。</p>

    <ul class="download-list">
        <c:forEach var="music" items="${purchasedItems}">
            <li>
                <span><strong>${music.title}</strong> / ${music.name}</span>
                <button disabled>ダウンロード</button>
            </li>
        </c:forEach>
    </ul>

    <a href="<c:url value = '/views/music/musicTop.jsp' />">トップ画面へ戻る</a>
</main>

<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>
