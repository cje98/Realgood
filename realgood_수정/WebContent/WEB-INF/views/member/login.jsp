<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="<%=request.getContextPath()%>/resources/css/signin.css"
	rel="stylesheet">
</head>
<body class="text-center">
	<c:import url="../common/header.jsp"></c:import>
	<form class="form-signin"
		action="<%=request.getContextPath()%>/member/login.do" method="post">
		<h1 class="h3 mb-3 font-weight-normal">맛집 어때</h1>
		<br>
		<br> <label for="inputEmail" class="sr-only">Email
			address</label> <input type="email" id="memberId" name="memberId"
			class="form-control" placeholder="이메일 주소 입력(필수)" required autofocus>
		<label for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="memberPwd" name="memberPwd" class="form-control"
			placeholder="비밀번호 입력" required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				아이디 저장하기
			</label>
		</div>
		<a class="btn btn-outline-secondary"
			href="<%=request.getContextPath()%>/member/lookingForFormPwd.do">비밀번호
			찾기</a> <a class="btn btn-outline-secondary"
			href="<%=request.getContextPath()%>/member/lookingForFormId.do">아이디
			찾기</a>
		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2020-2023</p>
	</form>
	<c:import url="../common/footer.jsp"></c:import>
</body>
</html>