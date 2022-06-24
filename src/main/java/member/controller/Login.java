package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BadParameterException;
import member.dto.MemberInfo;
import member.service.MemberService;
import util.MemberInfoValidator;

@WebServlet("/member/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id =request.getParameter("id");
			String pw =request.getParameter("pw");
			
			MemberInfoValidator validator = new MemberInfoValidator();
			
			if(validator.idValidator(id)) 		throw new BadParameterException();
			else if(validator.pwValidator(pw)) 	throw new BadParameterException();
			
			MemberInfo loginMemberInfo = new MemberInfo();
			
			loginMemberInfo.setId(id);
			loginMemberInfo.setPw(pw);
			
			MemberService service = new MemberService();
			
			loginMemberInfo = service.login(loginMemberInfo) ;
			
			if( loginMemberInfo != null )  {
				// memberInfo 테이블에 있는 그 회원의 모든 데이터 (memberIdx~ joinDate) 를 세션에 저장 
				
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(60*10);
				
				session.setAttribute("loginMemberInfo", loginMemberInfo);
				
				System.out.println("로그인 성공");
			}else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				
				System.out.println("아이디 또는 비밀번호 올바르짐 않음");
			}
		
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);		
			
			System.out.println("아이디 또는 비밀번호 파라미터가 비정상적이여서 로그인에 실패 ");
		}
	}

}
