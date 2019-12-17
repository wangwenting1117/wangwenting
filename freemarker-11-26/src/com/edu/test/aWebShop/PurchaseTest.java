package com.edu.test.aWebShop;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.core.ExcelDataProvider;

public class PurchaseTest extends BaseTest{
	
//	WebDriver driver = new FirefoxDriver();
	
	@DataProvider(name="testtxt3")
	public Object[][] createData3() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//LoginData.xlsx","Sheet4");
	}
	
	@DataProvider(name="testtxt5")
	public Object[][] createData5() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//BuyNumberData.xlsx","Sheet1");
	}
	
	@DataProvider(name="testtxt7")
	public Object[][] createData7() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//AddressData.xlsx","Sheet1");
	}
	
	@DataProvider(name="testtxt8")
	public Object[][] createData8() throws IOException {
		ExcelDataProvider data = new ExcelDataProvider();
	 return data.getTestDataByExcel("E://ExcelData//AddressData.xlsx","Sheet2");
	}
	
	
	@Test(dataProvider="testtxt3")
	//登录成功
	public void test17(String username,String password) throws InterruptedException{
		webtest.open("http://www.iwebshop.com:2034/index.php");
		Thread.sleep(5000);
		webtest.click("xpath=/html/body/header/div[1]/div/div[2]/div/a[1]");
//		webtest.type("name=login_info","baishikele");
//		webtest.type("name=password","BaiShiKeLe*");
		webtest.type("name=login_info",username);
		webtest.type("name=password",password);
		webtest.click("class=input_submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("baishikele"));
		//��¼�ɹ� ҳ����ת
	}
	
	//购买商品数大于100
	@Test(dataProvider="testtxt5")
	public void test21(String number) throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//��ҳ
		webtest.click("xpath=/html/body/div[3]/section[3]/div/div[2]/a[2]");//��ҳ�е�һ����Ʒͼ��
//		webtest.type("id=buyNums","20");
		webtest.type("id=buyNums",number);
		webtest.click("class=btn_submit_buy");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("填写核对订单信息"));
	}
		
		//22 23 ͨ��
	//购买商品数小于1
	@Test
	public void test22() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//��ҳ
		webtest.click("xpath=/html/body/div[3]/section[3]/div/div[2]/a[2]");//��ҳ�е�һ����Ʒͼ��
		webtest.click("id=buyReduceButton");//����
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("此商品购买数量不得少于1"));
	}
		
	@Test
	//购买正常数量的商品
	public void test23() throws InterruptedException{
		webtest.click("class=aui_state_highlight");//���������ߵ�ȷ����ť
//		webtest.click("class=add");
		webtest.click("id=buyAddButton");
		webtest.click("class=btn_submit_buy");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("填写核对订单信息"));
		//�ɹ���ת������ҳ��
	}
	
	
	@Test(dataProvider="testtxt7")
	//添加地址ַ
	public void test25(String name,String address,String mobile) throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//��ת����ҳ
		webtest.click("xpath=/html/body/div[2]/div/ul/li[2]/a");//��������
		webtest.click("xpath=/html/body/div[3]/section[2]/div/aside/nav[5]/ul/li[1]/a");//��ַ����
//		webtest.click("class=fa fa-map-marker");//����µ�ַ
//		webtest.click("xpath=/html/body/div[3]/section[2]/div/section/div");//����µ�ַ
		webtest.click("class=new_address_btn");//����µ�ַ
//		webtest.type("name=accept_name","�װ�");
		webtest.enterFrame(0);//frame("OpenaddressWindow");
		webtest.type("xpath=/html/body/form/section/ul/li[1]/input",name);
//		webtest.type("name=accept_name",name);
//		webtest.click("name=province");
		webtest.click("xpath=/html/body/form/section/ul/li[2]/select[1]");
		webtest.click("xpath=/html/body/form/section/ul/li[2]/select[1]/option[2]");//ʡ��
//		webtest.click("name=city");
		webtest.click("xpath=/html/body/form/section/ul/li[2]/select[2]");
		webtest.click("xpath=/html/body/form/section/ul/li[2]/select[2]/option[2]");//����
//		webtest.click("name=area");
		webtest.click("xpath=/html/body/form/section/ul/li[2]/select[3]");
		webtest.click("xpath=/html/body/form/section/ul/li[2]/select[3]/option[16]");//��
//		webtest.type("name=address","1��");
//		webtest.type("name=address",address);
		webtest.type("xpath=/html/body/form/section/ul/li[3]/input",address);
		webtest.type("xpath=/html/body/form/section/ul/li[4]/input",mobile);
		webtest.leaveFrame();
		webtest.click("xpath=/html/body/div[1]/div/table/tbody/tr[2]/td[2]/div/table/tbody/tr[3]/td/div/button[1]");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("小白"));
		//��ӳɹ�  15933963222
	}
	
	@Test
	//删除地址ַ
	public void test26() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//首页
		webtest.click("xpath=/html/body/div[2]/div/ul/li[2]/a");//个人中心
		webtest.click("xpath=/html/body/div[3]/section[2]/div/aside/nav[5]/ul/li[1]/a");//地址管理
		webtest.click("xpath=/html/body/div[3]/section[2]/div/section/section/table/tbody/tr[2]/td[6]/a[2]");//删除按钮
		webtest.click("class=aui_state_highlight");//确认删除地址
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("地址管理"));
		//删除地址成功
	}
	
	@Test
	//提交订单
	public void test27() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//��ҳ
		webtest.click("xpath=/html/body/div[3]/section[3]/div/div[2]/a[2]");//��ҳ�е�һ����Ʒͼ��
		webtest.click("id=buyNowButton");
//		webtest.click("class=btn_submit_buy");//��������
		webtest.click("xpath=/html/body/div[3]/section[2]/form/label/span");//ȷ������ �ύ����
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("订单已提交"));
		//��ʾ�������ύ
		
	}
	
	@Test
	//修改地址ַ
	public void test28() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//��ת����ҳ
		webtest.click("xpath=/html/body/div[2]/div/ul/li[2]/a");//��������
		webtest.click("xpath=/html/body/div[3]/section[2]/div/aside/nav[5]/ul/li[1]/a");//��ַ����
		webtest.click("xpath=/html/body/div[3]/section[2]/div/section/section/table/tbody/tr[1]/td[6]/a[1]");//�༭��ַ
		webtest.enterFrame("OpenaddressWindow");
		webtest.click("name=area");
		webtest.click("xpath=/html/body/form/section/ul/li[2]/select[3]/option[9]");//����ѡ������
		webtest.leaveFrame();
		webtest.click("class=aui_state_highlight");//�ύ
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("海淀区"));
		//�༭�ɹ� ������
	}
	
	@Test(dataProvider="testtxt8")
	//编辑个人资料
	public void test29(String name,String address,String mobile) throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//首页
		webtest.click("xpath=/html/body/div[2]/div/ul/li[2]/a");//个人中心
		webtest.click("xpath=/html/body/div[3]/section[2]/div/aside/nav[5]/ul/li[2]/a");//个人资料
//		webtest.type("name=true_name","�׾�ͤ");
//		webtest.type("xpath=/html/body/form/section/ul/li[1]/input",name);
		webtest.type("name=true_name",name);
		webtest.click("name=province");
		webtest.click("xpath=/html/body/div[3]/section[2]/div/section/section/form/dl[6]/dd/select[1]/option[2]");
		webtest.click("name=city");
		webtest.click("xpath=/html/body/div[3]/section[2]/div/section/section/form/dl[6]/dd/select[2]/option[2]");
		webtest.click("name=area");
		webtest.click("xpath=/html/body/div[3]/section[2]/div/section/section/form/dl[6]/dd/select[3]/option[16]");
		webtest.type("name=contact_addr",address);
		webtest.type("name=mobile",mobile);
		webtest.click("class=input_submit");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("白敬亭"));
		//�޸ĳɹ�	
	}
	
	//31 32 33ͨ��
	@Test
	//加入购物车
	public void test31() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//首页
		webtest.click("xpath=/html/body/div[3]/section[3]/div/div[2]/a[4]");//商品链接
		webtest.click("id=joinCarButton");//加入购物车ﳵ
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("加入购物车"));
		//���빺�ﳵ�ɹ�
	}
		
	@Test
	//查看购物车ﳵ
	public void test32() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//首页
		webtest.click("class=header_cart");//购物车按钮
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("查看购物车"));
	}
		
	@Test
	//清空购物车ﳵ
	public void test33() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a/span");//首页
		webtest.click("class=header_cart");//购物车
		webtest.click("class=clear_cart_btn");//清空按钮ﳵ
		webtest.click("class=aui_state_highlight");//确认清空ﳵ
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("清空购物车"));
	}
	//41 42ͨ��
	@Test
	//收藏商品
	public void test41() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//首页
		webtest.click("xpath=/html/body/div[3]/section[3]/div/div[2]/a[5]");//��ҳ�е�һ����Ʒͼ��
		webtest.click("xpath=/html/body/div[3]/div/section[2]/section[2]/ul/li[4]/span[2]");//����ղ�
//		webtest.click("class=favorite");
		webtest.click("xpath=/html/body/div[3]/div/section[3]/section/div[1]/label[2]");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("收藏此商品"));
	}
	
	@Test
	//查看收藏的商品
	public void test42() throws InterruptedException{
		webtest.click("xpath=/html/body/header/div[2]/div/div/div[2]/ul/li[1]/a");//首页
		webtest.click("xpath=/html/body/div[2]/div/ul/li[2]/a");//个人中心
		webtest.click("xpath=/html/body/div[3]/section[2]/div/aside/nav[3]/ul/li[2]/a");//收藏夹
		Thread.sleep(3000);
		Assert.assertTrue(webtest.ifContains("收藏夹"));
	}
	
}
