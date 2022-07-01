package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.service.MngProductService;

@WebServlet("/mng/product/delete")
public class ProductDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productIdx = Integer.parseInt(request.getParameter("productIdx"));
		
		MngProductService service = new MngProductService();
		
		String realPath = request.getServletContext().getRealPath("/images/product/");

		
		service.deleteProduct(productIdx,realPath);
		
	}

}
