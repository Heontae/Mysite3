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

	// 리스트 가져오기 (검색가능)
	public List<BoardVo> list(int page, String keyword) {
		int start = page * 5 - 4;
		int end = page * 5;

		BoardVo boardVo = new BoardVo(start, end, keyword);

		return boardDao.selectList(boardVo);
	}

	// 페이지 갯수 정해주기
	public int Page(String keyword) {
		int count = boardDao.count(keyword);
		count = (int) Math.ceil(count / 5.0);
		return count;
	}

	// 페이지 이동해도 키워드값 유지해주기
	public String keyword(String keyword) {

		return keyword;
	}
	//정보 하나가져오기(조회수+1)
	public BoardVo selectOne(int num) {
		boardDao.hit(num);
		return boardDao.selectOne(num);
	}

	public int write(BoardVo boardVo) {
		return boardDao.insert(boardVo);
	}

	public int modify(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}

	public int delete(int no) {
		return boardDao.delete(no);
	}

}
