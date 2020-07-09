package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	// 회원가입
	public int join(UserVo userVo) {

		return userDao.insert(userVo);
	}

	// 로그인
	public UserVo login(UserVo userVo) {

		return userDao.selectUser(userVo);
	}

	//회원정보수정
	public int modify(UserVo userVo) {
		
		return userDao.userUpdate(userVo);
	}
	
	//회원정보한명(no값으로)
	public UserVo SelectUserOnd(int num) {
		return userDao.selectUserOne(num);
	}
}
