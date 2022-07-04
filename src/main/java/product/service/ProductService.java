package product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import product.dao.ProductInfoDao;
import product.dto.ProductInfo;

public class ProductService {
	
	public int getAmount() {
		ProductInfoDao dao = new ProductInfoDao();
		
		int amount = dao.getAmount();
		
		return amount;
	}
	
	public List<ProductInfo> getProductInfoList(int pageNumber) { 
		int start = (pageNumber-1)*8;
		
		ProductInfoDao dao = new ProductInfoDao();
		
		List<ProductInfo> productInfoList = dao.getProductInfoList(start);
		
		return productInfoList;
	}

	
	public ProductInfo getProductInfoByProductIdx(int productIdx) {
		
		ProductInfoDao dao = new ProductInfoDao();
		
		return dao.selectByProductIdx(productIdx);
		
	}
	
}