package util;

public class ProductInfoValidator {
	
	public boolean nameValidator(String name) {
		// 상품 이름 규칙에 맞는지 확인
		if(name == null) {
			return true;
		}else if(name.trim().length() == 0) {
			return true;
		}else if(name.length() < 2 || name.length() > 30) {
			return true;
		}
		return false;
	}
	
	public boolean categoryValidator(String category) {
		// 상품 카테고리 규칙에 맞는지 확인
		if(category == null) {
			return true;
		}else if(category.trim().length() == 0) {
			return true;
		}else if(category.length() < 1 || category.length() > 4) {
			return true;
		}
		return false;
	}
	
	public boolean stockValidator(int stock) {
		// 상품 재고 규칙에 맞는지 확인
		if(stock < 0) {
			return true;
		}
		return false;
	}
	
	public boolean priceValidator(int price) {
		// 상품 가격 규칙에 맞는지 확인
		if(price < 0) {
			return true;
		}
		return false;
	}
	
	public boolean imgValidator(String img) {
		// 상품 이미지 규칙에 맞는지 확인
		
		// 맞지 않다면 true 반환
		
		// 맞다면 false 반환 
		
		return false;
	}
}
