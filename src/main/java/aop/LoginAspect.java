package aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import exception.ProjectException;
import logic.Member;

@Component // 媛�泥댄��111
@Aspect // AOP�대���� 吏�移�
public class LoginAspect {

	// MemberController.mypage(String id, HttpSession session) 硫����� �몄� ����
	// memberLoginCheck(..)硫����� �몄�
	
	@Around("execution(* controller.Member*.my*(..))")
	public Object memberLoginCheck(ProceedingJoinPoint joinPoint) throws Throwable {

		String id = null;
		HttpSession session = null;
		Member paramMember = null;
		
		if (joinPoint.getArgs()[0] instanceof Member) {
			paramMember = (Member) joinPoint.getArgs()[0];
			session = (HttpSession) joinPoint.getArgs()[2];
			id = paramMember.getId();
		} else {
			id = (String) joinPoint.getArgs()[0]; // ���쇰�명�� id 媛�
			session = (HttpSession) joinPoint.getArgs()[1]; // session 媛�
		}

		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if (loginMember == null) {throw new ProjectException("濡�洹몄�� �� 嫄곕�����몄��.", "../main.test");}
		if (!id.equals(loginMember.getId()) && !loginMember.getId().equals("admin")) {
			throw new ProjectException("蹂몄�몃� 嫄곕�� 媛��ν�⑸����.", "../main.test");
		}
		
		Object ret = joinPoint.proceed(); // CoreAlgolism �ㅽ��
		return ret;
	}
	
	//adminLoginCheck() 硫�����
	@Around("execution(* controller.Admin*.admin*(..))")
	public Object adminLoginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		
		HttpSession session = null;
		Member loginMember = null;
		boolean adminable = false;
		
		for(int i = 0; i < joinPoint.getArgs().length; i++) {
			if(joinPoint.getArgs()[i] instanceof HttpSession) {
				session = (HttpSession)joinPoint.getArgs()[i];
				loginMember = (Member)session.getAttribute("loginMember");
				
				if(loginMember == null) {
					throw new ProjectException("愿�由ъ��濡� 濡�洹몄�� ���몄��.", "../main.test");
				}
				
				if(!loginMember.getId().equals("admin")) {
					throw new ProjectException("愿�由ъ��留� 媛��ν�� 嫄곕��������.", "../main.test");
				}
				
				adminable = true;
				break;
			}
		}
		
		if(!adminable) {
			throw new ProjectException("���곕�濡� �������몄��. �몄�� 媛�泥닿� ��援щ��.", "../main.test");
		}
		
		Object ret = joinPoint.proceed();
		return ret;
	}
}
