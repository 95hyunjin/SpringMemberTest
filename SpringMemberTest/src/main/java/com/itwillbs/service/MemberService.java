package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	// 회원가입 메서드
	public void memberJoin(MemberVO vo);
	
	// 로그인 메서드
	public MemberVO memberLogin(MemberVO vo); 
	
}
