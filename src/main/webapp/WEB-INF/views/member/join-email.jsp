<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
	<h1>회원가입 폼</h1>
	<h2>가입을 위한 이메일 주소를 입력해주세요.</h2>
	<form method="post">
		<div>
			<label for="email">이메일 : </label>
			<input type="text" name="email" id="email" >
		</div>
		<div>
			<input type="submit" value="검증 메일 보내기" />
		</div>
	</form>
</main>