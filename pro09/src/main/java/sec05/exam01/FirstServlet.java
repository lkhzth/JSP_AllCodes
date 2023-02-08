package sec05.exam01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample/first")
public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext(); // 서블릿컨텍스트 객체열기
		
		request.setAttribute("name", "lee"); // 리퀘스트 데이터 객체에 바인딩
		ctx.setAttribute("subject", "java"); // 컨텍스트 데이터 객체에 바인딩
	
		RequestDispatcher rd = request.getRequestDispatcher("/sample/second");
		rd.forward(request, response);
	}
	
}
