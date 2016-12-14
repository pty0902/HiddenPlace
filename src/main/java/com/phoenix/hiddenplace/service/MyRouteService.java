package com.phoenix.hiddenplace.service;

import java.util.List;

import com.phoenix.hiddenplace.domain.MyRoute;

public interface MyRouteService {

	List<MyRoute> bestMR() throws Exception; //나만의루트 베스트 3
	
}


