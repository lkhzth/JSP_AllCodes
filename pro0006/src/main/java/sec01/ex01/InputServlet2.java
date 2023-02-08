package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inputServlet2")
public class InputServlet2 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String user_id = request.getParameter("user_id");
//		String user_pw = request.getParameter("user_pw");
//		System.out.println("아이디 : " + user_id);
//		System.out.println("비밀번호 : " + user_pw);
//		String[] subject = request.getParameterValues("subject");
//		for(String str : subject) {
//			System.out.println("선택한 과목 : " + str);
//		}
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			for(String value : values) {
				System.out.println("name=" + name + " , " +"value=" + value);
			}
		}
	}

	public void destroy() {
		System.out.println("destory메소드 호출");
	}
}
