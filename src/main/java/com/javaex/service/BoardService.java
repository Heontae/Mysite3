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
	

	public List<BoardVo> list(int page, List<Integer> list){
		int start = page*5-4;
		int End = page*5;
		int count = boardDao.count();
		
		count = (int)Math.ceil(count/5.0);
		
		for(int i = 0; i < count; i++) {
			list.add(i+1);
		}
		
		BoardVo boardVo = new BoardVo(start,End);
		return boardDao.selectList(boardVo);
	}

	public int write(BoardVo boardVo){
		return boardDao.insert(boardVo);
	}
	
	public BoardVo selectOne(int num){
		boardDao.hit(num);
		return boardDao.selectOne(num);
	}
	
	public int modify(BoardVo boardVo){
		return boardDao.update(boardVo);
	}
	
	public int delete(int no){
		return boardDao.delete(no);
	}
	
	public List<BoardVo> search(String keyword){
		List<BoardVo> bList = boardDao.searchUser(keyword);
		return bList;
	}
	
	
}
