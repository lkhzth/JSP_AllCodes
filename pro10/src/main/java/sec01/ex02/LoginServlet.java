package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("아이디 : " + user_id);
		sb.append("<br>");
		sb.append("비밀번호 : " + user_pw);
		sb.append("<br>");
		sb.append("주소 : " + user_address);
		sb.append("<br>");
		sb.append("email : " + user_email);
		sb.append("<br>");
		sb.append("휴대전화 : " + user_hp);
		sb.append("<br>");
		
		user_address = URLEncoder.encode(user_address, "utf-8");
		sb.append("<a href='/pro10/second?user_id=" + user_id
					+ "&user_pw=" + user_pw
					+ "&user_address=" + user_address
					+ "'>두번째 서블릿으로 보내기</a>");
		sb.append("</body></html>");
		out.print(sb);
	}

}
