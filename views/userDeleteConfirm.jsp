<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
<link rel = "stylesheet" href = "<c:url value = '/css/userDeleteConfirm.css' />">
</head>
<body>

	<main>
		<div class="container">
			<h2>削除してもよろしいですか？</h2>

			<p>${customer.fullName }さん</p>

			<form action="user-delete-confirm" method="post">

				<button type="submit" name="confirm" value="はい">はい</button>
				<button type="submit" name="confirm" value="いいえ">いいえ</button>

			</form>
		</div>
	</main>
	
	<footer>
		<p>musicLife.inc</p>
	</footer>

</body>
</html>