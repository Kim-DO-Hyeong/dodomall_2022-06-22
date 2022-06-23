package member.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadParameterException;
import member.dto.MemberInfo;
import member.service.MemberService;
import util.Validator;

@WebServlet("/member/join")
public class Join extends HttpServlet {

		// 클라이언트가 필요한 파리미터와 파라미터 값을 정상적으로 보냈다는 가정으로 회원 가입 기능을 개발 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			
			request.setCharacterEncoding("UTF-8");
			
			// 1. 클라이언트가 전달한 파라미터( 회원 정보 )를 꺼낸다. 
			// 2. 이미 사용중인 아이디 또는 연락처 또는 이메일로 전달한 경우 409 응답코드 발생 
			// 3. 클라이언트가 서버에서 필요한 값을 전달해주지 않았을 때 
			// 4. 클라이언트가 필요한 값을 너무 적게 또는 너무 많이 전달했을 때 
			// 5. 클라이언트가 필요한 값을 비정상적인 값으로 보냈을 때 
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwChk = request.getParameter("pwChk");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			
			Validator validator = new Validator();
			
			if(validator.idValidator(id)) 							throw new BadParameterException();
			else if(validator.pwValidator(pw) || !pw.equals(pwChk)) throw new BadParameterException();
			else if(validator.nameValidator(name)) 					throw new BadParameterException();
			else if(validator.telValidator(tel))					throw new BadParameterException();
			else if(validator.addrValidator(addr))					throw new BadParameterException();
			else if(validator.emailValidator(email))				throw new BadParameterException();
			
			
	//		if(id==null || pw ==null || pwChk ==null || name ==null || tel ==null || addr ==null || email ==null ) {
	//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	//			return ;
	//		}else if(id.trim().length()==0 || pw.trim().length()==0 || pwChk.trim().length()==0 || name.trim().length()==0 || tel.trim().length()==0 || addr.trim().length()==0  || email.trim().length()==0 ){
	//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	//			return ;
	//		}else if((id.length() < 4 ||id.length() > 10) || (pw.length() < 6 || pw.length() > 16) || (pwChk.length() < 6 || pwChk.length() > 16) || name.length() != 3 || tel.length() != 13 || addr.length() > 20 || email.length() > 50) {
	//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	//			return ;
	//		}
			
			// 2. 하나의 정보로 합친다 
			MemberInfo newMemberInfo = new MemberInfo(id,pw,pwChk,name,tel,addr,email,LocalDateTime.now());
			
			// 3. 회원 가입 처리 
			MemberService service = new MemberService();
			boolean result =service.join(newMemberInfo);
	
			// 4. 회원 가입에 처리에 따른 결과 코드 응답 
			if(result) {
				response.setStatus(HttpServletResponse.SC_CREATED);
			}else {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
			}
			
		}catch(BadParameterException e) {
			e.printStackTrace();
		}
	}
		
	

}
