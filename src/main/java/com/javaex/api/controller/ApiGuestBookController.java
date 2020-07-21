package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/api/guestbook")
public class ApiGuestBookController {

@Autowired
private GuestbookService guestbookService; 
	
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public List<GuestbookVo> list(){
		List<GuestbookVo> guestbookList = guestbookService.list();
		return guestbookList;
	}
	
	@ResponseBody
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public GuestbookVo write(@RequestBody GuestbookVo guestbookVo) {
		GuestbookVo vo =guestbookService.addGuest(guestbookVo);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public int delete(@ModelAttribute GuestbookVo guestbookVo) {
		int count =guestbookService.delete(guestbookVo);
		return count;
	}
}
