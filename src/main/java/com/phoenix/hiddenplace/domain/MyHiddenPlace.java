package com.phoenix.hiddenplace.domain;

public class MyHiddenPlace {

	private int num;
	private String userId;
	private int regionTownCode;
	private int themeCode;
	private String title;
	private String content;
	private String writeDate;
	private int upCount;
	private int readCount;
	private String storeName;
	private int code;
	private double latitude; 
	private double longitude; 
	private String detailAddress;
	private String userNickName; //닉네임 유저
	private String titleImgURL; //타이틀 이미지
	private String keyWord;
	
	public String getTitleImgURL() {
		return titleImgURL;
	}
	public void setTitleImgURL(String titleImgURL) {
		this.titleImgURL = titleImgURL;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int getRegionTownCode() {
		return regionTownCode;
	}
	
	public void setRegionTownCode(int regionTownCode) {
		this.regionTownCode = regionTownCode;
	}
	
	public int getThemeCode() {
		return themeCode;
	}
	
	public void setThemeCode(int themeCode) {
		this.themeCode = themeCode;
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
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getDetailAddress() {
		return detailAddress;
	}
	
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
}
