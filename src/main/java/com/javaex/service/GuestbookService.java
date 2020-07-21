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
	
	//글 저장 (ajax)
	public GuestbookVo addGuest(GuestbookVo guestbookVo) {
		guestDao.insertSelectKey(guestbookVo);
		
		int no = guestbookVo.getNo(); // **중요**
		
		System.out.println("select로받은 no값:" + no);
		

		return guestDao.selectByNo(no);//no값으로 하나의 정보 가져오기
	}
}
