package com.edu.test.zwangwenting;
import org.testng.Assert;

import java.io.IOException;

import org.apache.poi.poifs.storage.BATBlock.BATBlockAndIndex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.core.ExcelDataProvider;

public class WpTest extends BaseTest{
	
	@DataProvider(name="testtxt")
	public Object[][] createData() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//WordPressData.xlsx","Sheet1");
	}
	
	@DataProvider(name="testtxt1")
	public Object[][] createData1() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//WordPressData.xlsx","Sheet2");
	}
	
	@DataProvider(name="testtxt2")
	public Object[][] createData2() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//WordPressData.xlsx","Sheet3");
	}
	
	@DataProvider(name="testtxt3")
	public Object[][] createData3() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//WordPressData.xlsx","Sheet4");
	}
	
	@Test(dataProvider="testtxt")
	//登录
	public void test1(String username,String password) throws InterruptedException{
		webtest.open("http://localhost:8081/wp-login.php");
//		webtest.type("name=log","baishikele@");
//		webtest.type("name=pwd","BaiShiKeLe*");
		webtest.type("name=log",username);
		webtest.type("name=pwd",password);
		webtest.click("name=wp-submit");
//		webtest.click("class=wp-menu-name");
		webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[9]/a/div[3]");
		//webtest.click("class=wp-first-item current");
		webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[9]/ul/li[2]/a");
		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[1]/div/span[1]/a");
//		webtest.click("class=activate");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form[2]/table/tbody/tr[3]/td[1]/div/span[1]/a");
/*		webtest.mouseoverElement("xpath=/html/body/div/div[2]/div[1]/div/ul[2]/li/a/img");
//		webtest.click("/html/body/div/div[2]/div[1]/div/ul[2]/li/div/ul/li[3]/a");
		webtest.click("class=ab-item");*/
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("activated."));
//		assertTrue(webtest.isTextPresent("Plugin activated."));
	}
	
	
	@Test
	//ͣ激活插件
	public void test2() throws InterruptedException{
		webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[9]/a/div[3]");
		webtest.click("xpath=/html/body/div[1]/div[1]/div[2]/ul/li[9]/ul/li[2]/a");
		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[1]/div/span/a");
//		webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form[2]/table/tbody/tr[3]/td[1]/div/span[1]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("deactivated."));
//		assertTrue(webtest.isTextPresent("Plugin deactivated."));
	}
	
	
	@Test(dataProvider="testtxt1")
	//导出个人资料发送请求
	public void test3(String email) throws InterruptedException{
//		webtest.click("class=wp-menu-name");
//		webtest.click("class=wp-menu-image dashicons-before dashicons-admin-tools");
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/a/div[3]");
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[5]/a");
//		webtest.type("name=username_or_email_for_privacy_request","1433837332@qq.com");
		webtest.type("name=username_or_email_for_privacy_request",email);
//		webtest.click("id=cb-select-all-2");
		webtest.click("name=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("Confirmation request initiated successfully."));
//		assertTrue(webtest.isTextPresent("Confirmation request initiated successfully."));
	}
	
	
	@Test(dataProvider="testtxt2")
	//����ʧ�ܵ����ϵ������� �ʼ���ʽ��д����
	public void test4(String email) throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/a/div[3]");
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[5]/a");
//		webtest.type("name=username_or_email_for_privacy_request","wangwenting");
		webtest.type("name=username_or_email_for_privacy_request",email);
		webtest.click("name=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("Unable to add this request. A valid email address or username must be supplied."));
		//assertTrue(webtest.isTextPresent("Confirmation request initiated successfully."));
		//��ʾ��������ȷ�������ʽ
	}
	
	
	@Test(dataProvider="testtxt3")
	//����ʧ�ܵ����ϵ������� �ʼ���ַδ��д
	public void test5(String email) throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/a/div[3]");
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[5]/a");
//		webtest.type("name=username_or_email_for_privacy_request","");
		webtest.type("name=username_or_email_for_privacy_request",email);
		webtest.click("name=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("请填写此字段"));
		//assertTrue(webtest.isTextPresent("Confirmation request initiated successfully."));
		//��ʾ��������ֶ���������
	}
	
	@Test
	//������������ɾ������������
	public void test6() throws InterruptedException{
		webtest.click("id=cb-select-all-2");
		webtest.click("id=bulk-action-selector-bottom");
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form[3]/div[2]/div[1]/select/option[2]");
		webtest.click("id=doaction2");//apply��ť
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("No items found."));
		//assertTrue(webtest.isTextPresent("����������������ɾ��"));
	}
	
	@Test
	//�鿴���ù�����
	public void test7() throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[2]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("Tools"));
		//assertTrue(webtest.isTextPresent("�鿴���ù�����"));
	}
	
	
	@Test
	//�����ർ��ȫ������
	public void test8() throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[4]/a");//��������
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[5]/form/fieldset/p[1]/label/input");
		webtest.click("id=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("All content"));
		//assertTrue(webtest.isTextPresent("��������"));
	}
	
	
	@Test
	//�����ർ��ȫ�����ӵ�����
	public void test9() throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[5]/form/fieldset/p[3]/label/input");//postѡ��
		webtest.click("id=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("Posts"));
		//assertTrue(webtest.isTextPresent("��������"));
	}
	
	
	@Test
	//�����ർ��person�����е���������
	public void test10() throws InterruptedException{
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/a/div[3]");
		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[4]/a");
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form/fieldset/p[3]/label/input");
		webtest.click("id=cat");
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form/fieldset/ul[1]/li[1]/label/select/option[3]");
		webtest.click("id=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("person"));
		
	}
	
	
	@Test
	//�����ർ��songs�����е���������
	public void test11() throws InterruptedException{
//		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/a/div[3]");
//		webtest.click("xpath=/html/body/div/div[1]/div[2]/ul/li[11]/ul/li[4]/a");
//		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form/fieldset/p[3]/label/input");
		webtest.click("id=cat");
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form/fieldset/ul[1]/li[1]/label/select/option[4]");
		webtest.click("id=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("songs"));
		
	}
	
	
	@Test
	//�����ർ�����з����е�˽������
	public void test12() throws InterruptedException{
		webtest.click("id=cat");
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form/fieldset/ul[1]/li[1]/label/select/option[1]");
		webtest.click("id=post-status");
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form/fieldset/ul[1]/li[4]/select/option[6]");
		webtest.click("id=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("Private"));
	}
	
	
	@Test
	//�����ർ�����еĲݸ�
	public void test13() throws InterruptedException{
		webtest.click("id=post-status");
		webtest.click("xpath=/html/body/div/div[2]/div[2]/div[1]/div[4]/form/fieldset/ul[1]/li[4]/select/option[4]");
		webtest.click("id=submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("Draft"));
	}
	

}
