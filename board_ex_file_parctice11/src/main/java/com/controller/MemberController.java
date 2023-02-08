package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDAO;
import com.domain.MemberVO;
import com.service.MemberService;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {

	private MemberService service;
	
	@Override
	public void init() throws ServletException {
		service = new MemberService(new MemberDAO());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		final String PREFIX = "/WEB-INF/views/member/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 회원가입
		if(pathInfo.equals("/joinForm")) {
			nextPage = "joinForm";
		}
		
		// 회원가입 처리
		else if(pathInfo.equals("/join")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO vo = MemberVO.builder()
					.id(id)
					.pwd(pwd)
					.name(name)
					.email(email).build();
			service.memberJoin(vo);
			response.sendRedirect(contextPath + "/board");
			return;
		}
		
		// 로그인폼
		else if(pathInfo.equals("/loginForm")) {
			nextPage = "loginForm";
		}
		
		// 로그인처리
		else if(pathInfo.equals("/login")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			MemberVO vo = MemberVO.builder()
					.id(id).pwd(pwd).build();
			
			if(service.loginService(vo)) {
				HttpSession session = request.getSession();
				session.setAttribute("auth", vo.getId());
				response.sendRedirect(contextPath + "/board");
				return;
			}
		}
	}

}
