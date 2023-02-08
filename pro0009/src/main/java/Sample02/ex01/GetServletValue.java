package Sample02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetServletValue extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies(); 
		
		if(cookies!=null) {
			for(Cookie c : cookies) {
				out.print("쿠키이름 : " + URLDecoder.decode(c.getName(), "utf-8")+" ");
				out.print("쿠키값 : " + URLDecoder.decode(c.getValue(), "utf-8")+"<br>");
			}
		} else {
			out.print("지정된 쿠키없음");
		}
		
		
	}
}
