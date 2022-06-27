package product.service;

import java.io.File;

import product.dao.MngProductDao;
import product.dto.ProductInfo;

public class MngProductService {
	
	public boolean add(ProductInfo productInfo) {
		MngProductDao dao = new MngProductDao();
		
		return dao.insert(productInfo);
	}
	
	
	public boolean update(ProductInfo productInfo) {
		MngProductDao dao = new MngProductDao();
		
		return dao.update(productInfo);
	}
	
	public boolean deleteImg(int productIdx) {
		MngProductDao dao = new MngProductDao();
		
		ProductInfo productInfo = dao.selectByProductIdx(productIdx);
		
		String img = productInfo.getImg();
		// 상품에 등록에 이름 
		
		File file = new File("C:\\upload\\"+img);
		
		if(file.delete()) {
			return dao.setImgNull(productIdx);
			
		}else {
			return false;
		}
		
		
		
	}

	public boolean addImg(int productIdx, String img) {
		MngProductDao dao = new MngProductDao();
		
		return dao.updateImg(productIdx,img);	
	}
	
	public boolean deleteProduct(int productIdx) {
		MngProductDao dao = new MngProductDao();
		
		ProductInfo productInfo = dao.selectByProductIdx(productIdx);
		
		if(productInfo.getImg()!=null) {
			File file = new File("C:\\upload\\"+productInfo.getImg());
			
			file.delete();
		}
		
		return dao.delete(productIdx);
		
	}
	
}
