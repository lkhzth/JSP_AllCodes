package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.dao.BoardDao;
import com.domain.BoardVO;
import com.service.BoardService;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	private BoardService service;
	
	@Override
	public void init() throws ServletException {
		BoardDao dao = new BoardDao();
		service = new BoardService(dao);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		final String PREFIX = "/WEB-INF/views/board/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 글목록
		if(pathInfo == null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<BoardVO> boardList = service.boardList();
			request.setAttribute("list", boardList);
			nextPage = "list";
		}
		
		// 글상세
		else if(pathInfo.equals("/detail")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO board = service.findBoard(bno);
			request.setAttribute("board", board);
			nextPage = "detail";
		}
		
		// 글쓰기폼
		else if(pathInfo.equals("/writeForm")) {
			nextPage = "writeForm";
		}
		
		// 글쓰기 처리
		else if(pathInfo.equals("/write")) {
			Map<String, String> req = getMultipartRequest(request);
			String imageFileName = req.get("imageFileName");
			BoardVO vo = BoardVO.builder()
					.title(req.get("title"))
					.content(req.get("content"))
					.writer(req.get("writer"))
					.imageFileName(req.get("imageFileName")).build();
			int boardNo = service.addBoard(vo);
			
			// 이미지파일 첨부한 경우
			if(imageFileName!=null && imageFileName.length()>0) {
				File srcFile = new File("c:/file_repo/temp", imageFileName);
				File destFile = new File("c:/file_repo/" + boardNo);
				destFile.mkdirs();
				FileUtils.moveFileToDirectory(srcFile, destFile, false);
			}
			response.sendRedirect(contextPath + "/board");
			return;
		}
		
		// 글 수정
		else if(pathInfo.equals("/modBoard")) {
			Map<String, String> req = getMultipartRequest(request);
			String paramBno = req.get("bno");
			int bno = Integer.parseInt(paramBno);
			String title = req.get("title");
			String content = req.get("content");
			String imageFileName = req.get("imageFileName");
			
			BoardVO vo = BoardVO.builder()
					.bno(bno)
					.title(title)
					.content(content)
					.imageFileName(imageFileName).build();
			service.modBoard(vo);
			if(imageFileName!=null) {
				String originFileName = req.get("originFileName");
				File srcFile = new File("c:/file_repo/temp", imageFileName);
				File destFile = new File("c:/file_repo/"+bno);
				destFile.mkdirs();
				FileUtils.moveFileToDirectory(srcFile, destFile, false);
				if(originFileName!=null) {
					File oldFile = new File("c:/file_repo/" + bno + "/" + originFileName);
					oldFile.delete();
				}
			}
			response.sendRedirect(contextPath + "/board");
			return;
		}
		
		// 글삭제
		else if(pathInfo.equals("/removeBoard")) {
			Map<String, String> req = getMultipartRequest(request);
			String paramBno = req.get("bno");
			int bno = Integer.parseInt(paramBno);
			service.removeBoard(bno);
			File targetDir = new File("c:/file_repo/" + bno);
			if(targetDir.exists()) {
				FileUtils.deleteDirectory(targetDir);
			}
			response.sendRedirect(contextPath + "/board");
			return;
		}
		
		else {
			System.out.println("페이지없음");
			return;
		}

		rd = request.getRequestDispatcher(PREFIX + nextPage + SUFFIX);
		rd.forward(request, response);
	}
	
	private Map<String, String> getMultipartRequest(HttpServletRequest request){
		Map<String, String> boardMap = new HashMap<>();
		File currentDirPath = new File("c:/file_repo/temp");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload repository = new ServletFileUpload(factory);
		repository.setFileSizeMax(1024*1024*10);
		
		try {
			List<FileItem> items = repository.parseRequest(request);
			for(FileItem item : items) {
				if(item.isFormField()) {
					boardMap.put(item.getFieldName(), item.getString("utf-8"));
				} else{
					if(item.getSize()>0) {
						String fileName = item.getName();
						boardMap.put(item.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath, fileName);
						item.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardMap;
	}
}
