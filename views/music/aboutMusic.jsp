<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${music.title} - Details</title>
<link rel = "stylesheet" href = "<c:url value = '/css/aboutMusic.css' />">
<link href="https://fonts.googleapis.com/css2?family=Shippori+Gothic+B1&display=swap" rel="stylesheet">
</head>
<body>
<header>
   <div class="header-container">
       <h1>Underground × StarTunes</h1>
       <nav class="nav-desktop">
           <ul>
               <li><a href = "<c:url value='/views/music/musicList' />">Songs</a></li>
				<li><a href = "<c:url value='/views/artist/artistList' />">Artists</a></li>
           </ul>
       </nav>
   </div>
</header>

<main>
    <h2>${music.title}</h2>
    <img src="${pageContext.request.contextPath}/img/${music.icon_path}" alt="${music.name}" width="150">
<!--    <p><a href = "aboutArtist?id=${music.artist_id}">${music.name}</a></p>-->
	<p><a href="<c:url value='/views/artist/aboutArtist?id=${music.artist_id}' />">${music.name}</a></p>
    <p>${music.genre}</p>
    <p>${music.description}</p>
    <p><fmt:formatDate value="${music.created_at}" pattern="yyyy/MM/dd" /></p>
    <p>￥${music.price}</p>
    
    <!-- カート追加ボタン -->
    <form action="<c:url value='/cart-add' />" method="post">
        <input type="hidden" name="music_id" value="${music.music_id}">
        <button type="submit">カートに追加</button>
    </form>
</main>

<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>