package edu.bit.board;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		logger.info("list");
		
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("list", list );
		
		return "list";
	}
	
	
	//"BoardVO boardVO" command 객체!! (역활 알아보기!)
	//커맨드 객체를 받아서 오는 것이 좋다!!
	@RequestMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model){
		logger.info("content_view");
		
		String bId = String.valueOf(boardVO.getbId());
		
		logger.info(bId);
		
		boardVO = boardService.getBoardVO(bId);
		model.addAttribute("content_view", boardVO );
		
		return "content_view";
	}
	
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO, Model model){
		logger.info("delete()");
		
		String bId = String.valueOf(boardVO.getbId());
		
		logger.info(bId);
		
		boardService.delBoard(bId);
		
		//list를 한번 더 태우는 것
		return "redirect:list";
	}
	
	
	@RequestMapping("/write_view")
	public String writeview(Model model) {
		logger.info("write_view()");
		
		return "write_view";
	}
	
	
	@RequestMapping("/modify")
	public String modify(BoardVO boardVO){
		logger.info("modify()");
		
		String bId = String.valueOf(boardVO.getbId());
		String bName = String.valueOf(boardVO.getbName());
		String bTitle = String.valueOf(boardVO.getbTitle());
		String bContent = String.valueOf(boardVO.getbContent());
		
		boardService.modifyBoard(bId, bName, bTitle, bContent);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/write")
	public String wirte(BoardVO boardVO){
		logger.info("write()");
		
//		String bName = String.valueOf(boardVO.getbName());
//		String bTitle = String.valueOf(boardVO.getbTitle());
//		String bContent = String.valueOf(boardVO.getbContent());
//		
//		logger.info(bName, bTitle, bContent);
		
		boardService.writeBoard(boardVO.getbName(), 
								boardVO.getbTitle(), 
								boardVO.getbContent());
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model){
		logger.info("reply_view()");
		
		String bId = String.valueOf(boardVO.getbId());
		
		logger.info(bId);
		
		boardVO = boardService.getBoardVO(bId);
		model.addAttribute("reply_view", boardVO );
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO) {
		logger.info("reply()");
		
		String bId = String.valueOf(boardVO.getbId());
		String bName = String.valueOf(boardVO.getbName());
		String bTitle = String.valueOf(boardVO.getbTitle());
		String bContent = String.valueOf(boardVO.getbContent());
		String bGroup = String.valueOf(boardVO.getbGroup());
		String bStep = String.valueOf(boardVO.getbStep());
		String bIndent = String.valueOf(boardVO.getbIndent());
		
		boardService.replyBoard(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
		
		return "redirect:list";
	}
	
	
	
	
	
}
