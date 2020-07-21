package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	SqlSession sqlsession;

	public int insert(UserVo userVo) {
		return sqlsession.insert("user.insert", userVo);
	}

	// 아이디 패스워드 확인
	public UserVo selectUser(UserVo userVo) {
		return sqlsession.selectOne("user.selectUser", userVo);
	}

	public int userUpdate(UserVo userVo) {
		return sqlsession.update("user.update", userVo);
	}

	public UserVo selectUserOne(int num) {
		return sqlsession.selectOne("user.selectUserOne", num);
	}

	// 아이디체크 (ajax)
	public UserVo selectUser(String id) {
		
		return sqlsession.selectOne("user.selectById", id);
	}

}
