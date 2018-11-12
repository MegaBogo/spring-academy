<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
	<h1>회원가입 진행</h1>
	<section>
		<h1>회원 가입 페이지</h1>
		<form method="post" id="form-section" enctype="multipart/form-data">
			<table>
				<tr>
					<td>
						<label>사진 : </label>
						<img class="foto" src="" />
						<input type="file" name="photo-file" hidden="true" value="사진 선택" />
						<span class="foto-button">사진선택</span>
					</td>
				</tr>			
				<tr>
					<td>
						<label>아이디 : </label>
						<input type="text" name="id" pattern="[A-Za-z0-9]{4,12}" />
						<input type="button" class="id-check-button" value="중복 조회" required="required" />
					</td>
				</tr>
				<tr>
					<td>
						<label>패스워드 : </label>
						<input name="pwd" type="password" />
					</td>
				</tr>				
				<tr>
					<td>
						<label>이름 : </label>
						<input type="text" name="name"  required="required" />
					</td>
				</tr>
				<tr>
					<td>
						<label>이메일 : </label>
						<input name="email" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td>
						<label>다음 계산 결과는? <img src="../resources/images/moonjage.jpg" /> : </label>
						<input name="moonjage" />
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="회원가입" /></td>
				</tr>
			</table>
		</form>
	</section>
</main>
<script type="text/javascript">
<!--
window.addEventListener("load", function(event){
	var formSection = document.querySelector("#form-section");
	var fotoButton = formSection.querySelector(".foto-button");
	var fileButton = formSection.querySelector("input[name=photo-file]");
	var foto = formSection.querySelector(".foto");
	var idCheckButton = formSection.querySelector(".id-check-button");
	var idInput = formSection.querySelector("input[name=id]");
	var submitButton = formSection.querySelector("input[type=submit]");
	var idOk = false;

	fileButton.onchange = function(e) {
		var reader = new FileReader();
		var file = fileButton.files[0];
		
		//자바스크립트는 모든 속성이 맵이야 
		if (file.type.indexOf('image/') == -1) {
			alert("이미지 형식이 아닙니다.");
			return;
		}
		
		if(file.size > 1024 * 1024 * 10) {
			alert("프로필 사진은 10MB를 초과할 수 없습니다.");
			return;	
		}
		
		reader.onload = function(evt){
			foto.src = evt.target.result;
		};
		reader.readAsDataURL(file);	
	};
		
	fotoButton.onclick = function(e) {
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles':true,
            'cancelable':true
        });
        fileButton.dispatchEvent(event);
	};
	submitButton.onclick = function(e) {
		if(!idOk) {
			alert("아이디 중복 검사를 하지 않았거나 유효한 아이디가 아닙니다.");
			e.preventDefault();
		}
	};

	idCheckButton.onclick = function(e) {
		//ajax -> 협력자 백엔드에게 연락해서 알아봐야 함.
		
		var id = idInput.value;
		
		var request = new XMLHttpRequest();
		request.onload = function(e) {
			if(request.status != 200) {
				alert("서버상의 오류가 발생하였습니다.");
			    return;
			}
			var duplicated = JSON.parse(request.responseText);
			if(duplicated) {
				alert("이미 사용중인 아이디입니다.");
				return;
			}

			idOk = true;
			
		};
		
		request.open("GET", "is-id-duplicated?id="+id, true);
		request.send();
		
	};
});
//-->
</script>