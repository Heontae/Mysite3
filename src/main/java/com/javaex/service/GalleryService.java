package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;

	public Map<String,Object> list(int page) {
		int listCount = 4;
		page = (page>0) ? page : 1;
		
		int start = (page-1) *listCount;
		int end = page*listCount;
		//전체 글 갯수
		int count = galleryDao.count();
		
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		//마지막 버튼 번호
		int endPageBtnNo = (int) Math.ceil(page / (double)pageBtnCount)*pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo =  endPageBtnNo - (pageBtnCount-1);
		//System.out.println("시작버튼번호: " + startPageBtnNo + "\n마지막버튼번호: "+endPageBtnNo);
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
		
		GalleryVo galleryVo = new GalleryVo(start,end);
		List<GalleryVo> gList = galleryDao.select(galleryVo);
		Map<String,Object> gMap = new HashMap<String,Object>();
		gMap.put("gList", gList);
		gMap.put("prev", prev);
		gMap.put("next", next);
		gMap.put("startPageBtnNo", startPageBtnNo);
		gMap.put("endPageBtnNo", endPageBtnNo);
		
		return gMap;
	}
	
	
	
	public GalleryVo selectOne(int no) {
		return galleryDao.selectOne(no);
	}
	
	public int delete(int no) {
		return galleryDao.delete(no);
	}
	
	//이미지 등록하기
	public int upload(MultipartFile file,String content,int user_no) {
		
		// ======데이터 추출======
		String saveDir = "C:\\JavaStudy\\upload";
		// 원본파일 이름추출
		String orgName = file.getOriginalFilename();

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));

		// 저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

		// 파일경로
		String filePath = saveDir + "\\" + saveName;

		// 파일사이즈
		long fileSize = file.getSize();

		/*
		System.out.println("원본파일이름: "+orgName);
		System.out.println("확장자: "+exName);
		System.out.println("파일이름: "+saveName );
		System.out.println("파일경로: "+filePath);
		System.out.println("파일사이즈: " +fileSize);
		System.out.println("내용: " + content);
		System.out.println("user_no: "+ user_no);
		*/
		//======파일 복사======
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GalleryVo galleryVo = new GalleryVo(user_no,fileSize,content,filePath,orgName,saveName);
		
		return galleryDao.insert(galleryVo);
	}
}
