package util;

public class MemberInfoValidator {
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
	// 규칙 : 3자만 가능, 한글만 가능 
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
		return result;
	}
	
	
	// 전화번호가 올바른지 검증하는 메서드
	// 규칙: 010-1111-2222 와 같은 형식만 가능
	//     각 자리마다 하이픈이 반드시 있어야하고 
	//     첫 자리는 3자, 중간 자리는 4자, 마지막 자리는 4자여야함 
	public boolean telValidator(String tel) {
		// 문자열의 split() 매서드를 활용
		
		
		boolean result = false;
		
		if(tel == null) { 
			result = true;
		}else if(tel.trim().length()==0) {
			result = true;
		}else if(tel.length() != 13) {
			result = true;
		}
		
		String frontTel = tel.substring(0, 3);
		String middleTel = tel.substring(4,8);
		String backTel = tel.substring(9,13);
		
		
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
	// 규칙 : 특별시 , 광역시, 시, 도만 가능
	// 서울 특별시
	// 인천 광역시
	// 제주특별자치도
	// ... 
	public boolean addrValidator(String addr) {
		boolean result= false;
		
		String[] list = {"특별시", "광역시","시","도"};
		
		for(String nth:list) {
			if(addr.equals(nth)) {
			}
		}
		
		if(addr == null) { 
			result = true;
		}else if(addr.trim().length()==0) {
			result = true;
		}else if(addr.length() > 20) {
			result = true;
		}
		return result;
	}
	
	// 아이디가 올바른지 검증하는 메서드
	public boolean emailValidator(String email) {
		boolean result = false;
		
		if(email == null) { 
			result = true;
		}else if(email.trim().length()==0) {
			result = true;
		}else if(email.length() > 50) {
			result = true;
		}
		
		int isEmail = email.indexOf("@");
		
		if(isEmail == -1) {
			result = true;
		}
		
		return result;
	}

}
