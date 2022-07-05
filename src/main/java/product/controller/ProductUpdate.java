package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import exception.BadParameterException;
import product.dto.ProductInfo;
import product.service.MngProductService;
import product.service.ProductService;
import util.ProductInfoValidator;
import util.URLs;

@WebServlet("/mng/product/update")
public class ProductUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String realPath = request.getServletContext().getRealPath("/images/product"); 
			MultipartRequest req = new MultipartRequest(request, realPath, 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
			
			int productIdx =Integer.parseInt(req.getParameter("productIdx"));
			String name = req.getParameter("name");
			String category = req.getParameter("category");
			int stock = Integer.parseInt(req.getParameter("stock"));
			int price = Integer.parseInt(req.getParameter("price"));
			String img = req.getFilesystemName("img");
			
			if(img == null) {
				ProductService productService = new ProductService();
				ProductInfo imgProductInfo = productService.getProductInfoByProductIdx(productIdx);
				img = imgProductInfo.getImg();
			}
			
			ProductInfoValidator validator = new ProductInfoValidator(); 
			
			if(validator.nameValidator(name)) 					throw new BadParameterException();
			else if(validator.categoryValidator(category)) 		throw new BadParameterException();
			else if(validator.stockValidator(stock)) 			throw new BadParameterException();
			else if(validator.priceValidator(price)) 			throw new BadParameterException();
			
			
			ProductInfo updateProductInfo = new ProductInfo();
			
			updateProductInfo.setProductIdx(productIdx);
			updateProductInfo.setName(name);
			updateProductInfo.setCategory(category);
			updateProductInfo.setStock(stock);
			updateProductInfo.setPrice(price);
			updateProductInfo.setImg(img);
			
			
			MngProductService service = new MngProductService();
			service.update(updateProductInfo);
			
			response.sendRedirect(URLs.PRODUCT_DETAIL_PAGE+"&productIdx="+productIdx);
		}catch(BadParameterException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	
	}

}
