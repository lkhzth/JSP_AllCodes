package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import model.MemberVO;

@WebServlet("/member/*")
public class MemberServlet extends HttpServlet {
	
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
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String mapping = request.getServletPath();
		uri = uri.substring(ctxPath.length(), uri.length());
		String cmd = uri.substring(mapping.length(), uri.length());

		if(cmd.equals("/memberList")) {
			List<MemberVO> memberList = dao.memberList();
			request.setAttribute("memberList", memberList);
			RequestDispatcher rd = request.getRequestDispatcher("/mem/memberList.jsp");
			rd.forward(request, response);
		} else if(cmd.equals("/addMember")) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPwd(request.getParameter("pwd"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			dao.addMember(vo);
			response.sendRedirect("/member_pro05/member/memberList");
		} else if(cmd.equals("/delMember")){
			String inputMno = request.getParameter("mno");
			try {
				int mno = Integer.parseInt(inputMno);
				dao.delMember(mno);
				response.sendRedirect("/member_pro05/member/memberList");
			} catch (Exception e) {
				request.getRequestDispatcher("/exception/error.jsp");
			}
		} else if(cmd.equals("/logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("/member_pro05/member/memberList");
		} else {
		}
	}

}
