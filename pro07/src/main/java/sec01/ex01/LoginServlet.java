package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("로그인 서블릿 : doGet");
		String userId = req.getParameter("user_id");
		String userPw = req.getParameter("user_pw");
		String userEmail = req.getParameter("user_email");
		System.out.println("아이디 : " + userId);
		System.out.println("패스워드 : " + userPw);
		System.out.println("이메일 : " + userEmail);
	
	
	}
}
