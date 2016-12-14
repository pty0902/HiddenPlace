package com.phoenix.hiddenplace.dao;

import java.util.List;

import com.phoenix.hiddenplace.domain.MyRoute;

public interface MyRouteDao {

	List<MyRoute> bestMR() throws Exception;//내알못 베스트 3
	
}
