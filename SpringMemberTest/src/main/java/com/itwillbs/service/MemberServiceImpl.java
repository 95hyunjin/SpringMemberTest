package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO mdao;

	@Override
	public void memberJoin(MemberVO vo) {
		logger.debug(" S : memberJoin(MemberVO vo) 실행 ");
		mdao.insertMember(vo);
		logger.debug(" S : 회원가입 성공! ");
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.debug(" S : memberLogin(MemberVO vo) 실행");
		MemberVO resultvo = mdao.loginMember(vo);
		
		return resultvo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
