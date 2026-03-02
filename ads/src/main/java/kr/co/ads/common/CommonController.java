package kr.co.ads.common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.co.ads.member.Member;

@RestController
public class CommonController {
	@Autowired
	CommonServiceImpl commonServiceImpl;
	@Autowired
	HttpSession session;
	
	//로그인 양식
	@GetMapping("/login")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("/common/login");

		return mav;
	}
	
	//로그인
	@PostMapping("/login")
	public ModelAndView login(Member member) {
		ModelAndView mav = null;
		
		try {
			mav = new ModelAndView(new RedirectView("/rental"));
			boolean result = commonServiceImpl.login(member);
			
			if (result) {
				mav.setViewName("redirect:/rental");
				session.setAttribute("id", member.getId());
			} else {
				mav.setViewName("/common/login");
				mav.addObject("errorMessage", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	//로그아웃
	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView(new RedirectView("/login"));
		session.invalidate();
		
		return mav;
	}
}
