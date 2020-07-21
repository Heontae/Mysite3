package com.javaex.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/list") // page파라미터 없으면 1로표기,keyword없으면 null표기
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "keyword", required = false) String keyword) {

		// 전체 리스트(검색가능)
		Map<String,Object> pMap = boardService.list(page, keyword);
		
		model.addAttribute("pMap", pMap);

		return "board/list";
	}
	//쓰기
	@RequestMapping("/writeForm")
	public String wirteForm(Model model) {

		return "board/writeForm";
	}

	@RequestMapping("/write")
	public String wirte(@ModelAttribute BoardVo boardVo, HttpSession session) {
		boardVo.setUser_no(((UserVo) session.getAttribute("session")).getNo());

		boardService.write(boardVo);
		return "redirect:/board/list";
	}
	//보기
	@RequestMapping("/read")
	public String read(Model model, @RequestParam int no) {
		BoardVo boardVo = boardService.selectOne(no);

		model.addAttribute("boardVo", boardVo);
		return "board/read";
	}
	//수정
	@RequestMapping("/modifyForm")
	public String modifyForm(Model model, @RequestParam int no) {
		BoardVo boardVo = boardService.selectOne(no);
		model.addAttribute("boardVo", boardVo);

		return "board/modifyForm";
	}

	@RequestMapping("/modify")
	public String modify(@ModelAttribute BoardVo boardVo) {
		boardService.modify(boardVo);
		return "redirect:/board/list";
	}
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int no) {
		boardService.delete(no);
		return "redirect:/board/list";
	}

}
