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
	<h1>메인페이지 입니다.</h1>
	
	<!-- 로그인 정보 없는 경우 -->
	<c:if test="${empty id }">
		<c:redirect url="/member/login"/>
	</c:if>
	
	${id }님 환영합니다. <br>
	
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';">  <hr>
	
	<h3><a href="/member/info">회원정보 조회</a></h3>
	
	
	
</body>
</html>