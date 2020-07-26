package edu.bit.board.service;

import java.util.List;



import edu.bit.board.vo.BoardVO;

//�������� Ŀ�ǵ�� �߾��µ� ���� ���񽺷� �Ѵ�

public interface BoardService {
	
	//�� ��� ��ȸ
	List<BoardVO> getBoardList();
	
	//�� �� ��ȸ
	BoardVO getBoardVO(String bId);
	
	//�� ����
	void delBoard(String bId);
	
	//�� �ۼ�
	void writeBoard(String bName, String bTitle, String bContent);
	
	//�� ����
	void modifyBoard(String bId, String bName, String bTitle, String bContent);
	
	//��� view
	void reply_viewBoard(String bId);
	
	//��� �ۼ�
	void replyBoard(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent);
	
	
	
}
