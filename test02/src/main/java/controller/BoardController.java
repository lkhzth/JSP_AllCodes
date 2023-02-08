package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import domain.BoardVO;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	private BoardDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new BoardDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		
		final String PREFIX = "/WEB-INF/views/test02/";
		final String SUFFIX=".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<BoardVO> boardList = dao.boardList();
			request.setAttribute("list", boardList);
			nextPage = "list";
		}
		
		else if(pathInfo.equals("/detail")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO findBoard = dao.findBoard(bno);
			request.setAttribute("detail", findBoard);
			nextPage = "detail";
		}
		
		else if(pathInfo.equals("/writeForm")) {
			nextPage = "write";
		}
		
		else if(pathInfo.equals("/addBoard")) {
			BoardVO vo = BoardVO.builder()
					.title(request.getParameter("title"))
					.content(request.getParameter("content"))
					.writer(request.getParameter("writer")).build();
			dao.addBoard(vo);
			response.sendRedirect(contextPath + "/board");
			return;
		}
		
		else if(pathInfo.equals("/modifyForm")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO findBoard = dao.findBoard(bno);
			request.setAttribute("board", findBoard);
			nextPage = "modify";
		}
		
		else if(pathInfo.equals("/modBoard")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO vo = BoardVO.builder()
					.title(request.getParameter("title"))
					.content(request.getParameter("content"))
					.bno(bno).build();
			dao.modBoard(vo);
			response.sendRedirect(contextPath + "/board");
			return;
		}
	
		else if(pathInfo.equals("/delBoard")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			dao.delBoard(bno);
			response.sendRedirect(contextPath + "/board");
			return;
		}
		
		else {
			nextPage = "_404";
		}
		
		rd = request.getRequestDispatcher(PREFIX + nextPage + SUFFIX);
		rd.forward(request, response);
	}
}
