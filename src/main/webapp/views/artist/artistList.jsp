<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アーティスト一覧 - Underground × StarTunes</title>
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
				<li><a href = "<c:url value='/views/music/artistList' />">アーティスト一覧</a></li>
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
    <form action = "artistList" method = "get">
    	<label>並べ替え：</label>
    	<select name = "sort">
    		<option value="new" ${selectedSort == 'new' ? 'selected' : ''}>新着順</option>
        	<option value="popular" ${selectedSort == 'popular' ? 'selected' : ''}>人気順</option>
        	<option value="name" ${selectedSort == 'name' ? 'selected' : ''}>名前順</option>
    	</select>
    	<button type="submit">並び替え</button>
    </form>
    
    <!-- 新着アーティスト一覧 -->
	<section>
		<h2>アーティスト一覧</h2>
		<div class = "new-artist">
			<c:forEach var = "artist" items ="${newArtistList}">
				<div class = "artist-card">
					<img src="<c:url value='/images/artist/${artist.icon_path}' />" alt="${artist.name}" class="artist-icon">
                	<p><a href="aboutArtist?id=${artist.artist_id}">${artist.name}</a></p>
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