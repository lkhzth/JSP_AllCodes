package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		String ctxPath = request.getContextPath();
		String uri = request.getRequestURI();
		String mapping = request.getServletPath();
		uri = uri.substring(ctxPath.length(), uri.length());
		String cmd = uri.substring(mapping.length(), uri.length());
	
		if(cmd.equals("/memberList")) {
			List<MemberVO> memberList = dao.memberList();
			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("/mem/memberList.jsp").forward(request, response);
		} else if(cmd.equals("/addMember")) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPwd(request.getParameter("pwd"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			dao.addMember(vo);
			response.sendRedirect("/member_pro07/member/memberList");
		}
		
		
	}

}
