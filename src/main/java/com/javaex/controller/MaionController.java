package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MaionController {

	@RequestMapping("/main")
	public String test() {
		return "main/index";
	}
}
