package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 사람 출력하기
	public List<GuestbookVo> getList() {
		List<GuestbookVo> gList = sqlSession.selectList("guestbook.getList");

		return gList;
	}
	
	//글 추가하기
	public int insert(GuestbookVo guestVo) {
		
		return sqlSession.insert("guestbook.insert",guestVo);
	}

	//글 삭제하기
	public int delete(GuestbookVo guestVo) {
		
		return sqlSession.delete("guestbook.delete",guestVo);
	}
		
	//방명록 글 저장(ajax)
	public void insertSelectKey(GuestbookVo guestbookVo) {
		sqlSession.insert("guestbook.insertSelectKey",guestbookVo);

	}
	
	//정보 하나 가져오기(ajax)
	public GuestbookVo selectByNo(int no ) {
		return sqlSession.selectOne("guestbook.selectByNo",no);
	}
}
