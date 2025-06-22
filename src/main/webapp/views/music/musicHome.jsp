<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Undergrounded × StarTunes</title>
<link rel = "stylesheet" href = "css/search.css">
<script src="js/search.js"defer></script>
</head>
<body>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
	
<header>
	<div class = "header-container">
		<h1>Underground × StarTunes</a></h1>
		<nav class = "nav-desktop">
			<ul>
				<li><a href = "<c:url value='/views/music/musicList' />">楽曲一覧</a></li>
				<li><a href = "<c:url value='/views/artist/artistList' />">アーティスト一覧</a></li>
				<li><a href = "cart.jsp">🛒</a></li>
				<li><a href = "user-menu.jsp">マイページ</a></li>
			</ul>
		</nav>
	</div>
</header>

<main>

	<!-- 検索バー -->
	<form id = "searchForm" action = "searchForm" method = "get">
        <input type="text" id="searchQuery" name="query" placeholder="タイトルまたはアーティスト" required>
        <label><input type="radio" name="type" value="title" checked>タイトル</label>
        <label><input type="radio" name="type" value="artist">アーティスト</label>
        <button type="submit">検索</button>
    </form>
    
    <div id="popup" class="hidden">
  		<div id="popupContent"></div>
  		<button id="closeBtn">閉じる</button>
	</div>
    
    

	<!-- 人気楽曲表示 -->
	<section>
		<h2>Popular Songs</h2>
		<div class = "popular-music">
			<c:forEach var = "music" items = "${popularMusicList }">
				<div class = "music-card">
					<a href="<c:url value='/views/music/aboutMusic?id=${music.music_id}' />">‣${music.title}</a>
					<a href="<c:url value='/views/artist/aboutArtist?id=${music.artist_id}' />">‣${music.name}</a>
<!--					<h4>${music.title}</h4>-->
<!--					<h4>${music.name}</h4>-->
					<p>ジャンル：${music.genre}</p>
<!--					<p>価格：￥${music.price}</p>-->
					
				</div>
			</c:forEach>
		</div>
	</section>

	<!-- 新着楽曲表示 -->
	<section>
		<h2>New Comers</h2>
		<div class = "new-music">
			<c:forEach var = "music" items = "${newMusicList}">
				<div class = "music-card">
					<a href="<c:url value='/views/music/aboutMusic?id=${music.music_id}' />">‣${music.title}</a>
					<a href="<c:url value='/views/artist/aboutArtist?id=${music.artist_id}' />">‣${music.name}</a>
<!--					<h4>${music.title}</h4>-->
<!--					<h4>${music.name}</h4>-->
					<p>ジャンル：${music.genre}</p>
<!--					<p>価格：￥${music.price}</p>-->
					
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