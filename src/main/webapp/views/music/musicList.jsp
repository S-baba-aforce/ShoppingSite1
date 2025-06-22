<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>楽曲一覧 - Underground × StarTunes</title>
<link rel="stylesheet" href="css/search.css">
<script src="js/search.js" defer></script>
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

    <!-- 検索バー -->
    <form id="searchForm" action="searchForm" method="get">
        <input type="text" id="searchQuery" name="query" placeholder="タイトルまたはアーティスト" required>
        <label><input type="radio" name="type" value="title" checked>タイトル</label>
        <label><input type="radio" name="type" value="artist">アーティスト</label>
        <button type="submit">検索</button>
    </form>
    
    <!-- 並び替え機能 -->
	<form action="musicList" method="get">
		<label>並べ替え：</label> 
		<select name="sort">
			<option value="new" ${selectedSort == 'new' ? 'selected' : ''}>新着順</option>
        	<option value="popular" ${selectedSort == 'popular' ? 'selected' : ''}>人気順</option>
        	<option value="price_high" ${selectedSort == 'price_high' ? 'selected' : ''}>価格が高い順</option>
        	<option value="price_low" ${selectedSort == 'price_low' ? 'selected' : ''}>価格が安い順</option>
		</select>
		<button type="submit">並び替え</button>
	</form>


		<!-- 新着楽曲一覧 -->
    <section>
        <h2>楽曲一覧</h2>
        <div class="new-music">
            <c:forEach var="music" items="${newMusicList}">
                <div class="music-card">
                	<a href="aboutMusic?id=${music.music_id}">‣${music.title}</a>
                    <a href="<c:url value='/views/artist/aboutArtist?id=${music.artist_id}' />">‣${music.name}</a>
<!--                    <h4>${music.title}</h4>-->
<!--                    <h4>${music.name}</h4>-->
                    <p>ジャンル：${music.genre}</p>
                    
                </div>
            </c:forEach>
        </div>
    </section>

</main>

<footer>
    <p>musicLife.inc</p>
</footer>

</body>
</html>





