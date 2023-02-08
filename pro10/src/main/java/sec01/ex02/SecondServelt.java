package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServelt extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		if(user_id != null && user_id.length() != 0) {
			sb.append("이미로그인된 상태입니다.<br><br>");
			sb.append("첫번째 서블릿에서 넘겨준 아이디 : " + user_id);
			sb.append("첫번째 서블릿에서 넘겨준 비밀번호 : " + user_pw);
			sb.append("첫번째 서블릿에서 넘겨준 주소 : " + user_address);
			sb.append("</body></html>");
		} else {
			sb.append("로그인 하지 않았습니다.<br><br>");
			sb.append("다시 로그인하세요<br>");
			sb.append("<a href='/pro10/login.html'>로그인창으로 이동하기</>");
		}
		out.print(sb);
	}
	

}
