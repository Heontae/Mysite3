package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.ReplyService;
import com.javaex.vo.ReplyVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private ReplyService ReplyService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", defaultValue = "1") int page) {
		
		// 전체 리스트(검색가능)
		List<ReplyVo> RList = ReplyService.list(page ,keyword);
		model.addAttribute("RList", RList);

		// 검색하고 페이지 이동해도 키워드값 유지
		model.addAttribute("keyword", ReplyService.keyword(keyword));
		
		// 밑에 페이지 갯수
		model.addAttribute("count", ReplyService.Page(keyword));
		
		// 현재 페이지 번호
		model.addAttribute("page", page);
		return "reply/list";
	}

	@RequestMapping("/writeForm")
	public String WriteForm() {

		return "reply/writeForm";
	}

	@RequestMapping("/write")
	public String Write(@ModelAttribute ReplyVo replyVo, HttpSession session) {
		replyVo.setUser_no(((UserVo) session.getAttribute("session")).getNo());
		ReplyService.write(replyVo);
		return "redirect:/reply/list";
	}

	@RequestMapping("/read")
	public String read(@RequestParam int no, Model model) {
		ReplyVo ReplyVo = ReplyService.read(no);
		model.addAttribute("ReplyVo", ReplyVo);

		return "reply/read";
	}

	@RequestMapping("/replyWriteFrom")
	public String replyWriteForm() {

		return "reply/writeForm";
	}

	@RequestMapping("/replyWrite")
	public String replyWrite(@ModelAttribute ReplyVo replyVo, HttpSession session) {
		replyVo.setUser_no(((UserVo) session.getAttribute("session")).getNo());

		ReplyService.reWrite(replyVo);

		return "redirect:/reply/list";
	}

	@RequestMapping("/modifyForm")
	public String replyModifyForm(Model model, @RequestParam int no) {
		ReplyVo ReplyVo = ReplyService.selectOne(no);
		model.addAttribute("ReplyVo", ReplyVo);
		return "reply/modifyForm";
	}

	@RequestMapping("/modify")
	public String replyModify(@ModelAttribute ReplyVo ReplyVo) {
		ReplyService.modify(ReplyVo);

		return "redirect:/reply/list";
	}

	@RequestMapping("/delete")
	public String replydelete(@RequestParam int no) {
		ReplyService.delete(no);

		return "redirect:/reply/list";
	}
}
