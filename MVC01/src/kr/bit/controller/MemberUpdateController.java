package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		

		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAge(age);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(vo);
//		PrintWriter out = response.getWriter();
		if (cnt > 0) {
			// 가입 성공 -> 회원 리스트 페이지로 Redirect 해준다
			response.sendRedirect("/MVC01/memberList.do");
//			out.println("Update success");
		} else {
			// 가입 실패 -> 예외처리
			throw new ServletException("not updated");
		}
	}

}
