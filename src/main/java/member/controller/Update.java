package member.controller;

import java.io.IOException;
import java.time.LocalDateTime;

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

@WebServlet("/member/update")
public class Update extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginMemberInfo");
			
			
			int memberIdx = memberInfo.getMemberIdx();
			
//			int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr= request.getParameter("addr");
			String email= request.getParameter("email");
			
			MemberInfoValidator validator = new MemberInfoValidator();
			
			if(validator.pwValidator(pw))						throw new BadParameterException();
			else if(validator.nameValidator(name)) 				throw new BadParameterException();
			else if(validator.telValidator(tel))				throw new BadParameterException();
			else if(validator.addrValidator(addr))				throw new BadParameterException();
			else if(validator.emailValidator(email))			throw new BadParameterException();
			
			
			MemberInfo updateMemberInfo = new MemberInfo();
			updateMemberInfo.setMemberIdx(memberIdx);
			updateMemberInfo.setPw(pw);
			updateMemberInfo.setName(name);
			updateMemberInfo.setTel(tel);
			updateMemberInfo.setAddr(addr);
			updateMemberInfo.setEmail(email);
			
			MemberService service = new MemberService();
			
			if(service.update(updateMemberInfo)) {
				
			}else {
				// 1. 409 
				response.setStatus(HttpServletResponse.SC_CONFLICT);
			}
		
		}catch(BadParameterException e) {
			// 2. 400 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
