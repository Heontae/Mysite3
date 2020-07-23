package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	
	public String restore(MultipartFile file) {
		//======데이터 추출======
		String saveDir = "C:\\JavaStudy\\upload";
		//원본파일 이름추출
		String orgName = file.getOriginalFilename();
		
		//확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//저장파일이름
		String savaName = System.currentTimeMillis() + UUID.randomUUID().toString()+exName;
		
		//파일경로
		String filePath = saveDir+"\\"+savaName;
		
		//파일사이즈
		long fileSize = file.getSize();
		
		/*
		System.out.println("원본파일이름: "+orgName);
		System.out.println("확장자: "+exName);
		System.out.println("파일이름: "+savaName );
		System.out.println("파일경로: "+filePath);
		System.out.println("파일사이즈: " +fileSize);
		*/
		//======파일 서버에 복사======
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
		
		return savaName;
		//파일-->필요한정보추출-->DB에저장 (DB: no,orgName,savaName,filePath,fileSize)
	
	
	}
}
