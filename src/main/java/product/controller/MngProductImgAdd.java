package product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import product.service.MngProductService;

@WebServlet("/mng/product/img/add")
public class MngProductImgAdd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest req = new MultipartRequest(request,"C:\\upload",1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
		
		int productIdx = Integer.parseInt(req.getParameter("productIdx"));
		String img = req.getFilesystemName("img");
		
		MngProductService service = new MngProductService();
		
		service.addImg(productIdx, img);
		
	}
}
