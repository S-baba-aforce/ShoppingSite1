<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${music.title} - Details</title>
<!--    <link rel="stylesheet" href="css/musicDetail.css">-->
</head>
<body>
<header>
   <div class="header-container">
       <h1>Underground × StarTunes</h1>
       <nav class="nav-desktop">
           <ul>
               <li><a href = "<c:url value='/views/music/musicList' />">楽曲一覧</a></li>
				<li><a href = "<c:url value='/views/artist/artistList' />">アーティスト一覧</a></li>
               <li><a href="cart.jsp">🛒</a></li>
               <li><a href="user-menu.jsp">マイページ</a></li>
           </ul>
       </nav>
   </div>
</header>



<main>
    <h2>${music.title}</h2>
    <p>アーティスト：<a href="aboutArtist?id=${music.artist_id}">${music.name}</a></p>
    <p>ジャンル：${music.genre}</p>
    <p>説明：${music.description}</p>
    <p>リリース日：<fmt:formatDate value="${music.created_at}" pattern="yyyy/MM/dd" /></p>
    <p>価格：￥${music.price}</p>
    
    <!-- カート追加ボタン -->
    <form action="addToCart" method="post">
        <input type="hidden" name="music_id" value="${music.music_id}">
        <button type="submit">カートに追加</button>
    </form>
</main>

<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>