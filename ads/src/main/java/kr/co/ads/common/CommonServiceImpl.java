package kr.co.ads.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ads.member.Member;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	CommonRepositoryImpl commonRepositoryImpl;

	// 로그인
	@Transactional(readOnly = true)
	@Override
	public boolean login(Member member) throws Exception {

		return commonRepositoryImpl.validMember(member);
	}

}
