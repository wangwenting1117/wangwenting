package com.edu.test.bzhangpengyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.security.Provider;

import org.apache.logging.log4j.core.net.ssl.PasswordProvider;
import org.apache.logging.log4j.core.util.Assert;
import org.apache.xmlbeans.impl.tool.PrettyPrinter;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.test.bzhangpengyu.BaseTest;
import com.edu.core.WebDriverEngine;
//import com.webtest.zl_shop.Admin;
import com.edu.core.ExcelDataProvider;

public class Login extends BaseTest {
	@BeforeMethod
	public void login() throws InterruptedException {

		// ����ҳ
		webtest.open("http://localhost:8081/wp-login.php");

		Thread.sleep(3000);
		// ��¼
		webtest.click("link=Log in");
		webtest.typeAndClear("name=log", "baishikele@");
		webtest.typeAndClear("name=pwd", "BaiShiKeLe*");
		webtest.click("id=wp-submit");
		System.out.println("login");
	}

	/*@AfterMethod
	public void log_out() throws InterruptedException {
		Thread.sleep(5000);
		webtest.click("xpath=//*[@id=\"wp-admin-bar-site-name\"]/a");
//		webtest.mouseoverElement("xpath=//a[contains(text(),'Howdy')]");
		webtest.click("link=Log out");
		System.out.println("Out");
	}*/

	// ����1 ��������ʵ�ֵ�¼
	@DataProvider(name="login")
		public Object[][] createData() throws IOException{	
		ExcelDataProvider provider=new ExcelDataProvider();
		return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet1");
		}
	
	@Test(dataProvider="login" )
	public  void test1(String log,String pwd) {
		
		webtest.click("link=Log in");
		webtest.type("name=log",log);
		webtest.type("name=pwd", pwd);
		webtest.click("id=wp-submit");
	    assertTrue(webtest.ifContains("Appearance"));
		
	}
	
	// ����2 һ��ģ�顰appearance"��ģ���������
	@Test
	public void test2() {
		webtest.click("link=Appearance");
		assertTrue(webtest.ifContains("Please update now"));
		
		webtest.click("link=Themes");
		assertTrue(webtest.ifContains("please attempt the update again now"));
		
		webtest.click("link=Customize");
		assertTrue(webtest.ifContains("Just another WordPress site"));
		webtest.click("class=customize-controls-close");
		
		
		webtest.click("link=Widgets");
		assertTrue(webtest.ifContains("This will clear all items from the inactive widgets list."));
		
		webtest.click("link=Menus");
		assertTrue(webtest.ifContains("create a new menu"));
		
		webtest.click("link=Header");
		assertTrue(webtest.ifContains("Current header"));
		webtest.click("class=customize-controls-close");
		
		webtest.click("link=Background");
		assertTrue(webtest.ifContains("Background Image"));
		webtest.click("class=customize-controls-close");
		
		webtest.click("link=Editor");
		assertTrue(webtest.ifContains("Selected file content"));
		webtest.click("class=customize-controls-close");
		

		
	}  

	// ����3 ���� ģ�顰Themes"��ģ���������
		@Test
		public void test3() {
			webtest.click("link=Appearance");
			assertTrue(webtest.ifContains("Please update now"));
			
			webtest.click("link=Add New");
			assertTrue(webtest.ifContains("Upload Theme"));
			
			webtest.click("link=Featured");
			assertTrue(webtest.ifContains("An unexpected error occurred"));
			
			webtest.click("link=Popular");
			assertTrue(webtest.ifContains("Twenty Twenty"));
			
			webtest.click("link=Latest");
			assertTrue(webtest.ifContains("Twenty Twenty"));

			webtest.click("link=Favorites");
			assertTrue(webtest.ifContains("marked themes as favorites"));
			
			
		}
	// ����4 Site Title��������
	@DataProvider(name="SiteTitle")
	public Object[][] createData2() throws IOException{	
	  ExcelDataProvider provider=new ExcelDataProvider();
	  return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet2");
	}

	@Test(dataProvider="SiteTitle" )
    public void test4(String title) throws InterruptedException {
	
      webtest.click("link=Appearance");
	  webtest.click("link=Customize");
	  webtest.click("xpath=/html/body/div[1]/form/div[3]/div[2]/div[2]/ul[1]/li[3]/h3");
	  webtest.click("id=_customize-input-blogname");
	  Thread.sleep(3000);
	  webtest.typeAndClear("id=_customize-input-blogname",title);
	  webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
	  webtest.alertAccept();
}
//	 ����5 Site Title��������
		@DataProvider(name="tagline")
		public Object[][] createData3() throws IOException{	
		  ExcelDataProvider provider=new ExcelDataProvider();
		  return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet3");
		}

	  	
		@Test(dataProvider="tagline" )
	    public void test5(String tagline) throws InterruptedException {
		
	      webtest.click("link=Appearance");
		  webtest.click("link=Customize");
		  webtest.click("xpath=/html/body/div[1]/form/div[3]/div[2]/div[2]/ul[1]/li[3]/h3");
		  webtest.click("id=_customize-input-blogname");
		  Thread.sleep(3000);
		  webtest.typeAndClear("id=_customize-input-blogdescription",tagline);
//	      assertTrue(webtest.ifContains(title));
		  webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
		  webtest.alertAccept();
	}
	// ����6 new mnue ��������
		@DataProvider(name="menus")
		public Object[][] createData4() throws IOException{	
		  ExcelDataProvider provider=new ExcelDataProvider();
		  return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet4");
		}

	  	
		@Test(dataProvider="menus" )
	    public void test6(String menus ) throws InterruptedException {		
		  webtest.click("xpath=//*[@id=\"menu-appearance\"]/a/div[3]");
		  webtest.click("xpath=//*[@id=\"menu-appearance\"]/ul/li[3]/a");
		  webtest.click("xpath=//*[@id=\"accordion-panel-nav_menus\"]/h3");
		  webtest.click("xpath=//*[@id=\"accordion-section-add_menu\"]/h3/button");

		  Thread.sleep(3000);
		  webtest.type("xpath=//*[@id=\"customize-control-add_menu-name\"]/label/input", menus);
		  webtest.click("xpath=//*[@id=\"customize-nav-menu-control-location-24\"]");
		  webtest.click("xpath=//*[@id=\"customize-nav-menu-control-location-25\"]");
		  webtest.click("xpath=//*[@id=\"customize-new-menu-submit\"]");
		  webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");
		  webtest.alertAccept();
	}

	//����7 Widgets��ģ���������
	@Test
	public void test7() {
		webtest.click("link=Appearance");
		webtest.click("link=Widgets");
		webtest.click("xpath=//*[@id=\"widget-1_archives-__i__\"]/div[1]/div[2]/h3");
		webtest.click("link=Cancel");
	}
	//����8 Widgets��ģ���������
	@Test
	public void test8() {
		webtest.click("link=Appearance");
		webtest.click("link=Widgets");
		webtest.click("xpath=//*[@id=\"widget-1_archives-__i__\"]/div[1]/div[2]/h3");
		webtest.click("link=Add Widget");
	}
	
	//����9 Widgets��ģ���������
		@Test
		public void test9() {
			webtest.click("link=Appearance");
			webtest.click("link=Widgets");
			webtest.click("xpath=//*[@id=\"widget-2_media_audio-__i__\"]/div[1]/div[2]/h3");
			webtest.click("link=Cancel");
		}
		
	//����10 Widgets��ģ���������
				@Test
				public void test10() {
					webtest.click("link=Appearance");
					webtest.click("link=Widgets");
					webtest.click("xpath=//*[@id=\"widget-2_media_audio-__i__\"]/div[1]/div[2]/h3");
					webtest.click("link=Add Widget");
				}
	//����11 Widgets��ģ���������
				@Test
				public void test11() {
					webtest.click("link=Appearance");
					webtest.click("link=Widgets");
					webtest.click("xpath=//*[@id=\"widget-3_calendar-__i__\"]/div[1]/div[2]/h3");
					webtest.click("link=Add Widget");
				}	
	//����12 Widgets��ģ���������
				@Test
				public void test12() {
					webtest.click("link=Appearance");
					webtest.click("link=Widgets");
					webtest.click("xpath=//*[@id=\\\"widget-3_calendar-__i__\\\"]/div[1]/div[2]/h3");
					webtest.click("link=Cancel");
				}
	//����13 Widgets��ģ���������
				@Test
				public void test13() {
					webtest.click("link=Appearance");
					webtest.click("link=Widgets");
					webtest.click("xpath=//*[@id=\"widget-3_calendar-__i__\"]/div[1]/div[2]/h3");
					webtest.click("link=Add Widget");
				}	
	//����14 Widgets��ģ���������
				@Test
				public void test14() {
					webtest.click("link=Appearance");
					webtest.click("link=Widgets");
					webtest.click("xpath=//*[@id=\"widget-12_recent-posts-__i__\"]/div[1]/div[2]/h3");
					webtest.click("link=Cancel");
				}

//	����15 ��������BackgroundColor
    @DataProvider(name="Backgroundcolor")
	public Object[][] createData5() throws IOException{	
	  ExcelDataProvider provider=new ExcelDataProvider();
	  return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet5");
	}

  	

    @Test(dataProvider="Backgroundcolor" )
    public void test15(String Backgroundcolor ) throws InterruptedException {		
    	webtest.click("link=Appearance");
    	webtest.click("link=Customize");
	  webtest.click("xpath=//*[@id=\"accordion-section-colors\"]/h3");
	  webtest.click("xpath=//*[@id=\"customize-control-background_color\"]/div[2]/div/button/span");
	  webtest.typeAndClear("xpath=//*[@id=\"customize-control-background_color\"]/div[2]/div/span/label/input", Backgroundcolor);
	  webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");
//	  assertTrue(webtest.ifContains("Appearance"));
	  webtest.alertAccept();
}

	// ����16 ��������Header and Sidebar Background
    @DataProvider(name="Header and Sidebar Background")
	public Object[][] createData6() throws IOException{	
	  ExcelDataProvider provider=new ExcelDataProvider();
	  return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet6");
	}

  	

    @Test(dataProvider="Header and Sidebar Background" )
    public void test16(String headercolor ) throws InterruptedException {		
    	webtest.click("link=Appearance");
    	webtest.click("link=Customize");
	    webtest.click("xpath=//*[@id=\"accordion-section-colors\"]/h3");
	 
	    webtest.click("xpath=//*[@id=\"customize-control-header_background_color\"]/div[2]/div/button/span");
	    webtest.typeAndClear("xpath=//*[@id=\"customize-control-header_background_color\"]/div[2]/div/span/label/input", headercolor);
	    System.out.println(headercolor);
	    webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");
	    webtest.alertAccept();
}

	// ����17 ��������Header and Sidebar Text
    @DataProvider(name="Header and SidebarText")
	public Object[][] createData7() throws IOException{	
	  ExcelDataProvider provider=new ExcelDataProvider();
	  return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet7");
	}

  	

    @Test(dataProvider="Header and SidebarText" )
    public void test17(String SidebarText ) throws InterruptedException {		
      webtest.click("link=Appearance");
      webtest.click("link=Customize");
	  webtest.click("xpath=//*[@id=\"accordion-section-colors\"]/h3");
	  webtest.click("xpath=//*[@id=\"customize-control-sidebar_textcolor\"]/div[2]/div/button/span");
	  webtest.typeAndClear("xpath=//*[@id=\"customize-control-sidebar_textcolor\"]/div[2]/div/span/label/input", SidebarText);
	  webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");
	  webtest.alertAccept();
}

	// ����18 Customizing Widget Area new��������
	@Test
	public void test18() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
		webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
		webtest.click("xpath=//*[@id=\"widget-tpl-archives-5\"]");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
		webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
		webtest.alertAccept();

	}

	// ����19Customizing Widget Area new��������
	@Test
	public void test19() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
		webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
		webtest.click("xpath=//*[@id=\"widget-2_media_audio-__i__\"]/div[3]");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
		webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
		webtest.alertAccept();

	}

	// ����20Customizing Widget Area new��������
	@Test
	public void test20() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
		webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
		webtest.click("xpath=//*[@id=\"widget-4_categories-__i__\"]/div[3]");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
		webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
		webtest.alertAccept();

	}

	// ����21Customizing Widget Area new��������
	@Test
	public void test21() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
		webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
		webtest.click("xpath=//*[@id=\"widget-4_categories-__i__\"]/div[3]");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
		webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
		webtest.alertAccept();

	}
	// ����22Customizing Widget Area new��������
		@Test
		public void test22() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-5_custom_html-__i__\"]/div[3]");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
		// ����23Customizing Widget Area new��������
		@Test
		public void test23() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-5_custom_html-__i__\"]/div[3]");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
//		 ����24Customizing Widget Area new��������
		@Test
		public void test24() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-6_media_gallery-__i__\"]/div[1]/div[2]/h3");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
//		 ����25Customizing Widget Area new��������
		@Test
		public void test25() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-8_meta-__i__\"]/div[1]/div[2]/h3");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
		// ����26Customizing Widget Area new��������
		@Test
		public void test26() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-9_nav_menu-__i__\"]/div[1]/div[2]/h3");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
//		 ����27Customizing Widget Area new��������
		@Test
		public void test27() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-tpl-pages-2\"]");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
		
		// ����28Customizing Widget Area new��������
		@Test
		public void test28() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-11_recent-comments-__i__\"]/div[1]/div[2]/h3");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
		
		// ����29Customizing Widget Area new��������
		@Test
		public void test29() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-12_recent-posts-__i__\"]/div[1]/div[2]/h3");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
		
		// ����30Customizing Widget Area new��������
		@Test
		public void test30() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-panel-widgets\"]/h3");
			webtest.click("xpath=//*[@id=\"customize-control-sidebars_widgets-sidebar-1\"]/button[1]");
			webtest.click("xpath=//*[@id=\"widget-13_rss-__i__\"]/div[1]/div[2]/h3");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-sidebar-widgets-sidebar-1\"]/li[1]/div[1]/button");
			webtest.click("xpath=/html/body/div[1]/form/div[1]/a");
			webtest.alertAccept();

		}
	
//	 ����31Background Image  Preset��������
	@Test
	public void test31() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-section-background_image\"]/h3");
		webtest.click("xpath=//*[@id=\"_customize-input-background_preset\"]");
		webtest.click("link=Default");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-background_image\"]/li[1]/div/button");
		webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");

	}

	// ����32Background Image  Preset��������
	@Test
	public void test32() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-section-background_image\"]/h3");
		webtest.click("id=_customize-input-background_preset");
		webtest.click("link=Fill Screen");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-background_image\"]/li[1]/div/button");
		webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");

	}
	
	// ����33Background Image  Preset��������
	@Test
	public void test33() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-section-background_image\"]/h3");
		webtest.click("id=_customize-input-background_preset");
		webtest.click("link=Fit to Screen");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-background_image\"]/li[1]/div/button");
		webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");

	}
	// ����34Background Image  Preset��������
		@Test
		public void test34() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-section-background_image\"]/h3");
			webtest.click("id=_customize-input-background_preset");
			webtest.click("link=Repeat");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-background_image\"]/li[1]/div/button");
			webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");


		}
		// ����35Background Image  Preset��������
		@Test
		public void test35() {
			webtest.click("link=Appearance");
			webtest.click("link=Customize");
			webtest.click("xpath=//*[@id=\"accordion-section-background_image\"]/h3");
			webtest.click("id=_customize-input-background_preset");
			webtest.click("link=Custom");
			webtest.click("xpath=//*[@id=\"sub-accordion-section-background_image\"]/li[1]/div/button");
			webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");

		}
	
//����36  search �������� ����
	
	@DataProvider(name="search")
	public Object[][] createData8() throws IOException{	
	ExcelDataProvider provider=new ExcelDataProvider();
	return provider.getTestDataByExcel("E://ExcelData//data.xlsx","sheet8");
	}

	@Test(dataProvider="search")
	public void test36(String index) {
		webtest.click("link=Appearance");
		webtest.type("id=wp-filter-search-input",index);
		assertTrue(webtest.ifContains(index));

	}
	
	// ����37Background Image  Preset��������
	@Test
	public void test37() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-section-static_front_page\"]/h3");
		webtest.click("xpath=//*[@id=\"_customize-input-show_on_front-radio-posts\"]");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-static_front_page\"]/li[1]/div[1]/button");
		webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");

	}

	
	// ����38Background Image  Preset��������

	public void test38() {
		webtest.click("link=Appearance");
		webtest.click("link=Customize");
		webtest.click("xpath=//*[@id=\"accordion-section-static_front_page\"]/h3");
		webtest.click("xpath=//*[@id=\"_customize-input-show_on_front-radio-page\"]");
		webtest.click("xpath=//*[@id=\"sub-accordion-section-static_front_page\"]/li[1]/div[1]/button");
		webtest.click("xpath=//*[@id=\"customize-header-actions\"]/a");

	}
	
}
