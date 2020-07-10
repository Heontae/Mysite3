package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	SqlSession sqlsession;
	
	public List<BoardVo> selectList(BoardVo boardVo){
	
		List<BoardVo> bList=sqlsession.selectList("board.list",boardVo);
		return bList;
	}
	
	public int insert(BoardVo boardVo){
		return sqlsession.insert("board.insert",boardVo);
	}
	
	public BoardVo selectOne(int num) {
		return sqlsession.selectOne("board.selectOne",num);
	}
	
	public int update(BoardVo boardVo){
		return sqlsession.update("board.update",boardVo);
	}
	
	public int delete(int no){
		return sqlsession.delete("board.delete",no);
	}
	
	public int hit(int no){
		
		return sqlsession.update("board.hit",no);
	}
	
	public int count(String keyword) {
		return sqlsession.selectOne("board.count",keyword);
	}
}
