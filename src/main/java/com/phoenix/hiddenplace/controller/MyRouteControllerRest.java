package com.phoenix.hiddenplace.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.hiddenplace.domain.MyRoute;
import com.phoenix.hiddenplace.service.MyRouteService;

@RestController
@RequestMapping(value = "/myroute")
public class MyRouteControllerRest {

	@Inject
	private MyRouteService service;

	//나만의루트 베스트 3
	@RequestMapping(value = "/bestMR", method = RequestMethod.GET)
	public ResponseEntity<List<MyRoute>> bestMR() throws Exception {

		ResponseEntity<List<MyRoute>> entity = null;

		try {

			entity = new ResponseEntity<List<MyRoute>>(service.bestMR(), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("best3 목록보기에서 오류");
			entity = new ResponseEntity<List<MyRoute>>(HttpStatus.BAD_REQUEST);

		}

		return entity;
	}

}   