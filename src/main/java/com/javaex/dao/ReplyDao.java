package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ReplyVo;

@Repository
public class ReplyDao {

	@Autowired
	SqlSession sqlsession;

	// 전체리스트 가져오기
	public List<ReplyVo> selectList(ReplyVo ReplyVo) {

		List<ReplyVo> RList = sqlsession.selectList("reply.list",ReplyVo);

		return RList;
	}

	// 첫페이지 글쓰기
	public int insert(ReplyVo replyVo) {
		return sqlsession.insert("reply.insert", replyVo);
	}

	// 한명정보 조회하기
	public ReplyVo selectOne(int no) {
		return sqlsession.selectOne("reply.selectOne", no);
	}

	// 댓글로 글쓰기
	public int reInsert(ReplyVo replyVo) {
		return sqlsession.insert("reply.reinsert", replyVo);
	}

	// order_no 증가
	public int reUpdate(ReplyVo replyVo) {
		return sqlsession.update("reply.reupdate", replyVo);
	}

	// 조회수 증가
	public int hit(int no) {
		return sqlsession.update("reply.hit", no);
	}
	
	//게시글 수정
	public int update(ReplyVo ReplyVo) {
		return sqlsession.update("reply.update",ReplyVo);
	}
	
	//삭제버튼
	public int delete(int no) {
		return sqlsession.update("reply.delete",no);
	}

	public int page(String keyword) {
		return sqlsession.selectOne("reply.count",keyword);
	}
}
