package aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import exception.ProjectException;
import logic.Member;

@Component // 객체화 11
@Aspect // AOP클래스 지칭 test
public class LoginAspect {

	// MemberController.mypage(String id, HttpSession session) 메서드 호출 전에
	// memberLoginCheck(..)메서드 호출
	
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
			id = (String) joinPoint.getArgs()[0]; // 파라미터 id 값
			session = (HttpSession) joinPoint.getArgs()[1]; // session 값
		}

		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if (loginMember == null) {throw new ProjectException("로그인 후 거래하세요.", "../main.test");}
		if (!id.equals(loginMember.getId()) && !loginMember.getId().equals("admin")) {
			throw new ProjectException("본인만 거래 가능합니다.", "../main.test");
		}
		
		Object ret = joinPoint.proceed(); // CoreAlgolism 실행
		return ret;
	}
	
	//adminLoginCheck() 메서드
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
					throw new ProjectException("관리자로 로그인 하세요.", "../main.test");
				}
				
				if(!loginMember.getId().equals("admin")) {
					throw new ProjectException("관리자만 가능한 거래입니다.", "../main.test");
				}
				
				adminable = true;
				break;
			}
		}
		
		if(!adminable) {
			throw new ProjectException("전산부로 전화하세요. 세션 객체가 요구됨.", "../main.test");
		}
		
		Object ret = joinPoint.proceed();
		return ret;
	}
}
