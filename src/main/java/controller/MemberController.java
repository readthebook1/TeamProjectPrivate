package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Member;
import logic.ProjectService;


@Controller
public class MemberController {
	@Autowired
	ProjectService service;
	
	@ModelAttribute
	public Member getMember() {
		return new Member();
	}
	
	@RequestMapping(value = "member/login", method = RequestMethod.GET)
	public String loginForm() {
		return "member/login";
	}
	
	
	@RequestMapping(value = "member/login", method = RequestMethod.POST)
	public ModelAndView loginForm(Member member, HttpSession session) {

		ModelAndView mav = new ModelAndView("member/login");

		Member dbMember = service.getMember(member.getId());

		if (dbMember.getPw().equals(member.getPw())) {
			mav.addObject("dbMember", dbMember);
			mav.setViewName("member/loginSuccess");
			session.setAttribute("loginMember", dbMember);
		} else {	
			return mav;
		}	
		return mav;
	}
}
