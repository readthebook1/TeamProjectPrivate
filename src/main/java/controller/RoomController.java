package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.ProjectService;
import logic.Room;

@Controller
public class RoomController {
	@Autowired
	private ProjectService service;

	@ModelAttribute
	public Room getRoom() {
		return new Room();
	}
	@RequestMapping("room/intro") // 별의미없는 페이지
	public ModelAndView join(@Valid Member member, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("room/intro");
			return mav;
		}
	@RequestMapping("room/roomForm")
	public ModelAndView roomForm() {
		ModelAndView mav = new ModelAndView("room/roomForm");
		mav.addObject(new Room());
	return mav;
	}
	@RequestMapping("room/roomSuccess")
	public ModelAndView roomSuccess(Room room) {
		ModelAndView mav = new ModelAndView("room/roomSuccess");
		service.insertRoom(room);
	return mav;
}
}
