package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null) {
			for(Cookie c : cookies) {
				out.print("쿠키이름 : " + URLDecoder.decode(c.getName(), "utf-8") + "<br>");
				out.print("쿠키값 : " + URLDecoder.decode(c.getValue(), "utf-8"));
			} 
		} else {
			out.print("지정된 쿠키없음");
		}
	}

}
