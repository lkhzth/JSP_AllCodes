package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileRepo = "c:/file_repo"; // 파일이 저장된 디렉토리
		String bno = request.getParameter("bno");
		String fileName = request.getParameter("imageFileName");
		
		File downloadFile = new File(fileRepo+"/"+bno, fileName); // 다움로드 대상 파일
		fileName = URLEncoder.encode(fileName, "utf-8");
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + URLEncoder.encode(fileName, "utf-8"));
		
		
		try (
			OutputStream out = response.getOutputStream(); // 출력스트림
			InputStream in = new FileInputStream(downloadFile); // 입력스트림
		){
			byte[] buffer = new byte[1024*8];
			int count=0;
			while ((count = in.read(buffer))!=-1) { // 읽어올 값이 있다면
				out.write(buffer,0,count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
