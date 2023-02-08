package domain;

import lombok.Getter;

@Getter
public class Pagination {
	
	Criteria criteria;
	
	int startPage; // 시작페이지버튼 번호
	int endPage; // 마지막페이지 번호
	int tempEndPage; // 실제 마지막페이지 번호
	int totalCount; // 총 게시물수
	int displayPageNum = 10; // 화면에 보여질 페이지 버튼 수
	boolean prev; // 이전페이지 활성화 여부
	boolean next; // 다음페이지 활성화 여부
	
	public Pagination(Criteria criteria, int totalCount) {
		this.criteria = criteria;
		this.totalCount = totalCount;
		int pageNum = criteria.getPageNum();
		
		// 마지막페이지 : 올림(pageNum/displayNum) * displayNum
		endPage = (int) Math.ceil(pageNum/(double)displayPageNum) * displayPageNum;
		startPage = endPage - displayPageNum + 1;
		tempEndPage = (int) Math.ceil(totalCount/(double)criteria.getAmount());
		System.out.println("끝페이지 : " + endPage);
		System.out.println("마지막페이지 : " + tempEndPage);
		prev = startPage != 1;
		next = endPage < tempEndPage;
		
		if(endPage > tempEndPage) endPage = tempEndPage;
		
	}
/*
 	displayPageNum = 10
	1~10 : [1][2] .. [9][10]
		endPage = 10
		startPage = 10 - 10 + 1
	
	11~20 : [11][12] .. [19][20]
		endPage = 10
		startPage = 20 - 10 + 1
	
	21~30 : [21][22] .. [29][30]
		endPage = 10
		startPage = 30(endPage) - 10(displayPageNum) + 1
	
*/	
	
}

/*
	displayPageNum = 10
	totalCount = 412
	
	
	1~10 페이지 : 
	[1][2][3][4][5]......[9][10][다음페이지]
	startPage = [1]
	endPage = [10]
	prev = false
	next = true

	11~20페이지 : 
	[이전페이지][11][12][13][14][15]......[19][20][다음페이지]
		startPage = [11]
		endPage = [20]
		prev = true
		next = true

	
	41~50페이지 : 
	[이전페이지][41][42][43][44][45]......[49][50][다음페이지]
		startPage = [41]
		endPage = [50]
		prev = true
		next = false
	
	게시물수 : 412 페이징처리수 : 10 몫 : 41 나머지 2
	실제로 보여질 페이지
		[이전페이지][41][42]
			startPage = [41]
			endPage = 올림(총게시물수/페이징처리수)
			prev = true
			next = false
	
*/