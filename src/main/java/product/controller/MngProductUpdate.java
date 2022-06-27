package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadParameterException;
import product.dto.ProductInfo;
import product.service.MngProductService;
import util.ProductInfoValidator;

@WebServlet("/mng/product/update")
public class MngProductUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			int productIdx =Integer.parseInt(request.getParameter("productIdx"));
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			int stock = Integer.parseInt(request.getParameter("stock"));
			int price = Integer.parseInt(request.getParameter("price"));
			
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
			
			MngProductService service = new MngProductService();
			
			service.update(updateProductInfo);
			
		}catch(BadParameterException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	
	}

}
