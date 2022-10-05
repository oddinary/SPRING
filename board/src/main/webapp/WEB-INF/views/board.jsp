<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>게시판 글 목록</h1>
	<div>
		<p>글 번호</p>
		<p>글 제목</p>
		<p>글 쓴이</p>
		<p>조회수</p>
	</div>
	<c:forEach var="article" items="${ dto.list }">
		<div>
			<p>${ article.no }</p>
			<p>${ article.title }</p>
			<p>${ article.writer }</p>
			<p>${ article.viewcount }</p>
		</div>
	</c:forEach>
	<p>${ dto.totalPage }</p>
	<div>
		<ul>
			<li><a href="board/write">글쓰기</a></li>
		</ul>
	</div>
</body>
</html>