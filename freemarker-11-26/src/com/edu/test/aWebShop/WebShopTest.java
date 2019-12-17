package com.edu.test.aWebShop;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.core.ExcelDataProvider;

public class WebShopTest extends BaseTest{
	@DataProvider(name="testtxt")
	public Object[][] createData() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//LoginData.xlsx","Sheet1");
	}
	
	@DataProvider(name="testtxt1")
	public Object[][] createData1() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//LoginData.xlsx","Sheet2");
	}
	
	@DataProvider(name="testtxt2")
	public Object[][] createData2() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//LoginData.xlsx","Sheet3");
	}
	
	@DataProvider(name="testtxt3")
	public Object[][] createData3() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//LoginData.xlsx","Sheet4");
	}
	
	@DataProvider(name="testtxt4")
	public Object[][] createData4() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//PriceData.xlsx","Sheet1");
	}
	
	@DataProvider(name="testtxt6")
	public Object[][] createData6() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//SearchData.xlsx","Sheet1");
	}
	
	@DataProvider(name="testtxt9")
	public Object[][] createData9() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//MessageData.xlsx","Sheet1");
	}
	
	@Test(dataProvider="testtxt")
	//iWebShop登录失败
	public void test14(String username,String password) throws InterruptedException{
		webtest.open("http://www.iwebshop.com:2034/index.php");
		Thread.sleep(5000);
		webtest.click("xpath=/html/body/header/div[1]/div/div[2]/div/a[1]");
		webtest.type("name=login_info",username);
		webtest.type("name=password",password);
		webtest.click("class=input_submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("账号或密码错误"));
		//��ʾ�˺Ż��������
	}
	
	
	@Test(dataProvider="testtxt1")
	//iWebShop登录失败
	public void test15(String username,String password) throws InterruptedException{
//		webtest.type("name=login_info","baishikelee");
//		webtest.type("name=password","BaiShiKeLe*");
		webtest.type("name=login_info",username);
		webtest.type("name=password",password);
		webtest.click("class=input_submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("账号或密码错误"));
		//��ʾ�˺Ż��������
	}
	
	
	@Test(dataProvider="testtxt2")
	//登录失败
	public void test16(String username,String password) throws InterruptedException{
//		webtest.type("name=login_info","baishikele@");
//		webtest.type("name=password","BaiShiKeLe*");
		webtest.type("name=login_info",username);
		webtest.type("name=password",password);
		webtest.click("class=input_submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("账号或密码错误"));
		//��ʾ�˺Ż��������
	}
	
	
	@Test(dataProvider="testtxt3")
	//登录成功
	public void test17(String username,String password) throws InterruptedException{
//		webtest.type("name=login_info","baishikele");
//		webtest.type("name=password","BaiShiKeLe*");
		webtest.type("name=login_info",username);
		webtest.type("name=password",password);
		webtest.click("class=input_submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("baishikele"));
		//��¼�ɹ� ҳ����ת
	}
	
	//ͨ��
	@Test
	//查看家用电器分类
	public void test18() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��¼��ת֮������ҳ
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[1]/ul/li[1]/div[1]/h3/a");//������õ�����ť
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		//ҳ��ɹ���ת
	}
	
	//ͨ��
	@Test(dataProvider="testtxt4")
	//价值区间寻找商品
	public void test19(String min_price,String max_price) throws InterruptedException{
//		webtest.type("name=min_price","0");//��С�۸�����
//		webtest.type("name=max_price","1500");//���۸�����
		webtest.type("name=min_price",min_price);//��С�۸�����
		webtest.type("name=max_price",max_price);//���۸�����
		webtest.click("xpath=/html/body/div[3]/div/section[2]/aside/section[1]/dl/dd/p/button");//���ȷ��
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("家用电器"));
		//ҳ��ɹ���ת
	}
	
	//ͨ��
	@Test
	//首页轮播图运转
	public void test20() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("class=FocusRight");//����ֲ�ͼ�Ҳఴť
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("baishikele"));
		//��������ʹ��
	}
	
	//ͨ��
	@Test(dataProvider="testtxt6")
	//搜索框实现搜索
	public void test24(String search) throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
//		webtest.type("class=search_keyword","����");
		webtest.type("class=search_keyword",search);
		webtest.click("class=fa fa-search");
		webtest.click("xpath=/html/body/header/div[1]/div/div[4]/form/div/button/i");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("对不起，没有找到相关商品"));
		//��תҳ��ɹ� ������ʾ���Բ���û���ҵ������Ʒ ��
	}
	
	//ͨ��
	@Test(dataProvider="testtxt9")
	//提交订单并添加备注ע
	public void test30(String message) throws InterruptedException{
		/*webtest.open("http://www.iwebshop.com:2034/index.php");
		Thread.sleep(5000);
		webtest.click("xpath=/html/body/header/div[1]/div/div[2]/div/a[1]");
		webtest.type("name=login_info","baishikele");
		webtest.type("name=password","BaiShiKeLe*");
		webtest.click("class=input_submit");*/
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/div[3]/section[3]/div/div[2]/a[6]");//�����Ʒ����
		webtest.click("class=btn_submit_buy");//�����������
//		webtest.type("name=message","���տ���");
		webtest.type("name=message",message);
		webtest.click("xpath=/html/body/div[3]/section[2]/form/label/span");//ȷ������ �ύ����
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("订单已提交"));
		//�����ύ�ɹ�
	}
	
	//ͨ��
	@Test
	//翻页
	public void test34() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[1]/ul/li[4]/div[1]/a[2]");//���Ů����ť
		webtest.click("xpath=/html/body/div[3]/div/section[2]/section/section/div/ul/li[3]/a");//�ڶ�ҳ
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("女包"));
	}
	
	//ͨ�� ����
	@Test
	//购物指南
	public void test35() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/footer/section[2]/div[1]/dl[1]/dt/p[2]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("购物指南"));
	}
	
	@Test
	//支付帮助
	public void test36() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/footer/section[2]/div[1]/dl[2]/dt/p[2]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("支付帮助"));
	}
	
	@Test
	//配送服务
	public void test37() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("/html/body/footer/section[2]/div[1]/dl[3]/dt/p[2]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("配送帮助"));
	}
	
	@Test
	//售后服务
	public void test38() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/footer/section[2]/div[1]/dl[4]/dt/p[2]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("售后服务"));
	}
	
	@Test
	//查看帮助信息
	public void test39() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/footer/section[2]/div[1]/dl[5]/dt/p[2]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("帮助信息"));
	}
	
	
	
	@Test
	//查看我的订单
	public void test40() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/div[2]/div/ul/li[2]/a");//��������
		webtest.click("xpath=/html/body/div[3]/section[2]/div/aside/nav[1]/ul/li[1]/a");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("订单编号"));
	}
	
	@Test
	//查看商城公告
	public void test43() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/div[3]/div/div[1]/h4/a");//����
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("公告列表"));
	}
	
	@Test
	//查看商城最新资讯
	public void test44() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/div[3]/div/div[2]/h4/a");//��ѯ
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("最新资讯"));
	}
	
	@Test
	//查看全部商品分类
	public void test45() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/div[3]/div/ul/li[1]/a");
//		webtest.click("class=fa fa-sitemap");//����ͼͼ��
		Thread.sleep(3000);
//		Assert.assertTrue(webtest.ifContains("���õ���"));
		Assert.assertTrue(webtest.ifContains("所有商品分类"));
	}
	
	@Test
	//查看商家列表
	public void test46() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/div[3]/div/ul/li[2]/a");//����ͼ��
//		webtest.click("class=fa fa-users");//����ͼ��
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("VIP商家"));
//		Assert.assertTrue(webtest.ifContains("�̼��б�"));
	}
	
	@Test
	//查看商品品牌
	public void test47() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
//		webtest.click("class=fa fa-star");//����ͼ��
		webtest.click("xpath=/html/body/div[3]/div/ul/li[3]/a");//����ͼ��
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("推荐品牌"));
//		Assert.assertTrue(webtest.ifContains("�Ƽ�Ʒ��"));
	}
	
	@Test
	//特价活动
	public void test48() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
//		webtest.click("class=fa fa-clock-o");//�ӱ�ͼ��
		webtest.click("xpath=/html/body/div[3]/div/ul/li[4]/a");//钟表
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("首页"));
	}
	
	@Test
	//查看标签
	public void test49() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
//		webtest.click("class=fa fa-tags");//��ͷͼ��
		webtest.click("xpath=/html/body/div[3]/div/ul/li[6]/a");//箭头标签
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("进口牛奶"));
//		Assert.assertTrue(webtest.ifContains("��ǩ"));
	}
	
	
	@Test
	//查看产品官网
	public void test50() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//��ת����ҳ
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[2]/a/span");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("开源商城系统"));
	}	
	
}
