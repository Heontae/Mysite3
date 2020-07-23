package com.javaex.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;

	@RequestMapping("/list")
	public String list(Model model,@RequestParam(value = "page", defaultValue = "1") int page) {
		Map<String,Object> gMap = galleryService.list(page);
		model.addAttribute("gMap", gMap);
		
		return "Gallery/list";
	}
	
	//이미지 등록하기
	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("content") String content,HttpSession session) {
		int user_no = ((UserVo)session.getAttribute("session")).getNo();

		galleryService.upload(file, content,user_no);

		return "redirect:/gallery/list";
	}
	
	@ResponseBody
	@RequestMapping("/select")
	public GalleryVo select(@RequestParam("no")int no) {
		
		
		return galleryService.selectOne(no);
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public int delete(@RequestParam("no")int no) {
		
		int count = galleryService.delete(no);
		return count;
	}
	
}
