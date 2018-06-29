package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Board;
import logic.ProjectService;
import logic.Reserve;

@Controller
public class ReserveController {
	
	@Autowired
	private ProjectService service;
	
	@RequestMapping(value="reserve/list", method=RequestMethod.GET)
	public ModelAndView reserveList(String id, Integer pageNum, String searchType, String searchContent) {
		
		if(pageNum == null || pageNum.toString().equals("")) {
			pageNum = 1;
		}
		
		ModelAndView mav = new ModelAndView();
		
		int limit = 100;		// 한 페이지에 나올 게시글의 숫자
		int listcount = service.reserveCount(id, searchType, searchContent);	// 표시될 총 게시글의 수
		if (id != null) {
		List<Reserve> reservelist = service.selectReserveList(id, searchType, searchContent, pageNum, limit);
		
		int maxpage = (int)((double)listcount/limit + 0.95);
		int startpage = ((int)((pageNum/10.0 + 0.9) - 1)) * 10 + 1; // 시작페이지
		int endpage = startpage + 9;	// 마지막 페이지
		if(endpage > maxpage) endpage = maxpage;
		int reservecnt = listcount - (pageNum - 1) * limit;
		mav.addObject("pageNum", pageNum);
		mav.addObject("maxpage", maxpage);
		mav.addObject("startpage", startpage);
		mav.addObject("endpage", endpage);
		mav.addObject("listcount",listcount);
		mav.addObject("reserlist",reservelist);
		mav.addObject("reservecnt",reservecnt);
		}
				
		return mav;
	}
	
	
	// 예약업무 관련하여 Default 호출값으로 지정한 메서드 : 예약보기, 예약등록화면, 수정화면
	@RequestMapping(value="reserve/*", method=RequestMethod.GET) 
	public ModelAndView detailReserve(Reserve res, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		Reserve reserve = new Reserve();
		if(res != null) {
			if(res.getReNo() != null) {
				service.getReserve(res.getReNo());
			}
		}
		
		mav.addObject("reserve", reserve);
		return mav;
	}
	
}
