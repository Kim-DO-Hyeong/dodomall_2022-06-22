package product.service;

import product.dao.MngProductDao;
import product.dto.ProductInfo;

public class MngProductService {
	
	public boolean add(ProductInfo productInfo) {
		MngProductDao dao = new MngProductDao();
		
		return dao.insert(productInfo);
	}
	
}
