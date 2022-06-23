package util;

import javax.servlet.http.HttpServletResponse;

public class Validator {
	// 아이디가 올바른지 검증하는 메서드
	public boolean idValidator(String id) {
		boolean result = false;
		
		if(id == null) { 
			result = true;
		}else if(id.trim().length()==0) {
			result = true;
		}else if((id.length() < 4 ||id.length() > 10)) {
			result = true;
		}
				
		char[] lowerCase= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		char[] upperCase= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		char[] numberCase = {'0','1','2','3','4','5','6','7','8','9'};
		
		boolean existLowerCase = false;
		
		boolean existUpperCase = false;
		
		boolean existNumber = false;
		
		for(int i=0 ; i < lowerCase.length;i++) {
			char nth = lowerCase[i];
			
			if(id.indexOf(nth) != -1) {
				existLowerCase = true;
				break;
			}
		}
		for(int i=0 ; i < upperCase.length;i++) {
			char nth = upperCase[i];
			
			if(id.indexOf(nth) != -1) {
				existUpperCase = true;
				break;
			}
		}
		
		for(int i=0 ; i < numberCase.length;i++) {
			char nth = numberCase[i];
			
			if(id.indexOf(nth) != -1) {
				existNumber = true;
				break;
			}
		}
		
		if(!existLowerCase) {
			result = true;
		}else if(!existUpperCase) {
			result = true;
		}else if(!existNumber) {
			result = true;
		}
		return result;
	}
	
	// 비밀번호가 올바른지 검증하는 메서드
	public boolean pwValidator(String pw) {
		boolean result = false;
		
		if(pw == null) { 
			result = true;
		}else if(pw.trim().length()==0) {
			result = true;
		}else if((pw.length() < 6 || pw.length() > 16)) {
			result = true;
		}
		
		char[] lowerCase= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		char[] upperCase= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		char[] numberCase = {'0','1','2','3','4','5','6','7','8','9'};
		
		boolean existLowerCase = false;
		
		boolean existUpperCase = false;
		
		boolean existNumber = false;
		
		for(int i=0 ; i < lowerCase.length;i++) {
			char nth = lowerCase[i];
			
			if(pw.indexOf(nth) != -1) {
				existLowerCase = true;
				break;
			}
		}
		for(int i=0 ; i < upperCase.length;i++) {
			char nth = upperCase[i];
			
			if(pw.indexOf(nth) != -1) {
				existUpperCase = true;
				break;
			}
		}
		
		for(int i=0 ; i < numberCase.length;i++) {
			char nth = numberCase[i];
			
			if(pw.indexOf(nth) != -1) {
				existNumber = true;
				break;
			}
		}
		
		if(!existLowerCase) {
			result = true;
		}else if(!existUpperCase) {
			result = true;
		}else if(!existNumber) {
			result = true;
		}
		return result;
	}
	
	// 이름이 올바른지 검증하는 메서드
	public boolean nameValidator(String name) {
		boolean result = false;
		
		if(name == null) { 
			result = true;
		}else if(name.trim().length()==0) {
			result = true;
		}else if(name.length() != 3) {
			result = true;
		}
		
		// 이름에 한글외에 다른 문자면 
		for(int i=0;i<name.length();i++){
			if(Character.getType(name.charAt(i)) != 5) {
				result = true;
			}
		}
		return false;
	}
	
	// 전화번호가 올바른지 검증하는 메서드
	public boolean telValidator(String tel) {
		String frontTel = tel.substring(0, 3);
		String middleTel = tel.substring(4,8);
		String backTel = tel.substring(9,13);
		
		boolean result = false;
		
		if(frontTel.length() != 3) {
			result = true;
		}else if(middleTel.length() !=4 ) {
			result = true;
		}else if(backTel.length() != 4) {
			result = true;
		}
		
		if( tel.charAt(3) !='-' || tel.charAt(8) !='-') {
			result = true;
		}
		return result;
	}
	
	// 주소가 올바른지 검증하는 메서드
	public boolean addrValidator(String addr) {
		return false;
	}
	
	// 아이디가 올바른지 검증하는 메서드
	public boolean emailValidator(String email) {
		boolean result = false;
		
		int isEmail = email.indexOf("@");
		
		if(isEmail == -1) {
			result = true;
		}
		
		return result;
	}
}
