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
			MemberInfo loginMemberInfo = (MemberInfo) session.getAttribute("loginMemberInfo");
			
			int memberIdx = loginMemberInfo.getMemberIdx();
			
			// 사용자가 비밀번호를 바꾸지 않는다면 oldPw, newPw, newPwChk 는 전달되지 않거나 
			// 전달되더라도 빈 문자열로 전달 될 수 있음 
			// 전달되지 않는다면 getParameter() 메서드는 null 을 반환 
			// 빈 문자열로 전달 되면 getParameter() 메서드는 빈 문자열을 반환 
			String oldPw = request.getParameter("oldPw");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr= request.getParameter("addr");
			String email= request.getParameter("email");
			String newPw = request.getParameter("newPw");
			String newPwChk = request.getParameter("newPwChk");

			MemberInfoValidator validator = new MemberInfoValidator();
			if(oldPw !=null && oldPw.length() > 0) {
				// 사용자가 비밀번호를 변경하기 위해서 현재 비밀번호, 새 비밀번호, 새 비밀번호를 확인을 입력했을 경우 
				if(validator.pwValidator(oldPw))					throw new BadParameterException();
				else if(validator.pwValidator(newPw)) 				throw new BadParameterException();
				else if(!newPw.equals(newPwChk)) 					throw new BadParameterException();
			}
			else if(validator.nameValidator(name)) 			throw new BadParameterException();
			else if(validator.telValidator(tel))			throw new BadParameterException();
			else if(validator.addrValidator(addr))			throw new BadParameterException();
			else if(validator.emailValidator(email))		throw new BadParameterException();
			
			if(oldPw !=null && oldPw.length() > 0) {
				String nowPw = loginMemberInfo.getPw();
				if(!nowPw.equals(oldPw)) throw new BadParameterException();
			}

			
			MemberInfo updateMemberInfo = new MemberInfo();
			updateMemberInfo.setMemberIdx(memberIdx);
			if(oldPw !=null && oldPw.length() > 0) {
				updateMemberInfo.setPw(newPw);
			}else {
				updateMemberInfo.setPw(loginMemberInfo.getPw());
			}
			updateMemberInfo.setName(name);
			updateMemberInfo.setTel(tel);
			updateMemberInfo.setAddr(addr);
			updateMemberInfo.setEmail(email);
			
			
			
			MemberService service = new MemberService();
			
			if(service.update(loginMemberInfo,updateMemberInfo)) {
				// 로그인 할 때 세션에 memberIdx, id, pw, name, tel, addr, email,joinDate
				// 빠진 정보를 추가해서 넣어야함 
				updateMemberInfo.setId(loginMemberInfo.getId());
				updateMemberInfo.setJoinDate(loginMemberInfo.getJoinDate());
				session.setAttribute("loginMemberInfo", updateMemberInfo);
			}else {
				// 1. 409 
				response.setStatus(HttpServletResponse.SC_CONFLICT);
			}
		
		}catch(BadParameterException e) {
			// 2. 400 
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		}
	}

}
