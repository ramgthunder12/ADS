package kr.co.ads.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
	AuthenticationRepositoryImpl authenticationRepositoryImpl;
	
	//인증 활성화
	@Transactional
	@Override
	public boolean activeAuth(AuthInfo authInfo) throws Exception{
		
		return authenticationRepositoryImpl.grantAuthInfo(authInfo);
	}
}
