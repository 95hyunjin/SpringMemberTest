package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	// 기존DAO
	// 공통변수선언
	// 디비연결 / 자원해재 메서드
	// 각각의 기능 메서드
		// 1.2. 디비연결 (Connection Pool)
		// 3. sql구문 작성 & pstmt객체
		// 4. sql 실행
		// 5. 데이터 처리

	// 스프링DAO
	// 디비연결 => 해당 객체 주입(DI)
	@Inject
	private SqlSession sqlSession;

	// mapper의 위치정보(namespace)
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	@Override
	public void insertMember(MemberVO vo) {
		logger.debug(" insertMember(MemberVO vo) 호출 ");
		
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug(" loginMember(MemberVO vo) 호출 ");
		
		MemberVO vresultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
		
		return vresultVO;
	}

	@Override
	public MemberVO getMember(String userid) {
		logger.debug(" getMember(String userid) 호출 ");
		
		return sqlSession.selectOne(NAMESPACE + ".getMember", userid);
	}

	@Override
	public int updateMember(MemberVO uvo) {
		logger.debug(" updateMember(MemberVO uvo) 호출 ");
		
		return sqlSession.update(NAMESPACE + ".updateMember", uvo);
	}

	
	
	
	
	
	
	
	
	
	
}