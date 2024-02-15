package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	//@Test
	public void 회원가입테스트() {
		logger.debug(" 회원가입테스트() 실행 ");
		logger.debug(" DAO 회원가입 메서드 호출 ");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("userTest2");
		vo.setUserpw("1234");
		vo.setUsername("테스트용2");
		vo.setUseremail("test2@test.com");
		
		mdao.insertMember(vo);
		logger.debug("회원가입 완료~~!~!~!~!~!~");
	}
	
	//@Test
	public void 로그인테스트() {
		logger.debug(" 로그인테스트() 실행 ");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		MemberVO resultVO = mdao.loginMember(vo.getUserid(), vo.getUserpw());
		
		if(resultVO != null) {
			logger.debug(" 로그인 성공! ");
			logger.debug(" 메인페이지로 이동 ");
		}else {
			logger.debug(" 로그인 실패! ");
		}
	}
	
	//@Test
	public void 회원정보조회() {
		logger.debug(" 특정 사용자의 정보를 조회하는 메서드 실행! ");
		logger.debug(" id : userTest, pw : 1234 계정정보 사용 ");
		MemberVO vo = mdao.getMember("userTest");
		logger.debug(" vo : " + vo);
	}
	
	//@Test
	public void 회원정보수정() {
		logger.debug(" 회원정보수정() 호출 ");
		MemberVO uvo = new MemberVO();
		uvo.setUserid("userTest");
		uvo.setUserpw("1234");
		uvo.setUsername("수정테스트");
		uvo.setUseremail("test@test.com");
		
		mdao.updateMember(uvo);
	}
	
	//@Test
	public void 회원정보삭제() {
		logger.debug(" 회원정보삭제() 호출 ");
		
		MemberVO dvo = new MemberVO();
		dvo.setUserid("userTest");
		dvo.setUserpw("1234");
		
		int result = mdao.deleteMember(dvo);
		if(result == 1) {
			logger.debug(" 회원정보 삭제 완료 !! ");
		}else {
			logger.debug(" 회원정보 삭제 실패 !! ");
		}
	}
	
	@Test
	public void 회원목록출력() {
		logger.debug(" 회원목록출력() 확인 ");
		List<MemberVO> memberList = mdao.getMemberList();
		
		logger.debug(" memberList : " + memberList);
	}
	
	
	
	
	
}
