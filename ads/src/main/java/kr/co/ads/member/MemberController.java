package kr.co.ads.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import kr.co.ads.member.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberServiceImpl memberServiceImpl;

	// 본인 인증 양식
	@GetMapping("/certification")
	public ModelAndView selfCertificationForm() {
		ModelAndView mav = new ModelAndView("/member/selfcertification");

		return mav;
	}

	// 본인 인증
	@PostMapping("/certification")
	public ModelAndView selfCertification(Member member) {
		ModelAndView mav = null;

		try {
			mav = new ModelAndView();
			boolean result = memberServiceImpl.selfCertification(member);
			
			if (result) {
				// 성공
				mav.setViewName("/member/card");
			} else {
				// 실패
				mav.setViewName("/member/phonefail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	// 카드 정보 갱신
	@PostMapping("/card") // 카드명 아이디
	public ModelAndView updateCardInfo(Member member) {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView();
			boolean result = memberServiceImpl.updateCardInfo(member);
			
			if (result) {
				// 성공
				mav.setViewName("/member/success");
			} else {
				// 실패
				mav.setViewName("/member/registerfail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

}
