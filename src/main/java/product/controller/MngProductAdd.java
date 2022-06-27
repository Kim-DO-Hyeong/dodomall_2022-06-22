package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import exception.BadParameterException;
import product.dto.ProductInfo;
import product.service.MngProductService;
import util.ProductInfoValidator;

@WebServlet("/mng/product/add")
public class MngProductAdd extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 요청정보를 가지고 있는 HttpServletRequest 타입 객체
			// 2. 클라이언트가 보낸 파일을 저장할 위치 --> 이미 이 코드에서 파일이 저장(save) 됨  
			// 3. 파일의 최대 크기( Byte 단위 ) 5메가바이트
			// 4. 요청정보에 들어있는 데이터의 인코딩 지정 
			// 5. 파일명 변경 정책 
			
			
			// request 에는 정보가 안남아있음 -> req 객체를 사용해야함 
			MultipartRequest req = new MultipartRequest(request, "C:\\upload", 1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
			
//			request.setCharacterEncoding("UTF-8"); req메서드에서 UTF-8 인코딩 
			
			
			String name = req.getParameter("name");
			String category = req.getParameter("category");
			int stock = Integer.parseInt(req.getParameter("stock"));
			int price = Integer.parseInt(req.getParameter("price"));
			
			// 서버에 저장한 파일의 정보 
			File file  = req.getFile("img");
			
			// 서버에 저장된 실제 파일의 이름 ( 파일명 변경 정책 때문에 클라이언트가 보낸 파일의 이름과 실제 파일의 이름이 다를 수 있음 ) 		
			String savedFileName = req.getFilesystemName("img");
 
			// 클라이언트가 보낸 파일의 이름
			String originalFileName = req.getOriginalFileName("img");

			
			
			// 서버에 저장한 파일의 경로 및 이름 
//			img는 이미 저장 -> 바로 req에서 꺼내서 사용하면 됨
			String img = savedFileName;
			
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
			
			MngProductService service = new MngProductService();
			
			service.add(newProductInfo);
			
			response.setStatus(HttpServletResponse.SC_CREATED);

		}catch(BadParameterException e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
				
	}

}
