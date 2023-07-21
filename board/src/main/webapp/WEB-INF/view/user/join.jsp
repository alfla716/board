<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/view/include/header.jsp" %>
	<h1>회원가입</h1>
	<form action="/user/join" method="post">
		<input type="text" name="id" placeholder="사용자 ID"><br>
		<c:if test="${!empty msg }">
			${msg }
		</c:if><br>
		<input type="text" name="name" placeholder="사용자 이름"><br>
		<input type="password" name="pass" placeholder="사용자 비밀번호"><br>
		<input type="text" name="grade" placeholder="사용자 등급" value="GUEST"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>