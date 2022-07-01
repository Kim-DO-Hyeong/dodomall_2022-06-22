package product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadParameterException;
import product.dto.ProductInfo;
import product.service.ProductService;
import util.ProductInfoValidator;

@WebServlet("/product/list")
public class ProductList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProductInfoValidator validator = new ProductInfoValidator();
			
			int pageNumber= 1;
			
			if(request.getParameter("pageNumber") != null) {
				if(validator.pageNumberValidator(request.getParameter("pageNumber"))) throw new BadParameterException();
				
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			}
			
			// 페이지에 번호에 맞는 상품 목록을 불러온다 
			ProductService service = new ProductService();
			
			int amount = service.getAmount();
			
			if(amount == 0) {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			}else {
				List<ProductInfo> productInfoList = service.getProductInfoList(pageNumber);
				
				request.setAttribute("productInfoList", productInfoList);
				request.setAttribute("amount", amount);
				RequestDispatcher rd = request.getRequestDispatcher("/shop/product_list.jsp");
				rd.forward(request, response);
			}
		
			
			
			
		}catch(BadParameterException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		
		
	}
}