package edu.bit.board.service;

import java.util.List;



import edu.bit.board.vo.BoardVO;

//기존에는 커맨드로 했었는데 이제 서비스로 한다

public interface BoardService {
	
	//글 목록 조회
	List<BoardVO> getBoardList();
	
	//글 상세 조회
	BoardVO getBoardVO(String bId);
	
	//글 삭제
	void delBoard(String bId);
	
	//글 작성
	void writeBoard(String bName, String bTitle, String bContent);
	
	//글 수정
	void modifyBoard(String bId, String bName, String bTitle, String bContent);
	
	//댓글 view
	void reply_viewBoard(String bId);
	
	//댓글 작성
	void replyBoard(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent);
	
	
	
}
