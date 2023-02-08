package test01;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class JoinsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pathInfo = request.getPathInfo();
		
		final String PREFIX = "/WEB-INF/views/test01/";
		final String SUFFIX=".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		if(pathInfo.equals("/joinForm")) {
			nextPage = "member_join";
		}
		
		else if(pathInfo.equals("/join")) {
			Map<String, String> member = new HashMap();
			member.put("name", request.getParameter("name"));
			member.put("gen", request.getParameter("gen"));
			member.put("id", request.getParameter("id"));
			member.put("addr", request.getParameter("addr"));
			member.put("phone", request.getParameter("phone"));
			member.put("email", request.getParameter("email"));
			
			String[] hobbys = request.getParameterValues("hobby");
			
			request.setAttribute("member", member);
			request.setAttribute("hobby", hobbys);
			nextPage = "join_result";
		}

		else {
			System.out.println("존재하지 않는 페이지입니다");
			return;
		}
		
		rd = request.getRequestDispatcher(PREFIX + nextPage + SUFFIX);
		rd.forward(request, response);
	}

}
