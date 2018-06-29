package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Board;
import logic.ProjectService;

@Controller
public class NoticeController {
	@Autowired
	private ProjectService service;
	
	@ModelAttribute
	public Board getBoard() {
		return new Board();
	}
	
	@RequestMapping(value="notice/*",method=RequestMethod.GET)
	public ModelAndView detail(Integer num,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Board board = new Board();
		if(num != null) {
			board = service.getBoard(num);
			String url = request.getServletPath();
			if(url.contains("/notice/detail.sms")) {
				service.updateReadCnt(num);
			}
		}
		mav.addObject("board",board);
		return mav;
	}
	
}
