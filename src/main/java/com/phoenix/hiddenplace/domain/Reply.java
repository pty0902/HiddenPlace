package com.phoenix.hiddenplace.domain;

public class Reply {
	
	private int replyNum;
	private int num;
	private int routeNum;
	private String replyComment;
	private String userId;
	
	
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRouteNum() {
		return routeNum;
	}
	public void setRouteNum(int routeNum) {
		this.routeNum = routeNum;
	}
	public String getReplyComment() {
		return replyComment;
	}
	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Reply [replyNum=" + replyNum + ", num=" + num + ", routeNum=" + routeNum + ", replyComment="
				+ replyComment + ", userId=" + userId + "]";
	}
	
	
}
