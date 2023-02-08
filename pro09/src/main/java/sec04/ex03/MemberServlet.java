package sec04.ex03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list")
public class MemberServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVo> memberList = new ArrayList<MemberVo>();
		memberList.add(new MemberVo("홍길동", "hong@example"));
		memberList.add(new MemberVo("신용권", "sin@example"));
		memberList.add(new MemberVo("남궁성", "namg@example"));
		memberList.add(new MemberVo("박재성", "park@example"));

		request.setAttribute("members", memberList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/view");
		rd.forward(request, response);
	}
}

class MemberVo{
	private String name;
	private String email;

	public MemberVo(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

