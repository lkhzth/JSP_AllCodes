package com.common;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {

	private static final String REPO_PATH = "c:/file_repo";
	 
	private String servicePathName;

	public FileUpload(String servicePathName) {
		this.servicePathName = servicePathName;
	}
	
	public Map<String, String> getMultipartRequest(HttpServletRequest request){
		Map<String, String> paramMap = new HashMap();
		File currentDirPath = new File(REPO_PATH + servicePathName + "temp");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload repository = new ServletFileUpload(factory);
		repository.setFileSizeMax(1024*1024*10);
		
		try {
			List<FileItem> items = repository.parseRequest(request);
			for(FileItem item : items) {
				if(item.isFormField()) {
					paramMap.put(item.getFieldName(), item.getString("utf-8"));
				} else {
					if(item.getSize()>0) {
						
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
			
}

