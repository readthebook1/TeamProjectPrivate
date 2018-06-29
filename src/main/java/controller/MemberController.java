package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping(value = "member/login", method = RequestMethod.GET) //URL로 검색해서 들어왔을때
	public String loginForm() {
		return "member/loginpage";
	}
	
	@RequestMapping(value="member/joinForm") //회원가입 폼으로 
	public String joinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping("member/join") //회원가입
	public ModelAndView join(@Valid Member member, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("member/joinForm");
		if(bindingResult.hasErrors()) {
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		try {
		service.joinsms(member);
		mav.setViewName("member/loginpage");
		mav.addObject("member",member);
		} catch(DataIntegrityViolationException e) {
			bindingResult.reject("error.duplicate.user");
		}
		return mav;
	}
	
	@RequestMapping(value = "member/login", method = RequestMethod.POST) //id,pw입력해서 로그인 누를때
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
