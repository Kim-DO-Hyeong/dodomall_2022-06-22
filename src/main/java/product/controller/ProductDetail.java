package product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import product.dto.ProductInfo;
import product.service.ProductService;

@WebServlet("/product/detail")
public class ProductDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int productIdx = Integer.parseInt(request.getParameter("productIdx"));
			
			ProductService service = new ProductService();

			ProductInfo productInfo = service.getProductInfoByProductIdx(productIdx);
			
			request.setAttribute("productInfo", productInfo);

			RequestDispatcher rd = request.getRequestDispatcher("/shop/product_detail.jsp");
			rd.forward(request, response);
	}
}
