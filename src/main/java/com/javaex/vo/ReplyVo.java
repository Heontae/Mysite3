package com.javaex.vo;

public class ReplyVo {
	// 필드
	private int no, user_no, hit, group_no, order_no, depth;
	private String title, content, reg_date, name,state;
	
	private String keyword;
	private int start,end;

	// 생성자
	public ReplyVo() {

	}

	public ReplyVo(String keyword, int start, int end) {
		super();
		this.keyword = keyword;
		this.start = start;
		this.end = end;
	}

	public ReplyVo(int no, int user_no, int hit, int group_no, int order_no, int depth, String title, String content,
			String reg_date, String name,String state) {
		this.no = no;
		this.user_no = user_no;
		this.hit = hit;
		this.group_no = group_no;
		this.order_no = order_no;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.reg_date = reg_date;
		this.name = name;
		this.state = state;
	}
	
	// g,s
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroup_no() {
		return group_no;
	}

	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	
	// toString
	@Override
	public String toString() {
		return "ReplyVo [no=" + no + ", user_no=" + user_no + ", hit=" + hit + ", group_no=" + group_no + ", order_no="
				+ order_no + ", depth=" + depth + ", title=" + title + ", content=" + content + ", reg_date=" + reg_date
				+ ", name=" + name + ", state=" + state + "]";
	}
}
