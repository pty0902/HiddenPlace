package com.phoenix.hiddenplace.domain;

public class MyRoute {

	private int routeNum;
	private String userId;
	private String title;
	private String content;
	private String writeDate;
	private int upCount;
	private int readCount;
	private String userNickName; 
	private String mrTitleImgURL;
	
	public int getRouteNum() {
		return routeNum;
	}
	
	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	public int getUpCount() {
		return upCount;
	}
	
	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}
	
	public int getReadCount() {
		return readCount;
	}
	
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public String getUserNickName() {
		return userNickName;
	}
	
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	
	public String getMrTitleImgURL() {
		return mrTitleImgURL;
	}
	
	public void setMrTitleImgURL(String mrTitleImgURL) {
		this.mrTitleImgURL = mrTitleImgURL;
	}
	
}
