<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>楽曲情報の編集</title>
</head>
<body>
    <h2>楽曲情報の変更</h2>

    <form action= "song-edit-execute" method="post" enctype="multipart/form-data">

        <!-- ミュージックID（非編集、表示のみ） -->
        <p>
            ミュージックID：
            ${music.music_id}
            <input type="hidden" name="music_id" value="${music.music_id}">
        </p>

        <!-- アーティスト名（非編集、表示のみ） -->
        <p>
            アーティスト：
            ${music.name}
            <input type="hidden" name="artist_id" value="${music.artist_id}">
        </p>

        <!-- 楽曲タイトル -->
        <p>
            <label>タイトル：</label><br>
            <input type="text" name="title" value="${music.title}" required>
        </p>

        <!-- ジャンル -->
        <p>
            <label>ジャンル：</label><br>
            <input type="text" name="genre" value="${music.genre}" required>
        </p>

        <!-- 価格 -->
        <p>
            <label>価格：</label><br>
            <input type="number" name="price" value="${music.price}" required>
        </p>

        <!-- ファイルアップロード -->
        <p>
            <label>楽曲ファイル（再アップロードする場合）：</label><br>
            <input type="file" name="file_path">
        </p>

        <!-- 紹介文 -->
        <p>
            <label>紹介文：</label><br>
            <textarea name="description" rows="4" cols="50" required>${music.description}</textarea>
        </p>

        <input type="submit" value="更新する">
    </form>

    <br>
    <a href="<c:url value='/views/songRegister/songSearch.jsp' />">戻る</a>
</body>
</html>
