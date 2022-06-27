package product.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import product.dao.ProductInfoDao;
import product.dto.ProductInfo;

public class ProductService {
	
	public JSONObject getProductInfoList(int pageNumber) { 
		pageNumber = (pageNumber-1)*8;
		
		ProductInfoDao dao = new ProductInfoDao();
		
		List<ProductInfo> productInfoList = dao.getProductInfoList(pageNumber);
		
		JSONArray list = new JSONArray();
		
		int amount = dao.getAmount();
		
		if(amount != 0 ) {
			for(ProductInfo nth : productInfoList) {
				
				JSONObject json = new JSONObject();
				json.put("productIdx",nth.getProductIdx());
				json.put("name",nth.getName());
				json.put("category",nth.getCategory());
				json.put("stock",nth.getStock());
				json.put("price",nth.getPrice());
				json.put("img",nth.getImg());
				
				list.put(json);
			}
			
			JSONObject productInfoListAndAmount = new JSONObject();
			
			productInfoListAndAmount.put("list",list);
			productInfoListAndAmount.put("amount", amount);
			
			return productInfoListAndAmount;
		}else {
			return null;
		}
		
	}

	public JSONObject getProductInfoByProductIdx(int productIdx) {
		
		ProductInfoDao dao = new ProductInfoDao();
		
		ProductInfo productInfo = dao.getProductInfoByProductIdx(productIdx);
		
		if(productInfo != null) {
			JSONObject json = new JSONObject();
			
			json.put("productIdx",productInfo.getProductIdx());
			json.put("name",productInfo.getName());
			json.put("category",productInfo.getCategory());
			json.put("stock",productInfo.getStock());
			json.put("price",productInfo.getPrice());
			json.put("img",productInfo.getImg());
			
			return json;
		}else {
			return null;
		}
		
		
		
	}
}
