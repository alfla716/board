<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 댓글작성 -->
	<c:if test="${!empty loginUser }">
	<h1>댓글 작성</h1>
	<form method="post" action="/reply/regist">
		<!-- 
		<p>
			<textarea rows="5" cols="50" name="content"></textarea>
		</p>
		<p>
			<button type="submit">댓글 작성</button>
		</p> 
		-->
		<label>글번호: <input type="text" value="${board.no }" readonly="readonly" name="boardNo"></label><br>
		<label>작성자: <input type="text" value="${loginUser.id }" readonly="readonly" name="userId"></label><br>
		<textarea rows="3" cols="100" name="content"></textarea><br>
		
		<input type="submit" value="등록">
	</form>
	</c:if>
	
	<!-- 댓글리스트 -->
	
	<!-- <c:forEach items="${replys }" var="reply">
			<tr>
				<td>${reply.no }</td>
				<td>${reply.content }</td>
				<td>${reply.user.name }</td>
			</tr>
	</c:forEach> -->
	
	
	<!-- 댓글구현끝 -->

</body>
</html>