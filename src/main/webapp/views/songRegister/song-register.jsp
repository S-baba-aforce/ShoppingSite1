<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>


<!DOCTYPE html>
<html>
<head>
    <title>楽曲情報管理</title>
</head>
<body>
    <h1>楽曲管理メニュー</h1>

    <form action="song-add" method="get">
        <p>①<input type="submit" value="楽曲情報追加"></p>
    </form>
    <br>
<!--    <form action="/views/songEditor/songSearch.jsp" method="post">-->
     <a href = "<c:url value='/views/songEditor/songSearch.jsp' />">②楽曲情報変更</a>
<!--        <p>②<input type="submit" value="楽曲情報変更"></p>-->
    </form>
    <br>
<!--    <form action="song-delete" method="get">-->
<!--        <p>③<input type="submit" value="楽曲情報削除"></p>-->
<!--    </form>-->
    <a href = "<c:url value = '/views/songEditor/songDelete.jsp' />">③楽曲情報削除</a>
    <br><br>
    
    <a href= "<c:url value='/views/maneger/manegerMenu.jsp' />">管理者メニュー画面に戻る</a>
    

</body>
</html>
