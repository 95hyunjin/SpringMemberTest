package com.itwillbs.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService mService;
	
	// 회원가입
	// http://localhost:8088/web/member/memberjoin
	@RequestMapping(value = "/memberjoin", method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.debug(" memberJoinGET() 실행 - 회원정보 입력 ");
	}
	
	@RequestMapping(value = "/memberjoin", method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO vo) {
		logger.debug(" memberJoinPOST() 실행 - 회원정보 처리 ");
		logger.debug(" 전달 정보 vo : " + vo);
		mService.memberJoin(vo);
		
		return "redirect:/member/login";
	}
	
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.debug(" memberLoginGET() 실행 ");
		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO vo) {
		logger.debug(" memberLoginPOST() 실행 ");
		logger.debug(" 로그인 정보 : " + vo);
		
		MemberVO resultVO = mService.memberLogin(vo);
		
		String addr = "";
		
		if(resultVO == null) {
			logger.debug(" 로그인 실패! ");
			addr = "/member/login";
		}else{
			logger.debug(" 로그인 성공! ");
			addr = "/member/main";
		}
		return "redirect:"+ addr;
	}
	
	
	
	
	
	
	
}