package product.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadParameterException;
import product.dto.ProductInfo;
import product.service.MngProductService;
import util.ProductInfoValidator;

@WebServlet("/mng/product/add")
public class ProductAdd extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			int stock = Integer.parseInt(request.getParameter("stock"));
			int price = Integer.parseInt(request.getParameter("price"));
			String img = request.getParameter("img");
			
			ProductInfoValidator validator = new ProductInfoValidator(); 
			
			if(validator.nameValidator(name)) 					throw new BadParameterException();
			else if(validator.categoryValidator(category)) 		throw new BadParameterException();
			else if(validator.stockValidator(stock)) 			throw new BadParameterException();
			else if(validator.priceValidator(price)) 			throw new BadParameterException();
			else if(validator.imgValidator(img)) 				throw new BadParameterException();
			
			ProductInfo newProductInfo = new ProductInfo();
			
			newProductInfo.setName(name);
			newProductInfo.setCategory(category);
			newProductInfo.setStock(stock);
			newProductInfo.setPrice(price);
			newProductInfo.setImg(img);
			newProductInfo.setInsertDate(LocalDateTime.now());
			
			MngProductService service = new MngProductService();
			
			service.add(newProductInfo);
			
			response.setStatus(HttpServletResponse.SC_CREATED);

		}catch(BadParameterException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
				
	}

}
