package com.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dao.ReplyDao;
import com.service.ReplyService;

public class ServletLoadContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext(); // 모든영역에서 사용가능
		ReplyDao replyDao = new ReplyDao();
		ReplyService replyService = new ReplyService(replyDao);
		sc.setAttribute("replyService", replyService);
	
	}

	
}
