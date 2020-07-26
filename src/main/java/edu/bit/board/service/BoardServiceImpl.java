package edu.bit.board.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import edu.bit.board.dao.BoardDAO;

import edu.bit.board.vo.BoardVO;


//컴포넌트 해서 controll, service, repository 아들내미 3명
//@ 이거는 객체를 만들겠다는 것이며, component의 스캔 대상이 된다.
//new 한거 하나도 없지만, 어노테이션으로 다 올라가도록 만들었다.
//이미 DAO 에서 "@Repository"에서 IOC 컨테이너에 만들었고, @Service 하면 생성되었던 것을 불러온다.
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	//해당 변수의 타입을 체크하여, 그 타입의 객체가 메모리에 존재하는지 확인 후 객체를 변수에 주입한다.
	//결론, boardDAO의 객체가 있는지 확인 후 없으면 자동으로 할당한다.
	@Autowired
	private BoardDAO boardDAO;
	
	// "getBoardList()"의 타입을 확인 후 없으면 자동을 객체를 생성해서 할당 한다.
	@Override
	public List<BoardVO> getBoardList() { 
				
		return boardDAO.getBoardListAAccdd();
		//dtos에 DB에 있는 리스트를 담아서 그것을 리턴
		//어디에? 인터페이스의 "getBoardList()" 이 함수를 불러오면 담았던 놈들 가져온다.
		//여기서 리턴의 값은 DAO에 있는 함수명을 리턴한다는 것이다. 즉, dtos 가져오겠다는 것!!
		
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
