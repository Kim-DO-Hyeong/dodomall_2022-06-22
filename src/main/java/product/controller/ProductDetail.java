package product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import product.service.ProductService;

@WebServlet("/product/detail")
public class ProductDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productIdx = Integer.parseInt(request.getParameter("productIdx"));
		
		ProductService service = new ProductService();
		
		JSONObject productInfo = service.getProductInfoByProductIdx(productIdx);
		
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter output = response.getWriter();
		
		output.print(productInfo);
		output.close();
	}
}
