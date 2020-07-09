package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestDao;
	
	public List<GuestbookVo> list() {
		List<GuestbookVo> gList = guestDao.getList();
		
		return gList;
	}

	public int add(GuestbookVo guestVo) {
		
		return guestDao.insert(guestVo);
	}
	
	public int delete(GuestbookVo guestVo) {
		
		return guestDao.delete(guestVo);
	}
}
