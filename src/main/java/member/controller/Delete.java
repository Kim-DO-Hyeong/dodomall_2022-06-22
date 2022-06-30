package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.MemberInfo;
import member.service.MemberService;
import util.URLs;

@WebServlet("/member/delete")
public class Delete extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginMemberInfo");
		
		int memberIdx = memberInfo.getMemberIdx();
		
		MemberService service = new MemberService();
		
		service.delete(memberIdx);
		session.removeAttribute("loginMemberInfo");
		
	}

}
