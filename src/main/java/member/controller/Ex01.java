package member.controller;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "Hello World";
		String str2 = "  Hello World";
		String str3 = "Hello World  ";
		String str4 = "  Hello World  ";
		
		System.out.println("str1 의 길이 >"+str1.length());
		System.out.println("str2 의 길이 >"+str2.length());
		System.out.println("str3 의 길이 >"+str3.length());
		System.out.println("str4 의 길이 >"+str4.length());
		
		// trim() 메서드 : 문자열의 앞 , 뒤 공백을 지워주는 새로운 문자열을 리턴해줌 
		str2 =str2.trim();
		str3 =str3.trim();
		str4 =str4.trim();
		
		System.out.println("str2 의 길이 >"+str2.length());
		System.out.println("str3 의 길이 >"+str3.length());
		System.out.println("str4 의 길이 >"+str4.length());
		
		
		String id ="  ";
		id=id.trim();
		
		if(id.length() == 0 ) {
			System.out.println("아이디가 공백으로만 이루어져 있습니다 ");
		}
		
		int type; 
		
		String name = "dasjfl1ie ^&*으샤으샤 ㅁㄴ";
		for(int i=0;i<name.length();i++){
			if(Character.getType(name.charAt(i)) != 5) {
				System.out.println(name.charAt(i));
			}
		}
		
		
		String tel = "010-1111-1122";
		String frontTel = tel.substring(0, 3);
		String middleTel = tel.substring(4,8);
		String backTel = tel.substring(9,13);
		
		if(frontTel.length() != 3) {
			System.out.println("-이 아닙니다");
		}else if(middleTel.length() !=4 ) {
			System.out.println("-이 아닙니다");
		}else if(backTel.length() != 4) {
			System.out.println("-이 아닙니다");
		}
		
		
		if( tel.charAt(3) !='-' || tel.charAt(8) !='-') {
			System.out.println("-이 아닙니다");
		} else {
			System.out.println("완료");
		}

		System.out.println(frontTel);
		System.out.println(middleTel);
		System.out.println(backTel);
		
		String email = "ASd212asd";
		
		int isEmail=email.indexOf("@");
		
		if(isEmail == -1) {
			System.out.println("@없습");
		}
		
		System.out.println(isEmail);
		
		boolean result= false;
		
		String addr="";
		
		String[] list = {"서울특별시", "부산광역시","인천광역시","광주광역시","대구광역시","제주특별자치도","경기도","강원도","전라도","경상도"};
		boolean isList=false;
		
		for(String nth:list) {
			if(addr.equals(nth)) {
				isList=true;
			}
		}
		
		if(addr == null) { 
			result = true;
		}else if(addr.trim().length()==0) {
			result = true;
		}else if(addr.length() > 20) {
			result = true;
		}
		
		System.out.println((result || !isList)+" : true 이면 잘못됨");
	
		
		
		double amountTemp = 17/8.0;
    	System.out.println(amountTemp);
    	int pageNum= (int) Math.ceil(amountTemp);
		
		System.out.println(pageNum+"dd");
	}

}
