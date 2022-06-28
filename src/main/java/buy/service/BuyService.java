package buy.service;

import buy.dao.BuyInfoDao;
import buy.dto.BuyInfo;
import product.dao.ProductInfoDao;
import product.dto.ProductInfo;

public class BuyService {
	
	public int buy(BuyInfo buyInfo){
		// 물건의 재고를 확인해서 재고가 0 이면 재고가 없다는 값을 반환
		ProductInfoDao productInfoDao = new ProductInfoDao();
		
		ProductInfo productInfo =  productInfoDao.selectByProductIdx(buyInfo.getProductIdx());

		if(productInfo.getStock() == 0 ) {
			// 재고가 없다를 반환
			return 204;
		}
		
		// 물건의 재고가 있다면 
		// 구매 내역을 생성하기 전 
		// 물건의 재고를 하나 감소 시킴
		productInfoDao.decreaseStock(buyInfo.getProductIdx());
		
		
		BuyInfoDao dao = new BuyInfoDao();
		if(dao.addBuyInfo(buyInfo)) {
			return 200;
		}else {
			return 500;
		}
		
	}
	
}
