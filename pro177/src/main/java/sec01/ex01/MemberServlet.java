package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberServlet extends HttpServlet {

	private MemberDao dao;
	
	@Override
	public void init() throws ServletException {
		dao = new MemberDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		final String PREFIX = "/WEB-INF/views/member/";
		final String SUFFIX = ".jsp";
		RequestDispatcher rd = null;
		String nextPage = null;
		
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<MemberVO> listMembers = dao.listMembers();
			request.setAttribute("memberList", listMembers);
			nextPage = "memberList";
		}
		

	
	}

}
