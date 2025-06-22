<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${artist.name} - Details</title>
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
	<!-- アーティスト情報 -->
    <section class="artist-info">
<!--        <img src="<c:url value='/images/artist/${artist.icon_path}' />" alt="${artist.name}" class="artist-icon-large">-->
        <h2>${artist.name}</h2>
        <p>${artist.bio}</p>
    </section>

    <!-- 人気楽曲一覧 -->
    <section class="popular-songs">
        <h3>人気楽曲</h3>
        <ul>
            <c:forEach var="music" items="${popularSongs}">
                <li>
                    <a href="aboutMusic.jsp?id=${music.music_id}">
                        ${music.title}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </section>

	<!-- SNSリンク -->
    <section class="sns-links">
        <h3>Follow</h3>
        <ul>
            <li><a href="#">Twitter</a></li>
            <li><a href="#">Instagram</a></li>
            <li><a href="#">YouTube</a></li>
        </ul>
    </section>

</main>

<footer>
    <p>musicLife.inc</p>
</footer>


</body>
</html>