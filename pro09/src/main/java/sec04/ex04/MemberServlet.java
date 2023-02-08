package sec04.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/ex04")
public class MemberServlet extends HttpServlet{
	/*
	 	MemberDao -> MemberService -> MemberServlet(jsp)
	 */
	
	private MemberDao dao;
	
	public MemberServlet() {
		dao = new MemberDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		String command = req.getParameter("command");
		
		if(command!=null && command.equals("addMember")) { // 회원가입
			MemberVO vo = new MemberVO(
					req.getParameter("id"),
					req.getParameter("pwd"),
					req.getParameter("name"),
					req.getParameter("email"));
			dao.addMember(vo);
			resp.sendRedirect("/pro09/index.html");
		} else if(command!=null && command.equals("delMember")) {
			System.out.println("회원삭제");
			String inputMno = req.getParameter("mno");
			int mno = Integer.parseInt(inputMno);
			dao.delMember(mno);
			resp.sendRedirect("/pro09/index.html");
		}
		
		else { // 회원목록
			RequestDispatcher rd = req.getRequestDispatcher("/memberList.jsp");
			List<MemberVO> memberList = dao.memberList();
			req.setAttribute("list", memberList);
			rd.forward(req, resp);
		}
		
		
		
	}
}
