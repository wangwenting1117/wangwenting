package com.edu.test.lizixuan;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.test.lizixuan.BaseTest;
import com.edu.core.ExcelDataProvider;
import com.edu.utils.ReadProperties;

public class Login_Test extends BaseTest{
	
	
   @DataProvider(name="test1")
   public Object[][] createData1() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet1");
   }
   @DataProvider(name="test2")
   public Object[][] createData2() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet2");
   }
   @DataProvider(name="test3")
   public Object[][] createData3() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet3");
   }
   @DataProvider(name="test5")
   public Object[][] createData5() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet5");
   }
   @DataProvider(name="test7")
   public Object[][] createData7() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet7");
   }
   @DataProvider(name="test8")
   public Object[][] createData8() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet8");
   }
   @DataProvider(name="test9")
   public Object[][] createData9() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet9");
   }
   @DataProvider(name="test10")
   public Object[][] createData10() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet10");
   }
   @DataProvider(name="test11")
   public Object[][] createData11() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet11");
   }
   @DataProvider(name="test12")
   public Object[][] createData12() throws IOException{
	   ExcelDataProvider provider=new ExcelDataProvider();
	   return provider.getTestDataByExcel("E://ExcelData//WpData.xlsx", "sheet12");
   }
   @BeforeMethod
   //��¼
   public void test_login1()throws IOException{
	   webtest.open("http://localhost:8081/wp-login.php");
	   webtest.typeAndClear("name=log","baishikele@");
	   webtest.typeAndClear("name=pwd","BaiShiKeLe*");
	   webtest.click("name=wp-submit");
   }
   @Test(dataProvider="test1")
   //��������
   public void test_search(String find){
	   webtest.click("class=wp-menu-name");
	   webtest.click("class=wp-first-item current");
	   webtest.type("name=s",find);
	   webtest.click("id=search-submit");
	   Assert.assertTrue(webtest.ifContains("Dashboard"));
   }
   @Test(dataProvider="test2")
   //������
   public void test_add(String title,String text)throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Add New");
	   webtest.type("name=post_title",title);
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", text);
	   webtest.leaveFrame();
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Edit Post"));
   }
   @Test(dataProvider="test3")
   //����״̬
   public void test_status(String value)throws IOException {
	   webtest.click("link=Posts");;
	   webtest.click("link=Add New");
	   webtest.type("name=post_title","柏氏可乐1");
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", "测试项目1");
	   webtest.leaveFrame();
	   webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form/div/div/div[2]/div/div[1]/div/div/div[1]/div[3]/div[1]/a/span[1]");
	   webtest.selectByValue("id=post_status",value);
	   webtest.click("link=Ok");
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Edit Post"));
   }
	 
   @Test(dataProvider="test5")
   //����ʱ��
   public void test_time(String value2)throws IOException {
	   webtest.click("link=Posts");
	   webtest.click("link=Add New");
	   webtest.type("name=post_title","柏氏可乐3");
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", "测试项目3");
	   webtest.leaveFrame();
	   webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form/div/div/div[2]/div/div[1]/div/div/div[1]/div[3]/div[3]/a/span[1]");
	   webtest.selectByValue("name=mm", value2);
	   webtest.click("link=Ok");
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Edit Post"));
   }
   @Test
   //��ʽ
   public void test_format()throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Add New");
	   webtest.type("name=post_title","柏氏可乐4");
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", "测试项目4");
	   webtest.leaveFrame();
	   webtest.click("id=post-format-aside");
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Edit Post"));
   }
   @Test
   //��ʽ
   public void test_format1()throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Add New");
	   webtest.type("name=post_title","柏氏可乐4");
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", "测试项目4");
	   webtest.leaveFrame();
	   webtest.click("id=post-format-image");
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Edit Post"));
   }
   @Test(dataProvider="test7")
   //����Ŀ¼
   public void test_categories(String name, String ug, String des)throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Categories");
	   webtest.type("id=tag-name",name);
	   webtest.type("id=tag-slug", ug);
	   webtest.type("id=tag-description",des);
	   webtest.click("id=submit");
	   Assert.assertTrue(webtest.ifContains("Add New Category"));
   }
   @Test(dataProvider="test8")
   //�������
   public void test_cate_search(String s)throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Categories");
	   webtest.type("id=tag-search-input", s);
	   webtest.click("id=search-submit");
	   Assert.assertTrue(webtest.ifContains("Add New Category"));
   }
   @Test(dataProvider="test9")
   //������ǩ
   public void test_add_new_tag(String name1,String ug1,String des1)throws IOException
   {
	   webtest.click("link=Posts");
	   webtest.click("link=Tags");
	   webtest.type("id=tag-name",name1);
	   webtest.type("id=tag-slug",ug1);
	   webtest.type("id=tag-description",des1);
	   webtest.click("id=submit");
	   Assert.assertTrue(webtest.ifContains("Add New Tag"));
   }
   @Test(dataProvider="test10")
   //������ǩ
   public void test_tag_search(String s1)throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Tags");
	   webtest.type("id=tag-search-input",s1);
	   webtest.click("id=search-submit");
	   Assert.assertTrue(webtest.ifContains("Add New Tag"));
   }
   @Test(dataProvider="test11")
   //��������
   public void test_action(String action)throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=All Posts");
	   webtest.selectByValue("name=action", action);
	   webtest.click("id=doaction");
	   Assert.assertTrue(webtest.ifContains("Dashboard"));
   }
   @Test(dataProvider="test12")
   //����
   public void test_filter(String date)throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=All Posts");
	   webtest.selectByValue("id=filter-by-date", date);
	   webtest.click("name=filter_action");
	   Assert.assertTrue(webtest.ifContains("Dashboard"));
   }
   @Test
   //�ɼ���
   public void test_visibility_public()throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Add New");
	   webtest.type("name=post_title","柏氏可乐2");
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", "测试项目2");
	   webtest.leaveFrame();
	   webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form/div/div/div[2]/div/div[1]/div/div/div[1]/div[3]/div[2]/a/span[1]");
	   webtest.click("id=visibility-radio-public");
	   webtest.click("link=OK");
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Dashboard"));
   }
   @Test
   //�ɼ���
   public void test_visibility_password()throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Add New");
	   webtest.type("name=post_title","柏氏可乐2");
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", "测试项目2");
	   webtest.leaveFrame();
	   webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form/div/div/div[2]/div/div[1]/div/div/div[1]/div[3]/div[2]/a/span[1]");
	   webtest.click("id=visibility-radio-password");
	   webtest.type("id=post_password","1234");
	   webtest.click("link=OK");
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Dashboard"));
   }
   @Test
   //�ɼ���
   public void test_visibility_private()throws IOException{
	   webtest.click("link=Posts");
	   webtest.click("link=Add New");
	   webtest.type("name=post_title","柏氏可乐2");
	   webtest.enterFrame("content_ifr");
	   webtest.type("id=tinymce", "测试项目2");
	   webtest.leaveFrame();
	   webtest.click("xpath=/html/body/div[1]/div[2]/div[2]/div[1]/div[5]/form/div/div/div[2]/div/div[1]/div/div/div[1]/div[3]/div[2]/a/span[1]");
	   webtest.click("id=visibility-radio-private");
	   webtest.click("link=OK");
	   webtest.click("id=publish");
	   Assert.assertTrue(webtest.ifContains("Dashboard"));
   }
   
}
