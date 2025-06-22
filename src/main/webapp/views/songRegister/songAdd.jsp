<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>

<html>
<head>
    <title>楽曲情報追加</title>
</head>
<body>
    <h1>楽曲情報追加</h1>

    <form action="song-add-confirm" enctype="multipart/form-data" method="post">
    	<label>ミュージックID：</label><br>
    	<input type = "text" name = "music_id" pattern = "[A-Za-z0-9]+" required><br><br>
        <label>タイトル：</label><br>
        <input type="text" name="title" required><br><br>

        <label>アーティスト：</label><br>
        <select name="artist_id" required>
            <option value="">--選択してください--</option>
            <c:forEach var="artist" items="${artistList}">
                <option value="${artist.artist_id}">${artist.name}</option>
            </c:forEach>
        </select><br><br>

        <label>ジャンル：</label><br>
        <input type="text" name="genre" required><br><br>

        <label>￥価格：</label><br>
        <input type="number" name="price" required><br><br>

        <label>楽曲データ：</label><br>
        <input type="file" name="file_path"><br><br>

        <label>紹介文：</label><br>
        <textarea name="description" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="確認">
    </form>

    <br>
    <a href="<c:url value='/views/songRegister/songRegister.jsp' />">楽曲メニューに戻る</a>
    
</body>
</html>
