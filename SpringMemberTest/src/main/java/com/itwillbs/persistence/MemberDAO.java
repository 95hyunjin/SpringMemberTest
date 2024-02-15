package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입 처리 메서드
	public void insertMember(MemberVO vo);
	
	
}
