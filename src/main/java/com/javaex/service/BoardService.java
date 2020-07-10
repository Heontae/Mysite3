package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public List<BoardVo> list(int page, String keyword) {
		int start = page * 5 - 4;
		int end = page * 5;

		BoardVo boardVo = new BoardVo(start, end, keyword);

		return boardDao.selectList(boardVo);
	}

	public int Page(String keyword) {
		int count = boardDao.count(keyword);
		count = (int) Math.ceil(count / 5.0);
		return count;
	}

	public String keyword(String keyword) {

		return keyword;

	}

	public int write(BoardVo boardVo) {
		return boardDao.insert(boardVo);
	}

	public BoardVo selectOne(int num) {
		boardDao.hit(num);
		return boardDao.selectOne(num);
	}

	public int modify(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}

	public int delete(int no) {
		return boardDao.delete(no);
	}

}
