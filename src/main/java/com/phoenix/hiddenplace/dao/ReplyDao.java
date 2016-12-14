package com.phoenix.hiddenplace.dao;

import java.util.List;

import com.phoenix.hiddenplace.domain.Reply;

public interface ReplyDao {
	
	public List<Reply> selectAllMHP(int num) throws Exception;
	
	public List<Reply> selectAllMR(int myRouteNum) throws Exception;
	
	public void insert(Reply reply) throws Exception;
	
	public void update(Reply reply) throws Exception;
	
	public void delete(Reply reply) throws Exception;
	

}



	
	
	
	
	

