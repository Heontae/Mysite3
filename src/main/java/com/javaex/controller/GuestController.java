package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestbookService guestService;

	@RequestMapping("/list")
	public String list(Model model) {
		List<GuestbookVo> gList = guestService.list();
		model.addAttribute("gList", gList);

		return "guestbook/addList";
	}

	@RequestMapping("/add")
	public String add(@ModelAttribute GuestbookVo guestVo) {
		guestService.add(guestVo);

		return "redirect:/guest/list";
	}

	@RequestMapping("/deleteForm")
	public String deleteForm(Model model, @RequestParam int no) {
		model.addAttribute("no", no);

		return "guestbook/deleteForm";
	}

	@RequestMapping("/delete")
	public String delete(Model model, @ModelAttribute GuestbookVo guestVo, @RequestParam int no) {
		int count = guestService.delete(guestVo);

		if (count == 0) {
			model.addAttribute("no", no);
			return "redirect:/guest/deleteForm?result=fail";
		} else {
			return "redirect:/guest/list";
		}
	}

	//ajax 방명록
	@RequestMapping("/ajaxList")
	public String ajaxList() {
		
		return "guestbook/ajaxList";
	}
}