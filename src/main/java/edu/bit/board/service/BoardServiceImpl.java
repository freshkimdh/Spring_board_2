package edu.bit.board.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import edu.bit.board.dao.BoardDAO;

import edu.bit.board.vo.BoardVO;


//������Ʈ �ؼ� controll, service, repository �Ƶ鳻�� 3��
//@ �̰Ŵ� ��ü�� ����ڴٴ� ���̸�, component�� ��ĵ ����� �ȴ�.
//new �Ѱ� �ϳ��� ������, ������̼����� �� �ö󰡵��� �������.
//�̹� DAO ���� "@Repository"���� IOC �����̳ʿ� �������, @Service �ϸ� �����Ǿ��� ���� �ҷ��´�.
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	//�ش� ������ Ÿ���� üũ�Ͽ�, �� Ÿ���� ��ü�� �޸𸮿� �����ϴ��� Ȯ�� �� ��ü�� ������ �����Ѵ�.
	//���, boardDAO�� ��ü�� �ִ��� Ȯ�� �� ������ �ڵ����� �Ҵ��Ѵ�.
	@Autowired
	private BoardDAO boardDAO;
	
	// "getBoardList()"�� Ÿ���� Ȯ�� �� ������ �ڵ��� ��ü�� �����ؼ� �Ҵ� �Ѵ�.
	@Override
	public List<BoardVO> getBoardList() { 
				
		return boardDAO.getBoardListAAccdd();
		//dtos�� DB�� �ִ� ����Ʈ�� ��Ƽ� �װ��� ����
		//���? �������̽��� "getBoardList()" �� �Լ��� �ҷ����� ��Ҵ� ��� �����´�.
		//���⼭ ������ ���� DAO�� �ִ� �Լ����� �����Ѵٴ� ���̴�. ��, dtos �������ڴٴ� ��!!
		
//		public void execute(Model model) {
//			
//			BDao dao = new BDao();
//			ArrayList<BDto> dtos = dao.list();
//			model.addAttribute("list", dtos);
//		}

	}
	
	
	@Override
	public BoardVO getBoardVO(String bId) {
	      
	   return boardDAO.contentView(bId);
	}

	@Override
	public void delBoard(String bId) {
		boardDAO.delete(bId);
	}
	
	@Override
	public void writeBoard(String bName, String bTitle, String bContent) {
		boardDAO.write(bName, bTitle, bContent);
	}
	
	@Override
	public void modifyBoard(String bId, String bName, String bTitle, String bContent) {
		boardDAO.modify(bId, bName, bTitle, bContent);
	}
	
	@Override
	public void reply_viewBoard(String bId) {
		boardDAO.reply_view(bId);
	}
	
	@Override
	public void replyBoard(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		boardDAO.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
	}
	
	
}
