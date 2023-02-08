package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userId = request.getParameter("userId");
		
		MemberDao dao = new MemberDao();
		boolean result = dao.overlapedId(userId);
		JSONObject idCheck = new JSONObject();
		
		if(result) { // 중복된 아이디
			idCheck.put("isAvailable", false);
			out.print(idCheck);
		} else { // 사용가능한 아이디
			idCheck.put("isAvailable", true);
			out.print(idCheck);
		}
		
	}
}
