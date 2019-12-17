package com.edu.test.wzhangxiao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.edu.utils.ReadProperties;

/*21*/

public class DiscussionTest extends DataHelper {
	public WebDriver driver = null;

	// 点击到Discussion选项
	@BeforeTest
	public void open() throws Exception {
		System.setProperty("webdriver.gecko.driver", ReadProperties.getPropertyValue("gecko_driver"));
		System.setProperty("webdriver.firefox.bin", ReadProperties.getPropertyValue("firefox_path"));
		driver = new FirefoxDriver();
		driver.get("http://localhost:8081/wp-login.php");
		driver.findElement(By.id("user_login")).sendKeys("baishikele@");
		driver.findElement(By.id("user_pass")).sendKeys("BaiShiKeLe*");
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
	}

	/****
	 * @throws Exception
	 **********************************************************/
	// 测试Default article settings
	@Test
	public void testArticleSetting1() throws Exception {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("default_pingback_flag"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/****
	 * @throws Exception
	 **********************************************************/
	// 测试Default article settings
	@Test
	public void testArticleSetting2() throws Exception {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("default_ping_status"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/****
	 * @throws Exception
	 **********************************************************/
	// 测试Default article settings
	@Test
	public void testArticleSetting3() throws Exception {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("default_comment_status"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testOther1(String i) {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("close_comments_for_old_posts"));
		while (check.isSelected() == false) {
			check.click();
		}
		driver.findElement(By.name("close_comments_days_old")).clear();
		driver.findElement(By.name("close_comments_days_old")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.name("close_comments_days_old")).getText();
		Assert.assertEquals(text, i);
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testOther2(String i) {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("thread_comments"));
		while (check.isSelected() == false) {
			check.click();
		}
		WebElement list = driver.findElement(By.id("thread_comments_depth"));
		Select select = new Select(list);
		select.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testOther3(String i) {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("page_comments"));
		while (check.isSelected() == false) {
			check.click();
		}
		driver.findElement(By.id("comments_per_page")).clear();
		driver.findElement(By.id("comments_per_page")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.name("comments_per_page")).getText();
		Assert.assertEquals(text, i);
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testOther4(String i) {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("page_comments"));
		while (check.isSelected() == false) {
			check.click();
		}
		WebElement list = driver.findElement(By.id("default_comments_page"));
		Select lSelect = new Select(list);
		lSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testOther5(String i) {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement list = driver.findElement(By.id("comment_order"));
		Select lSelect = new Select(list);
		lSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test
	public void testOther6() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("require_name_email"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test
	public void testOther7() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("comment_registration"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Other comment settings
	@Test
	public void testOther8() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("show_comments_cookies_opt_in"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Email me whenever
	@Test
	public void testEmailMe1() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("comments_notify"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Email me whenever
	@Test
	public void testEmailMe2() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("moderation_notify"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Before a comment appears
	@Test
	public void testAppears1() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("comment_moderation"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Before a comment appears
	@Test
	public void testAppears2() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("comment_whitelist"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Comment Moderation
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testModeration1(String i) {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement list = driver.findElement(By.id("comment_max_links"));
		Select select = new Select(list);
		select.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***********************************************************************************************/
	// 测试Comment Moderation
	@Test(dataProvider = "getText", dataProviderClass = DataHelper.class)
	public void testModeration2(String text) {
		driver.findElement(By.linkText("Discussion")).click();
		driver.findElement(By.id("moderation_keys")).clear();
		driver.findElement(By.id("moderation_keys")).sendKeys(text);
		driver.findElement(By.id("submit")).click();
		String actual = driver.findElement(By.id("moderation_keys")).getAttribute("value");
		Assert.assertEquals(actual, text);
	}

	/***********************************************************************************************/
	// 测试Comment Blacklist
	@Test(dataProvider = "getText", dataProviderClass = DataHelper.class)
	public void testBlacklist(String text) {
		driver.findElement(By.linkText("Discussion")).click();
		driver.findElement(By.id("blacklist_keys")).clear();
		driver.findElement(By.id("blacklist_keys")).sendKeys(text);
		driver.findElement(By.id("submit")).click();
		String actual = driver.findElement(By.id("blacklist_keys")).getAttribute("value");
		Assert.assertEquals(actual, text);
	}

	/***********************************************************************************************/
	// 测试Avatar Display
	@Test
	public void testAvatarDisplay() {
		driver.findElement(By.linkText("Discussion")).click();
		WebElement check = driver.findElement(By.id("show_avatars"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/***
	 * @throws Exception
	 *********************************************************************************************/
	// 测试Maximum Rating
	@Test
	public void testRating() throws Exception {
		driver.findElement(By.linkText("Discussion")).click();
		List<WebElement> list = driver.findElements(By.name("avatar_rating"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			Thread.sleep(3000);
			list = driver.findElements(By.name("avatar_rating"));
			while (list.get(i).isSelected() == false) {
				list.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}

	/***
	 * @throws Exception
	 **************************************************************************************/
	// 测试Default Avatar
	@Test
	public void testAvatar() throws Exception {
		driver.findElement(By.linkText("Discussion")).click();
		List<WebElement> list = driver.findElements(By.name("avatar_default"));
		List<WebElement> img = driver.findElements(By.className("avatar avatar-32 photo avatar-default"));
		System.out.println(list.size());
		System.out.println(img.size());
		for (int j = 0; j < list.size(); j++) {
			Thread.sleep(3000);
			list = driver.findElements(By.name("avatar_default"));
			while (list.get(j).isSelected() == false) {
				list.get(j).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}
	/**
	 * @throws Exception
	 *************************************************************************************/
	// 测试Site Title
	@Test(dataProvider = "getSiteTitle", dataProviderClass = DataHelper.class)
	public void testSiteTitle(String blogname) throws Exception {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(By.id("blogname")).clear();
		driver.findElement(By.id("blogname")).sendKeys(blogname);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.id("blogname")).getAttribute("value");
		System.out.println(text);
		Assert.assertEquals(text, blogname);
	}

	/****************************************************************************************/
	// 测试Tagline
	@Test(dataProvider = "getTagline", dataProviderClass = DataHelper.class)
	public void testTagline(String blogdescription) {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(By.id("blogdescription")).clear();
		driver.findElement(By.id("blogdescription")).sendKeys(blogdescription);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.id("blogdescription")).getAttribute("value");
		Assert.assertEquals(text, blogdescription);
	}

	/**************************************************************************************/
	// 测试EmailAddress
	@Test(dataProvider = "getEmailAddress", dataProviderClass = DataHelper.class)
	public void testEmailAddress(String new_admin_email) {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(By.id("new_admin_email")).clear();
		driver.findElement(By.id("new_admin_email")).sendKeys(new_admin_email);
		driver.findElement(By.id("submit")).click();
		String text = driver.findElement(By.id("new_admin_email")).getAttribute("value");
		Assert.assertEquals(text, new_admin_email);
	}

	/******************************************************************************************/
	// 测试Membership
	@Test
	public void testMembership() {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(By.id("users_can_register")).click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/******************************************************************************************/
	// 测试New User Default Role(0-4)
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testNewUserDefaultRole(String i) {
		driver.findElement(By.linkText("General")).click();
		WebElement role = driver.findElement(By.id("default_role"));
		Select r = new Select(role);
		r.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/**********************************************************************************************/
	// 测试Site Language
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testSiteLanguage(String i) {
		driver.findElement(By.linkText("General")).click();
		WebElement language = driver.findElement(By.id("WPLANG"));
		Select l = new Select(language);
		l.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/**********************************************************************************************/
	// 测试Timezone
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testTimezone(String i) {
		driver.findElement(By.linkText("General")).click();
		WebElement zone = driver.findElement(By.id("timezone_string"));
		Select z = new Select(zone);
		z.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/**
	 * @throws Exception
	 *********************************************************************************************/
	// 测试Date Format
	@Test
	public void testDateFormat() throws Exception {
		driver.findElement(By.linkText("General")).click();
		List<WebElement> radios = driver.findElements(By.name("date_format"));
		System.out.println(radios.size());
		for (int i = 0; i < radios.size() - 1; i++) {
			Thread.sleep(3000);
			radios = driver.findElements(By.name("date_format"));
			while (radios.get(i).isSelected() == false) {
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}

	/****************************************************************************************************************/
	// 测试Date Format中的自定义日期格式
	@Test(dataProvider = "getDate", dataProviderClass = DataHelper.class)
	public void testDateCustom(String date) {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(By.id("date_format_custom_radio")).click();
		driver.findElement(By.id("date_format_custom")).clear();
		driver.findElement(By.id("date_format_custom")).sendKeys(date);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/********************************************************************************************************************/
	// 测试Time Format
	@Test
	public void testTimeFormat() throws Exception {
		driver.findElement(By.linkText("General")).click();
		List<WebElement> radios = driver.findElements(By.name("time_format"));
		System.out.println(radios.size());
		for (int i = 0; i < radios.size() - 1; i++) {
			Thread.sleep(3000);
			radios = driver.findElements(By.name("time_format"));
			while (radios.get(i).isSelected() == false) {
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}

	/***************************************************************************************************************/
	// 测试Time Format中的自定义时间格式
	@Test(dataProvider = "getTime", dataProviderClass = DataHelper.class)
	public void testTimeCustom(String time) {
		driver.findElement(By.linkText("General")).click();
		driver.findElement(By.id("time_format_custom_radio")).click();
		driver.findElement(By.id("time_format_custom")).clear();
		driver.findElement(By.id("time_format_custom")).sendKeys(time);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}

	/*****************************************************************************************************************/
	// 测试Week Starts On
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testWeek(String i) {
		driver.findElement(By.linkText("General")).click();
		WebElement week = driver.findElement(By.id("start_of_week"));
		Select wSelect = new Select(week);
		wSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	/*********************************************************************************************************************/
	//测试Thumbnail size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testThumbnailSize1(String i){
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[12]/ul/li[6]/a")).click();
		WebElement num1 = driver.findElement(By.id("thumbnail_size_w"));
		WebElement check = driver.findElement(By.id("thumbnail_crop"));
		num1.clear();
		num1.sendKeys(i);
		check.click();
		driver.findElement(By.id("submit")).click();
		String text1 = num1.getText();
		Assert.assertEquals(text1, i);
	}
	
	/*********************************************************************************************************************/
	//测试Thumbnail size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testThumbnailSize2(String i){
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[12]/ul/li[6]/a")).click();
		WebElement num2 = driver.findElement(By.id("thumbnail_size_h"));
		WebElement check = driver.findElement(By.id("thumbnail_crop"));
		num2.clear();
		num2.sendKeys(i);
		check.click();
		driver.findElement(By.id("submit")).click();
		String text2 = num2.getText();
		Assert.assertEquals(text2, i);
	}
	
	/*********************************************************************************************************************/
	//测试Medium size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testMediumSize1(String i){
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[12]/ul/li[6]/a")).click();
		WebElement num = driver.findElement(By.id("medium_size_w"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Medium size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testMediumSize2(String i){
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[12]/ul/li[6]/a")).click();
		WebElement num = driver.findElement(By.id("medium_size_h"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Large size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testLargeSize1(String i){
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[12]/ul/li[6]/a")).click();
		WebElement num = driver.findElement(By.id("large_size_w"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Large size
	@Test(dataProvider="getPage",dataProviderClass=DataHelper.class)
	public void testLargeSize2(String i){
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[12]/ul/li[6]/a")).click();
		WebElement num = driver.findElement(By.id("large_size_h"));
		num.clear();
		num.sendKeys(i);
		driver.findElement(By.id("submit")).click();
		String text = num.getText();
		Assert.assertEquals(text, i);
	}
	
	/*********************************************************************************************************************/
	//测试Uploading Files
	@Test
	public void testUpload(){
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/ul/li[12]/ul/li[6]/a")).click();
		WebElement check = driver.findElement(By.id("uploads_use_yearmonth_folders"));
		check.click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	/**
	 * @throws Exception ********************************************************************************************/
	// 测试Common Settings---非自定义
	@Test
	public void testCommon() throws Exception{
		driver.findElement(By.linkText("Permalinks")).click();
		List<WebElement> list = driver.findElements(By.name("selection"));
		System.out.println(list.size());
		for(int i=0;i<list.size()-1;i++){
			Thread.sleep(3000);
			list = driver.findElements(By.name("selection"));
			while(list.get(i).isSelected()==false){
				list.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Permalink structure updated."));
			}
		}
	}
	
	/********************************************************************************************************/
	//测试Common Settings---非自定义
	@Test(dataProvider="getUrl",dataProviderClass=DataHelper.class)
	public void testUrl(String url){
		driver.findElement(By.linkText("Permalinks")).click();
		WebElement radio = driver.findElement(By.id("custom_selection"));
		while(radio.isSelected()==false){
			radio.click();
		}
		WebElement put = driver.findElement(By.id("permalink_structure"));
		put.clear();
		put.sendKeys(url);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Permalink structure updated."));
	}
	/*** @throws Exception **************************************************************************/
	//测试Your homepage displays
	@Test
	public void testHomepage() throws Exception{
		driver.findElement(By.linkText("Reading")).click();
		List<WebElement> radios=driver.findElements(By.name("show_on_front"));
		System.out.println(radios.size());
		for(int i=0;i<radios.size();i++){
			Thread.sleep(3000);
			radios=driver.findElements(By.name("show_on_front"));
			while(radios.get(i).isSelected()==false){
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}
	
	/****************************************************************************************************************/
	//测试Blog pages show at most---手动输入
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testPageShow(String i){
		driver.findElement(By.linkText("Reading")).click();
		driver.findElement(By.id("posts_per_page")).clear();
		driver.findElement(By.id("posts_per_page")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	
	/****************************************************************************************************************/
	//测试Syndication feeds show the most recent
	@Test(dataProvider = "getPage", dataProviderClass = DataHelper.class)
	public void testSyndication(String i){
		driver.findElement(By.linkText("Reading")).click();
		driver.findElement(By.id("posts_per_rss")).clear();
		driver.findElement(By.id("posts_per_rss")).sendKeys(i);
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	
	/*** @throws Exception **************************************************************************************/
	//测试For each article in a feed, show
	@Test
	public void testArticle() throws Exception{
		driver.findElement(By.linkText("Reading")).click();
		List<WebElement> radios=driver.findElements(By.name("rss_use_excerpt"));
		System.out.println(radios.size());
		for(int i=0;i<radios.size();i++){
			Thread.sleep(3000);
			radios=driver.findElements(By.name("rss_use_excerpt"));
			while(radios.get(i).isSelected()==false){
				radios.get(i).click();
				driver.findElement(By.id("submit")).click();
				Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
			}
		}
	}
	
	/***********************************************************************************************************/
	//测试Search Engine Visibility
	@Test
	public void testEngine(){
		driver.findElement(By.linkText("Reading")).click();
		driver.findElement(By.id("blog_public")).click();
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	/*********************************************************************************************************************/
	//测试Default Post Category
	@Test(dataProvider = "getIndex", dataProviderClass = DataHelper.class)
	public void testCategory(String i){
		driver.findElement(By.linkText("Writing")).click();
		WebElement category=driver.findElement(By.id("default_category"));
		Select cate=new Select(category);
		cate.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
	
	/*********************************************************************************************************************/
	//测试Default Post Format
	@Test
	public void testFormat(String i){
		driver.findElement(By.linkText("Writing")).click();
		WebElement format = driver.findElement(By.id("default_post_format"));
		Select fSelect=new Select(format);
		fSelect.selectByIndex(Integer.parseInt(i));
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(driver.getPageSource().contains("Settings saved."));
	}
}