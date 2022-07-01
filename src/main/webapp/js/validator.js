/**
 * 
 */
 
 function idValidator(id){
	// 아이디 규칙 
	// 인터페이스 문서와 자바의 Util 패키지 내 MemberInfoValidator 등을 참고해서 구현 
	// 자바스크립트도 정규 표현식으르 사용할 수 있음 
	
	// 규칙에 맞는 아이디라면 false를 반환 
	// 규칙에 맞지 않는 아이디라면 true 반환 
	return false;
	
}

 function pwValidator(pw){
	// 비밀번호 규칙 
	// 인터페이스 문서와 자바의 Util 패키지 내 MemberInfoValidator 등을 참고해서 구현 
	// 자바스크립트도 정규 표현식으르 사용할 수 있음 
	
	return false;
}

 function nameValidator(name){
	// 이름 규칙 
	// 인터페이스 문서와 자바의 Util 패키지 내 MemberInfoValidator 등을 참고해서 구현 
	// 자바스크립트도 정규 표현식으르 사용할 수 있음 
	
	// 한글로만 이루어지고 3글자
	let reg = /^[ㄱ-ㅎ가-힣]{3}$/;
	
	let result = reg.test(name);
	
	return !result;
}
function telValidator(tel){
	// 연락처 규칙 
	// 인터페이스 문서와 자바의 Util 패키지 내 MemberInfoValidator 등을 참고해서 구현 
	// 자바스크립트도 정규 표현식으르 사용할 수 있음 
	let reg=/\d{3}-\d{4}-\d{4}/;
	let result = reg.test(tel);
	
	return !result;
} 
function addrValidator(addr){
	// 주소 규칙 
	// 인터페이스 문서와 자바의 Util 패키지 내 MemberInfoValidator 등을 참고해서 구현 
	// 자바스크립트도 정규 표현식으르 사용할 수 있음 
	
	return false;
} 
function emailValidator(email){
	// 이메일 규칙 
	// 인터페이스 문서와 자바의 Util 패키지 내 MemberInfoValidator 등을 참고해서 구현 
	// 자바스크립트도 정규 표현식으르 사용할 수 있음 
	
	return false;
}  