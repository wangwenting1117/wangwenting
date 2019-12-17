package com.edu.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.edu.test.BaseTest;
import com.edu.core.ExcelDataProvider;

public class Login_x extends BaseTest{
	//登录数据驱动
	@DataProvider(name="login")
	public Object [][] loginname() throws IOException{
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		Object[][] objects = excelDataProvider.getTestDataByExcel("E://ExcelData//WordPressData.xlsx","Sheet1");
		return objects;
	}
	@Test(description="数据驱动",dataProvider="login")
	public void login(String name,String psd) {
		webtest.open("http://localhost:8081/wp-login.php");
		//�ı�������
		webtest.typeAndClear("name=log", name);
		webtest.typeAndClear("name=pwd", psd);
		webtest.click("xpath=//input[@type='submit']");
		//assertTrue(webtest.isTextPresent("�ǳ�"));	
		}
	//新建页面数据驱动
	
			@DataProvider(name="test1")
			public Object [][] test1() throws IOException{
				ExcelDataProvider excelDataProvider = new ExcelDataProvider();
				Object[][] objects = excelDataProvider.getTestDataByExcel("E://ExcelData//test1.xlsx","sheet1");
				return objects;
			}
			@Test(description="新建页面的数据驱动",dataProvider="test1")
			public void test1(String post_title,String t) throws InterruptedException {
//				webtest.open("http://localhost:8081/wordpress/wp-admin/post-new.php?post_type=page");
				//�ı�������
				webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[5]/a");//点击页面
				webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[5]/ul/li[3]/a");//点击Add New
				
				webtest.typeAndClear("name=post_title", post_title);
				webtest.enterFrame("content_ifr");
				webtest.click("tag=body");
				Thread.sleep(10000);
				webtest.type("tag=body", t);
				webtest.leaveFrame();
				webtest.click("xpath=//*[@id=\"publish\"]");
				//assertTrue(webtest.isTextPresent("����"));	
				}
			
			//搜索评论数据驱动
			@DataProvider(name="test2")
			public Object [][] test2() throws IOException{
				ExcelDataProvider excelDataProvider = new ExcelDataProvider();
				Object[][] objects = excelDataProvider.getTestDataByExcel("E://ExcelData//test2.xlsx","sheet1");
				return objects;
			}
			@Test(description="搜索评论的数据驱动",dataProvider="test2")
			public void test2(String s) {
				webtest.open("http://localhost:8081/wordpress/wp-admin/post-new.php?post_type=page");
				webtest.click("xpath=//*[@id=\"menu-comments\"]/a/div[3]");
				//�ı�������
				webtest.typeAndClear("name=s", s);
				webtest.click("xpath=//*[@id=\"search-submit\"]");
				assertTrue(webtest.isTextPresent("搜索评论"));	
				}
	
	
	@Test
	public void testLogin() throws InterruptedException {
		
		//新建页面
		webtest.click("xpath=//*[@id=\"menu-pages\"]/a/div[3]");
		webtest.click("xpath=//*[@id=\"menu-pages\"]/ul/li[3]/a");
		assertTrue(webtest.ifContains("Add New Page"));
		
		//新建页面添加媒体
		webtest.click("xpath=//*[@id=\"insert-media-button\"]");
		assertTrue(webtest.ifContains("Add Media"));
		//搜索媒体库
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-0\"]/div[3]/div/a[2]");
		webtest.type("xpath=//*[@id=\"media-search-input\"]","测试");
		assertTrue(webtest.ifContains("Media Library"));
		Thread.sleep(3000);
		
//		//�ϴ��ļ�
//		webtest.click("xpath=//*[@id=\"__wp-uploader-id-0\"]/div[3]/div/a[1]");
//		//С��100m
//		webtest.type("xpath=//*[@id=\"html5_1drna59halpa1hn1eee9kk18hm5_container\"]", "D:\\project-training\\caseTemplate.xlsx");
//		//����100m
//		webtest.type("xpath=//*[@id=\"html5_1drna59halpa1hn1eee9kk18hm5_container\"]", "D:\\project-training\\����100M������ƵEP19\\EP19.mp4");		
		
		//关闭媒体库
		webtest.click("xpath=//*[@id=\"__wp-uploader-id-2\"]/div[1]/button");
		assertTrue(webtest.ifContains("Add New Page"));
		//所有页面
		webtest.click("xpath=//*[@id=\"menu-pages\"]/ul/li[2]/a");
		assertTrue(webtest.ifContains("Pages"));
		//全选
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		//编辑
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("xpath=//*[@id=\"doaction\"]");
		webtest.click("xpath=//*[@id=\"bulk-edit\"]/td/fieldset[2]/div/label[1]/select/option[2]");
		webtest.click("xpath=//*[@id=\"post_parent\"]/option[2]");
		webtest.click("xpath=//*[@id=\"bulk-edit\"]/td/fieldset[2]/div/div[1]/label/select/option[2]");
		webtest.click("xpath=//*[@id=\"bulk_edit\"]");
		assertTrue(webtest.ifContains("Edit"));
		//搜索
		webtest.type("xpath=//*[@id=\"post-search-input\"]","test1");
		webtest.click("xpath=//*[@id=\"search-submit\"]");
		assertTrue(webtest.ifContains("No pages found."));
		//移回收站
		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/ul/li[1]/a");//点击all
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("xpath=//*[@id=\"search-submit\"]");
		assertTrue(webtest.ifContains("Trash"));
		//��������
		//webtest.click("xpath=//*[@id=\"message\"]/p/a");
		//assertTrue(webtest.ifContains("����"));
		//草稿
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[3]/a");
		webtest.click("xpath=//*[@id=\"filter-by-date\"]/option[2]");
		webtest.click("xpath=//*[@id=\"post-query-submit\"]");
		assertTrue(webtest.ifContains("Draft"));
		
		
		//评论
		webtest.click("xpath=//*[@id=\"menu-comments\"]/a/div[3]");
		assertTrue(webtest.ifContains("Comments"));
		//全选
		webtest.click("id=cb-select-all-1");
		//驳回
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("id=doaction");
		//批准
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("id=doaction");
		//标记为垃圾
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[4]");
		webtest.click("id=doaction");
		//不是垃圾
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[4]/a");
		webtest.click("xpath=//*[@id=\"cb-select-all-1\"]");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[2]");
		webtest.click("id=doaction");
		//移回收站
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[1]/a");
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[5]");
		webtest.click("id=doaction");
		//从回收站还原
		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[5]/a");
		webtest.click("id=cb-select-all-1");
		webtest.click("xpath=//*[@id=\"bulk-action-selector-top\"]/option[3]");
		webtest.click("id=doaction");

		//��������(д��������)
//		webtest.click("xpath=//*[@id=\"wpbody-content\"]/div[5]/ul/li[1]/a");
//		webtest.type("id=comment-search-input","hh" );
//		webtest.click("id=search-submit");
//		assertTrue(webtest.ifContains("����"));
		
		//回复
		webtest.click("xpath=//*[@id=\"comment-2\"]/td[2]/div[3]/span[3]/a");
		assertTrue(webtest.ifContains("Reply"));
	}
}
