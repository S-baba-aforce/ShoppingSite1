<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>楽曲情報の削除</title>
</head>
<body>
	<h2>楽曲情報の削除</h2>
	
	<form action= "song-delete-execute" method="post" enctype="multipart/form-data">

	    <p>
            ミュージックID：
            ${music.music_id}
            <input type="hidden" name="music_id" value="${music.music_id}">
        </p>
        
        <p>
            アーティスト：
            ${music.name}
            <input type="hidden" name="artist_id" value="${music.artist_id}">
        </p>
        
        <p>
            タイトル：
            ${music.title}
            <input type="hidden" name="title" value="${music.title}">
        </p>
        
        <p>
            ジャンル：
            <input type="hidden" name="genre" value="${music.genre}">
        </p>
        
        <p>
            価格：
            <input type="hidden" name="price" value="${music.price}">
        </p>
        
        <p>
            楽曲ファイル：
            <input type="hidden" name="file_path" value ="${music.file_path}">
        </p>
        
        <p>
            <label>紹介文：</label><br>
            <input type = "hidden" name="description" value ="${music.description}">
        </p>
        
        <input type="submit" value="削除する">
     </form>
        
        <a href="<c:url value='/views/songDeleteBox/dustSongSearch.jsp' />">戻る</a>
	
</body>
</html>