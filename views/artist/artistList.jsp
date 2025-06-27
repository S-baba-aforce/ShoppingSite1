<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アーティスト一覧 - Underground × StarTunes</title>
<!--<link rel="stylesheet" href="css/search.css">-->
<!--<script src="js/search.js" defer></script>-->
<link rel = "stylesheet" href = "<c:url value = '/css/artistList.css' />">
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
    <form class = "sort-form" action = "artistList" method = "get">
    	<div class="select-wrapper">
    	<select name = "sort">
    		<option value="new" ${selectedSort == 'new' ? 'selected' : ''}>新着順</option>
        	<option value="popular" ${selectedSort == 'popular' ? 'selected' : ''}>人気順</option>
        	<option value="name" ${selectedSort == 'name' ? 'selected' : ''}>名前順</option>
    	</select>
    	<span class="custom-arrow">▼</span>
    	</div>
    	<button type="submit">change</button>
    </form>
    
    <!-- 新着アーティスト一覧 -->
	<section>
		<h2>Artists</h2>
		<ol class = "artist-list">
			<c:forEach var = "artist" items ="${newArtistList}" varStatus="status">
				<li class = "artist-card">
					<span class="rank">${status.index + 1}.</span>
					<img src="${pageContext.request.contextPath}/img/${artist.icon_path}" alt="${artist.name}" width="150">
                	<a href="aboutArtist?id=${artist.artist_id}">${artist.name}</a>
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