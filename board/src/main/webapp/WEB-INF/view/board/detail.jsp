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
	<%@include file="/WEB-INF/view/include/header.jsp" %>
	<h1>게시글 상세</h1>
	<form method="post" action="/board/update">
		<input type="hidden" name="userId" value="${board.user.id }"><br>
		<input type="text" name="no" value="${board.no }" readonly="readonly"><br>
		<input type="text" value="${board.user.name }" disabled="disabled"><br>
		<input type="text" name="title" value="${board.title }"><br>
		<textarea rows="10" cols="100" name="content">${board.content }</textarea><br>
		
		<c:if test="${!empty loginUser && loginUser.id==board.user.id }">
			<input type="submit" value="수정">
			<a href="/board/delete?no=${board.no }"><input type="button" value="삭제"></a>
		</c:if>
	</form>
	
	
	<h1>댓글</h1>
	<table>	    
		<tr>
			<th>number</th>
		    <th>writer</th>
		    <th>content</th>
	    </tr>
		<c:forEach items="${replys }" var="reply">
			<tr>
				<td>${reply.no }</td>
				<td>${reply.user.name }</td>
				<td>${reply.content }</td>
				<c:if test="${!empty loginUser && loginUser.id==reply.user.id }">
					<td><a href="/reply/delete?no=${reply.no }"><input type="button" value="삭제"></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	
	<% System.out.println("---- " + request.getAttribute("reply")); %>
	
	<%@include file="/WEB-INF/view/reply/regist.jsp" %>
	

</body>
</html>