package kr.co.ads.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {
	@Autowired
	AuthenticationServiceImpl authenticationServiceImpl;
	@Autowired
	HttpSession session;

	// 인증 활성화
	@GetMapping("/active")
	public ModelAndView activateAuth(AuthInfo authInfo) {
		ModelAndView mav = null;

		try {
			mav = new ModelAndView();
			boolean result = authenticationServiceImpl.activeAuth(authInfo);
			if (result) {
				session.invalidate();
				mav.setViewName("/authentication/success");
			} else {
				mav.setViewName("/authentication/fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

}
