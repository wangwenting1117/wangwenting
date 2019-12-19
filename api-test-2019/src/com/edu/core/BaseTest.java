package com.edu.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.edu.utils.DbHelper;

public class BaseTest {
	public DbHelper db ;
	
	@BeforeMethod
	public void setUp()	throws Exception {
		db=DbHelper.getInstance();
		System.out.println("初始化数据库");
  }

	@AfterMethod
	public void tearDown() throws Exception {
		
		db.close();
	}

}
