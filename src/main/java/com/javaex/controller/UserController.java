package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 회원가입
	@RequestMapping("/joinForm")
	public String joinForm() {

		return "user/joinForm";
	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		userService.join(userVo);
 
		return "user/joinOk";
	}

	// 로그인화면
	@RequestMapping("/loginForm")
	public String loginForm() {

		return "user/loginForm";
	}
	//로그인
	@RequestMapping("login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		UserVo authVo = userService.login(userVo);
		if (authVo != null) {
			session.setAttribute("session", authVo);
			return "redirect:/main";
		} else {
			
			return "redirect:/user/loginForm?result=fail";
		}
	}
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("session");
		session.invalidate();
		return "redirect:/main";
	}
	
	//회원 수정 폼
	@RequestMapping("modifyForm")
	public String modifyForm(Model model ,HttpSession session) {
		UserVo sessionNo = (UserVo)session.getAttribute("session");
		int no = sessionNo.getNo();//현재 세션에 no값 가져오기.
		
		UserVo userVo = (UserVo)userService.SelectUserOnd(no);//no값으로 유저정보 가져오기
		model.addAttribute("userVo", userVo);
		
		return "user/modifyForm";
	}
	
	//회원 수정 
	@RequestMapping("modify")
	public String modify(@ModelAttribute UserVo userVo,HttpSession session) {
		userService.modify(userVo);
		
		UserVo sessionName = (UserVo)session.getAttribute("session");
		sessionName.setName(userVo.getName());
		
		return "redirect:/main";
	}
}
