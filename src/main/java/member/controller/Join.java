package member.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.MemberInfo;
import member.service.MemberService;

@WebServlet("/member/join")
public class Join extends HttpServlet {

	// 클라이언트가 필요한 파리미터와 파라미터 값을 정상적으로 보냈다는 가정으로 회원 가입 기능을 개발 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트가 전달한 파라미터( 회원 정보 )를 꺼낸다. 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwChk = request.getParameter("pwChk");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		
		// 2. 하나의 정보로 합친다 
		MemberInfo newMemberInfo = new MemberInfo(id,pw,pwChk,name,tel,addr,email,LocalDateTime.now());
		
		// 3. 회원 가입 처리 
		MemberService service = new MemberService();
		boolean result =service.join(newMemberInfo);

		// 4. 회원 가입에 처리에 따른 결과 코드 응답 
		if(result) {
			response.setStatus(HttpServletResponse.SC_CREATED);
		}else {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	
	}

}
