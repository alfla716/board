<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Buddy Buddy</h1>
<!-- login & logout 처리 -->
<div>
	<c:if test="${empty loginUser }">
		<c:if test="${!empty loginmsg }">
			${loginmsg }
		</c:if>
		<form method="post" action="/user/login">
			<input type="text" name="id">
			<input type="password" name="pass">
			<input type="submit">
		</form>
		<a href="/user/join"><button>회원가입</button></a>
	</c:if>
	<c:if test="${!empty loginUser }">
		${loginUser.name }님 반갑습니다. <a href="/user/logout">로그아웃</a>
	</c:if>
	<br>
	
	<c:if test="${!empty loginUser }">
		<a href="/board/regist">[게시글 등록]</a>
	</c:if>
	<a href="/board/list">[게시글 목록]</a>
	<hr>
</div>

<hr>