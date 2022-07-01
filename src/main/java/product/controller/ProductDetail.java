package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dto.ProductInfo;
import product.service.ProductService;

@WebServlet("/product/detail")
public class ProductDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int productIdx = Integer.parseInt(request.getParameter("productIdx"));
			
			ProductService service = new ProductService();

			ProductInfo productInfo = service.study_getProductInfoByProductIdx(productIdx);
			
			request.setAttribute("productInfo", productInfo);

			RequestDispatcher rd = request.getRequestDispatcher("/shop/product_detail.jsp");
			rd.forward(request, response);
			
//			JSONObject productInfo = service.getProductInfoByProductIdx(productIdx);
			
//			response.setContentType("application/json;charset=UTF-8");
//			
//			PrintWriter output = response.getWriter();
//			
//			output.print(productInfo);
//			output.close();
	}
}
