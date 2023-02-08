package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// sec01.ex01.FirstServlet
public class FirstServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("이닛메소드호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두겟메서드호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("디스트로이메서드 호출");
	}
}
