package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import exception.ProjectException;
import logic.Board;
import logic.ProjectService;

@Controller
public class BoardController {
	@Autowired
	private ProjectService service;
	
	@RequestMapping("board/list")
	public ModelAndView list (Integer pageNum, String searchType, String searchContent) {
		
		if(pageNum == null || pageNum.toString().equals("")) {
			pageNum = 1;
		}
		
		ModelAndView mav = new ModelAndView();
		
		int limit = 10;		// 한 페이지에 나올 게시글의 숫자
		int listcount = service.boardcount(searchType, searchContent);	// 표시될 총 게시글의 수
		List<Board> boardlist = service.boardList(searchType, searchContent, pageNum, limit);
		
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = ((int)((pageNum/10.0 + 0.9) - 1)) * 10 + 1; // 시작페이지
		int endpage = startpage + 9;	// 마지막 페이지
		if(endpage > maxpage) endpage = maxpage;
		int boardcnt = listcount - (pageNum - 1) * limit;
		mav.addObject("pageNum", pageNum);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount",listcount);
		mav.addObject("boardlist",boardlist);
		mav.addObject("boardcnt",boardcnt);
				
		return mav;
	}
	
	// 게시글 등록하기
	/*
	 * 1. 유효성 검증
	 * 2. DB에 등록하기
	 * 3. 등록 성공 시 list.test으로 페이지 이동
	 * 4. 등록 실패 시 write.test으로 페이지 이동
	 * 
	 */
	
	@RequestMapping(value="board/write", method=RequestMethod.POST) // 게시글 작성 시 호출되는 메서드
	public ModelAndView write(@Valid Board board, BindingResult bindingResult, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		try {
			service.boardWrite(board, request);
			mav.setViewName("redirect:/board/list.test");
		} catch (Exception e) {
			throw new ProjectException("오류가 발생하였습니다." , "/board/list.test");
		}
		return mav;
	}
	
	@RequestMapping(value="board/reply", method=RequestMethod.POST)
	public ModelAndView reply(@Valid Board board, BindingResult bindingResult) {
		
		ModelAndView mav = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mav.getModel().putAll(bindingResult.getModel());
			board = service.getBoard(board.getbNo());
			mav.addObject("board", board);
			return mav;
		}
		
		try {
			service.boardReply(board);
			mav.setViewName("redirect:/board/list.shop");
		} catch (Exception e) {
			throw new ProjectException("오류가 발생하였습니다." , "/board/list.shop");
		}
		
		return mav;
	}
	
	
	@RequestMapping(value="board/*", method=RequestMethod.GET)
	public ModelAndView detail(Integer num, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		Board board = new Board();
				
		if(num != null) {
			board = service.getBoard(num);
			String url = request.getServletPath();
			
			if(url.contains("/board/detail.sms")) {
				service.updateReadCnt(num);
			}
		}
		
		mav.addObject("board", board);
		return mav;
	}

}
