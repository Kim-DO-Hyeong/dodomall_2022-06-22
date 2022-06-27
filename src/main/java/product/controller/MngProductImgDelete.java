package product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.service.MngProductService;

@WebServlet("/mng/product/img/delete")

public class MngProductImgDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int productIdx = Integer.parseInt(request.getParameter("productIdx"));
		
		// 1. productIdx 에 맞는 상품 정보를 조회한다  - dao
		
		// 2. 상품 정보에 들어있는 img 칼럼을 사용해서 이미지 파일을 삭제한다 - 서비스  
		
		// 위 동작을 컨트롤러, 서비스, dao 중 어디서 해야할까요 
		
		
		MngProductService service = new MngProductService();
		
		service.deleteImg(productIdx);
		
	}

}
