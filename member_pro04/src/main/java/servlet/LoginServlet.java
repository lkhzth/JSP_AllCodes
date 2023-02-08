package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import model.MemberVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private MemberDao dao;

	@Override
	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		MemberDao dao = (MemberDao) ctx.getAttribute("memberDao");
		this.dao = dao;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("user_id"));
		vo.setPwd(request.getParameter("user_pw"));
		boolean result = dao.isExisted(vo);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("loginId", vo.getId());
			response.sendRedirect("/member_pro04/member/memberList");
		} else {
			request.setAttribute("msg", "아이디 비밀번호 일치X");
			request.getRequestDispatcher("/mem/login.jsp").forward(request, response);;
		}
	}

}
