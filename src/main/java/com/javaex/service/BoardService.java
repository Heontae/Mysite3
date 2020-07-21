package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	// 리스트 가져오기 (검색가능)
	public Map<String,Object> list(int page, String keyword) {
		int listCount = 10;
		page = (page>0)	? page:1; //0보다크면 현재값 0보다 작으면 1로표기
		
		int start = (page-1) * listCount ; //db에서 +1해주기
		int end = page * listCount;

		BoardVo boardVo = new BoardVo(start, end, keyword);
		
		//전체 글 갯수
		int count = boardDao.count(keyword);
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		//마지막 버튼 번호
		int endPageBtnNo = (int) Math.ceil(page / (double)pageBtnCount)*pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo =  endPageBtnNo - (pageBtnCount-1);
		
		//다음 화살표 유뮤next
		boolean next = false;
		if(endPageBtnNo*listCount < count) {
			next = true;
		}else {
			endPageBtnNo = (int)Math.ceil(count/(double)listCount);
		}
		//이전화살표 유뮤
		boolean prev = false;
		if(startPageBtnNo!=1) {
			prev = true;
		}
		List<BoardVo> bList = boardDao.selectList(boardVo);
		Map<String,Object> pMap = new HashMap<String,Object>();
		pMap.put("bList", bList);
		pMap.put("prev", prev);
		pMap.put("next", next);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("keyword", keyword);
		
		return pMap;
	}

	// 페이지 갯수 정해주기
	public int Page(String keyword) {
		//전체 글 갯수
		int count = boardDao.count(keyword);

		
		count = (int) Math.ceil(count / 10.0);
		return count;
	}

	//정보 하나가져오기(조회수+1)
	public BoardVo selectOne(int num) {
		boardDao.hit(num);
		return boardDao.selectOne(num);
	}

	public int write(BoardVo boardVo) {

		return boardDao.insert(boardVo);
	}

	public int modify(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}

	public int delete(int no) {
		return boardDao.delete(no);
	}
	
}
