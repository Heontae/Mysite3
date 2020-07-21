package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	@Autowired
	private FileUploadService fileuploadService;
	
	@RequestMapping("/form")
	public String form() {
		
		return "fileupload/form";
	}
	
	@RequestMapping("/upload")
	public String upload(Model model, @RequestParam("file") MultipartFile file) {
		//file.getOriginalFilename(); <--파일 이름확인하기!
		
		fileuploadService.restore(file);
		
		String saveName = fileuploadService.restore(file);
		model.addAttribute("saveName", saveName);
		return "fileupload/result";
	}
}
