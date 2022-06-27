package product.service;

import java.util.List;

import product.dao.ProductInfoDao;
import product.dto.ProductInfo;

public class ProductService {
	
	public void getProductInfoList(int pageNumber) { 
		pageNumber = (pageNumber-1)*8;
		
		ProductInfoDao dao = new ProductInfoDao();
		
		List<ProductInfo> productInfoList = dao.getProductInfoList(pageNumber);
		
		
		
	}
}
