package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import domain.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
       
//	데이터베이스 테이블 생성
//	MemberVO 클래스 : 데이터베이스 테이블 컬럼과 1대1 대응이 되도록(세터게터 생성자 toString)
//	MemberDao클래스: 
//		-connection 객체 얻기 : DataSource 타입정의
//			-생성자에서 connectionpool을 얻어옴
//			-DataSource로부터 connection객체를 얻어낸다
//		- PrepareStatment 객체에 쿼리문전달
//		- 데이터베이스 테이블에서 조회한 결과를 ResultSet객체로 얻어냄
//			- 결과를 순회하여 MemberVO객체에 데이터 바인딩
//			- 리스트 추가
//		- 리소스 반납
//		MemberServlet :
//			-MemberDao 객체 생성후 필요한 메소드호출
//			-출력
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		
		MemberDao dao = new MemberDao();
		
		if(command!=null && command.equals("memberjoin")) { // 회원가입
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			dao.addMember(new MemberVO(id, password, name, email));
			response.sendRedirect("/member_pro"); // 지정된 페이지로 이동
			// 아래 코드는 실행되지 않음
		} else {
			List<MemberVO> listMembers = dao.list();
			out.print("");
			out.print("<table border=1><tr>");
			out.print("<th>아이디</th>");
			out.print("<th>비밀번호</th>");
			out.print("<th>이름</th>");
			out.print("<th>이메일</th>");
			out.print("<th>가입일</th></tr>");
			
			// 반복구간
			for(MemberVO vo : listMembers) {
//			String id = vo.getuId();
//			String pw = vo.getPwd();
//			String name = vo.getuName();
//			String email = vo.getEmail();
//			Date regDate = vo.getDate();
				
				out.print("<tr><td>"+vo.getId()+"</td>");
				out.print("<td>"+vo.getName()+"</td><td>"+vo.getPassword()+"</td>");
				out.print("<td>"+vo.getEmail()+"</td></tr>");
			}
			out.print("</table>");
		}
		
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

}
