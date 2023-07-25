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
	<h1>댓글</h1>
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
	
	<hr>
	
	<!-- 댓글리스트 -->
	<ul>
		<li>첫번째 댓글</li>
		<li>두번째 댓글</li>
		<li>세번째 댓글</li>
	</ul>
	<% System.out.println(request.getAttribute("reply")); %>
<%--	<c:if test="${!empty loginUser && board.no==reply.board.no }">--%>
		<c:forEach items="${replys}" var="reply">
			<tr>
			<tr>
			<tr>
			<tr>
				<td>${reply.no }</td>
				<td>${reply.content }</td>
				<td>${reply.user.name }</td>
			</tr>
		</c:forEach>
<%--	</c:if>--%>
	
	
		
		<!-- 댓글리스트 
		<table>
			<tr><td>no</td><td>reply content</td><td>writer</td></tr>
			<c:forEach items="${reply.content }" var="reply">
				<tr>
					<td>${reply.no }</td>
					<td>${reply.content }</td>
					<td>${reply.user.name }</td>
				</tr>
			</c:forEach>
		</table>
		-->
	
		<!-- 
		<tr><td>no</td><td>reply content</td><td>writer</td></tr>
		<c:forEach items="${pageInfo.content }" var="reply">
			 -->
	<!-- <form method="get" action="/reply/list">
		
	</form> -->		 
	
			<!-- </c:forEach>
	 -->
		
		
		
	
	
	<!--  댓글리스트
	<table>
		<tr><td>no</td><td>reply content</td><td>writer</td></tr>
		<c:forEach items="${pageInfo.content }" var="board">
			<tr>
				<td><a href="/board/detail?no=${board.no }">${board.no }</a></td>
				<td>${board.title }</td>
				<td>${board.user.name }</td>
			</tr>
		</c:forEach>
	</table>
	-->
	
	<!-- 댓글구현끝 -->

</body>
</html>