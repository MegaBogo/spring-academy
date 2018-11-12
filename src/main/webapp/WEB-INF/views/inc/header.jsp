<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
	<header>
		<h1><a href="/"><img src="/academy/resources/partners/sist/images/logo.jpg" alt="쌍용교육센터" /></a></h1>
		<section>
			<h1>사용자 프로필</h1>
			<div>사진</div>
			<div>
           	<security:authorize access="!isAuthenticated()">
           	<a href="/academy/member/login">로그인</a>
           	</security:authorize>
            <security:authorize access="isAuthenticated()">
           	<a href="/academy/member/logout"><security:authentication property="name" /> 님 로그아웃</a>
           	</security:authorize>			
           	</div>
		</section>
		<section class="bg-white main-menu">
			<h1 class="hidden">메인메뉴</h1>
			<ul class="hidden main-menu-list md-show-block">
				<c:forEach var="menu" items="${mainMenus }">
					<li><a href="${menu.url }">${menu.title}</a></li>
				</c:forEach>		
			</ul>
			<div>
				<h2 class="hidden">메뉴버튼들</h2>
				<span class="hidden">검색버튼</span>
				<span class="btn btn-hamburger btn-md-hamburger">확장버튼</span>
			</div>
		</section>
		<section class="bg-gray">
			<h1>홍보</h1>
			<div>
				<img src="" />최우수 훈련기관 5년 인증 선정 : 최상위 1%만 선정 - 고용노동부
			</div>
		</section>
	</header>


 