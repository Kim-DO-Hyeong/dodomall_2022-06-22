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

	public JSONObject getProductInfoByProductIdx(int productIdx) {
		
		ProductInfoDao dao = new ProductInfoDao();
		
		ProductInfo productInfo = dao.selectByProductIdx(productIdx);
		
		if(productInfo != null) {
			JSONObject json = new JSONObject();
			
			json.put("productIdx",productInfo.getProductIdx());
			json.put("name",productInfo.getName());
			json.put("category",productInfo.getCategory());
			json.put("stock",productInfo.getStock());
			json.put("price",productInfo.getPrice());
			json.put("img",productInfo.getImg());
			json.put("insertDate",productInfo.getInsertDate());
			
			return json;
		}else {
			return null;
		}
		
	}
	
	public ProductInfo study_getProductInfoByProductIdx(int productIdx) {
		
		ProductInfoDao dao = new ProductInfoDao();
		
		return dao.selectByProductIdx(productIdx);
		
	}
	
}