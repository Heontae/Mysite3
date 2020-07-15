package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ReplyDao;
import com.javaex.vo.ReplyVo;

@Service
public class ReplyService {

	@Autowired
	private ReplyDao ReplyDao;

	public List<ReplyVo> list(int page, String keyword) {
		int start = page * 5 - 4;
		int end = page * 5;

		ReplyVo ReplyVo = new ReplyVo(keyword, start, end);

		return ReplyDao.selectList(ReplyVo);
	}

	public int Page(String keyword) {
		int count = ReplyDao.page(keyword);
		count = (int) Math.ceil(count / 5.0);
		return count;
	}

	// 페이지 이동해도 키워드값 유지해주기
	public String keyword(String keyword) {

		return keyword;
	}

	public int write(ReplyVo replyVo) {
		return ReplyDao.insert(replyVo);
	}

	public ReplyVo read(int no) {
		ReplyDao.hit(no);
		return ReplyDao.selectOne(no);
	}

	public int reWrite(ReplyVo replyVo) {
		ReplyDao.reUpdate(replyVo);
		return ReplyDao.reInsert(replyVo);
	}

	public ReplyVo selectOne(int no) {
		return ReplyDao.selectOne(no);
	}

	public int modify(ReplyVo ReplyVo) {
		return ReplyDao.update(ReplyVo);
	}

	public int delete(int no) {
		return ReplyDao.delete(no);
	}
}
