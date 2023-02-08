package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// sec01.ex01.SecondServlet
public class SecondServlet extends HttpServlet{

	public SecondServlet() {
		System.out.println("세컨서블릿 생성");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("이닛메소드 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두겟메소드 호출");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("두포스트 호출");
	}
}
