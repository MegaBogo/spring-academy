<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<main>
	<form method="post">
		<section>
			<h1>메뉴 목록</h1>
			<ul>
				<c:forEach var ="menu" items="${menus }">
				<li>
					<!-- onchange="submit();" -->
					<input type="checkbox" name="menu-id" value="${menu.id }" /><span>${menu.title }</span>
					<input type="submit" name="action" data-menu-id="${menu.id}" onclick="document.querySelector('.selected-menu-id').value=this.parentElement.firstElementChild.value;" value="수정" />
					<input type="submit" name="action" data-menu-id="${menu.id}" onclick="document.querySelector('.selected-menu-id').value=this.parentElement.firstElementChild.value;" value="삭제" />
				</li>
				</c:forEach>
			</ul>
			<fieldset>
				<legend>메뉴 입력</legend>
				<div>
					<label>이름 : </label>
					<input type="text" name="title" value="${selectedMenu.title }" />
				</div>
				<div>
					<label>URL : </label>
					<input type="text" name="url" value="${selectedMenu.url }" />
				</div>
			</fieldset>
			<div>
				<!-- submit 누르면 클릭한 submit에 name만 감  -->
				<input type="hidden" name="selected-menu-id" value="${selectedMenu.id }" class="selected-menu-id" />
				<input type="submit" name="action" value="일괄삭제" />
				<input type="submit" name="action" value="저장" />
				<input type="submit" name="action" value="추가" />
			</div>
		</section>
	</form>
	<script>
	/*
	window.addEventListener("load", function(){
		var form = document.querySelector("form");
		var menuId = form.querySelector(".menu-id");
		form.addEventListener("click", function(e){
			var el = e.target;
			
    		if(e.target.nodeName != "INPUT")
				return;
    		
			if(el.type != "submit")
				return;
			
			var action = el.value;    
			switch (action) {
				case "수정":
					menuId.value = el.dataset.menuId;
					break;
			}
			e.preventDefault();

		});
	});
	*/
	</script>
	
</main>

