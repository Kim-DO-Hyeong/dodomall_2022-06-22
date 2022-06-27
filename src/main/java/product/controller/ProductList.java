package product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/list")
public class ProductList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		// 페이지에 번호에 맞는 상품 목록을 불러온다 
		
		// 불러온 상품 목록을 클라이언트에게 전달한다 
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(false);
		out.close();
		
	}


}
