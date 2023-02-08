<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>


<div class="container">
	<div class="jumbotron my-3">
		<h1>게시글조회</h1>
  	</div>
  <div class="card mb-3">
    <div class="card-header">
		${detail.title} 
	</div>
    <div class="card-body">
		${detail.content}
	</div> 
    <div class="card-footer d-flex justify-content-between">	
  		<div>
	    	<span class="badge badge-primary">${detail.writer}</span>
	  		<span class="badge badge-secondary">${detail.writeDate}</span>
  		</div>
  		<div>
  			<a href="${contextPath}/board/delBoard?bno=${detail.bno}" class="btn btn-danger">삭제</a>
  			<a href="${contextPath}/board/modifyForm?bno=${detail.bno}" class="btn btn-warning">수정</a>
  		</div>
    </div>
    
  </div>
</div>

<%@ include file="../layout/footer.jsp" %>
