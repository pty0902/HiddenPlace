package com.phoenix.hiddenplace;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class DataSouceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DataSouceTest.class);
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testConntection() throws Exception {
		
		logger.info("testConntection() 호출됨.");
		
//		jdk 1.7 이상
		try(Connection conn = ds.getConnection()) {
			System.out.println("DB 연결 성공");
			System.out.println("conn = " + conn);
		}
		
	}

}

