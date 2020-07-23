package com.javaex.vo;

public class GalleryVo {
	// 필드
	private int no, user_no;
	private String content, filePath, orgName, saveName,name;
	private long fileSize;

	private int start,end;

	// 생성자
	public GalleryVo() {

	}

	public GalleryVo(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public GalleryVo(int user_no, long fileSize, String content, String filePath, String orgName, String saveName) {
		this.user_no = user_no;
		this.fileSize = fileSize;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
	}

	public GalleryVo(int no, int user_no, long fileSize, String content, String filePath, String orgName,
			String saveName) {
		this.no = no;
		this.user_no = user_no;
		this.fileSize = fileSize;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
	}

	// g.s
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	// 일반메소드

	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", user_no=" + user_no + ", content=" + content + ", filePath=" + filePath
				+ ", orgName=" + orgName + ", saveName=" + saveName + ", name=" + name + ", fileSize=" + fileSize + "]";
	}
	

}
