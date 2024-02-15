package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

import lombok.val;

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
	public String memberLoginPOST(MemberVO vo, HttpSession session) {
		logger.debug(" memberLoginPOST() 실행 ");
		logger.debug(" 로그인 정보 : " + vo);
		
		MemberVO resultVO = mService.memberLogin(vo);
		
		String addr = "";
		
		if(resultVO == null) {
			logger.debug(" 로그인 실패! ");
			addr = "/member/login";
		}else{
			logger.debug(" 로그인 성공! ");
			session.setAttribute("id", resultVO.getUserid());
			addr = "/member/main";
		}
		return "redirect:"+ addr;
	}
	
	
	// 메인페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String memberMainGET() {
		logger.debug(" memberMainGET() 호출 ");
		
		return "/member/main";
	}
	
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogoutGET(HttpSession session) {
		logger.debug(" memberLogoutGET() 호출 ");
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	
	// 회원정보 조회
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void memberInfoGET(HttpSession session, Model model) {
		logger.debug(" memberInfoGET() 호출 ");
		
		String id = (String) session.getAttribute("id");
		logger.debug(" id : " + id);
		MemberVO resultVO = mService.memberInfo(id);
		model.addAttribute("resultVO", resultVO);
	}
	
	
	// 회원정보 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void memberUpdateGET(HttpSession session, Model model) {
		logger.debug(" memberUpdateGET() 호출 ");
		String id = (String) session.getAttribute("id");
		MemberVO resultVO = mService.memberInfo(id);
		
		model.addAttribute("resultVO", resultVO);
	}
		
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdatePOST(MemberVO vo) {
		logger.debug(" memberUpdatePOST() 호출");
		logger.debug(" 수정할 정보 : " + vo);
		
		int result = mService.memberUpdate(vo);
		if(result == 1) {
			logger.debug(" 수정완료! ");
			return "redirect:/member/main";
		}
		logger.debug(" 수정실패! ");
		return "redirect:/member/update";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}