package kr.co.ads.authentication;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	@Autowired
	AuthenticationServiceImpl authenticationServiceImpl;
	@Autowired
	HttpSession session;

	// 인증 활성화
	@GetMapping("/active")
	public ModelAndView activaAuth(AuthInfo AuthInfo) {
		ModelAndView mav = null;

		try {
			mav = new ModelAndView();
			boolean result = authenticationServiceImpl.activeAuth(AuthInfo);
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
