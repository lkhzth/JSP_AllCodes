package Sample02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetServletValue extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();

		Cookie c1 = new Cookie("jsp", URLEncoder.encode("jsp프로그래밍", "utf-8"));
		Cookie c2 = new Cookie("oracle", URLEncoder.encode("오라클 프로그래밍", "utf-8"));
		
		c1.setMaxAge(60*60*24);
		c1.setMaxAge(-1);
		
		response.addCookie(c1);
		response.addCookie(c2);
		
		out.print("현재시간 : " + date + "<br>");
		out.print("문자열을 쿠키에 저장");
		
		
	}
}
