<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs - Underground × StarTunes</title>
<!--<link rel="stylesheet" href="css/search.css">-->
<!--<script src="js/search.js" defer></script>-->
<link rel = "stylesheet" href = "<c:url value = '/css/musicList.css' />">
</head>
<body>

<header>
    <div class="header-container">
        <h1>Underground × StarTunes</h1>
        <nav class="nav-desktop">
            <ul>
                <li><a href = "<c:url value='/views/music/musicList' />">Songs</a></li>
				<li><a href = "<c:url value='/views/artist/artistList' />">Artists</a></li>
<!--                <li><a href="cart.jsp">🛒</a></li>-->
<!--                <li><a href="user-menu.jsp">マイページ</a></li>-->
            </ul>
        </nav>
    </div>
</header>

<main>

    <!-- 検索バー -->
    <form id="searchForm" action="searchForm" method="get">
        <input type="text" id="searchQuery" name="query" placeholder="タイトルまたはアーティスト" required>
        <label><input type="radio" name="type" value="title" checked>タイトル</label>
        <label><input type="radio" name="type" value="artist">アーティスト</label>
        <button type="submit">Search</button>
    </form>
    
    <!-- 並び替え機能 -->
	<form class = "sort-form" action="musicList" method="get">
			<div class="select-wrapper">
				<select name="sort">
					<option value="new" ${selectedSort == 'new' ? 'selected' : ''}>新着順</option>
					<option value="popular" ${selectedSort == 'popular' ? 'selected' : ''}>人気順</option>
					<option value="price_high" ${selectedSort == 'price_high' ? 'selected' : ''}>価格が高い順</option>
					<option value="price_low" ${selectedSort == 'price_low' ? 'selected' : ''}>価格が安い順</option>
				</select> 
				<span class="custom-arrow">▼</span>
			</div>
			<button type="submit">change</button>
		</form>


		<!-- 新着楽曲一覧 -->
    <section>
        <h2>Songs</h2>
        <ol class="music-list">
            <c:forEach var="music" items="${newMusicList}" varStatus="status">
                <li class="music-card">
                	<span class="rank">${status.index + 1}.</span>
                	<img src="${pageContext.request.contextPath}/img/${music.icon_path}" alt="${music.name}" />
                	<a class = "title" href= "<c:url value='/views/music/aboutMusic?id=${music.music_id}' />">${music.title}</a>
                    <a class = "artist" href= "<c:url value='/views/artist/aboutArtist?id=${music.artist_id}' />">${music.name}</a>
<!--                    <h4>${music.title}</h4>-->
<!--                    <h4>${music.name}</h4>-->
                    <span class="genre">${music.genre}</span>
                    
                </li>
            </c:forEach>
        </ol>
    </section>

</main>

<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>





