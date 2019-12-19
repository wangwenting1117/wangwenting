package com.edu.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.sun.mail.imap.protocol.MailboxInfo;

import net.sf.json.JSONObject;
import net.sf.json.util.NewBeanInstanceStrategy;

/*
 * 许莹心
 * 商品列表
 */
public class SkuListTest {
	String url = "/SkulistTest";
	
	public String testByPara(String id) throws Exception{
		Map<String, Object> ids = new HashMap<String, Object>();
		ids.put("id", id);
		String result = HttpDriver.doGet(url, ids);
		System.out.println(result);
		return result;
	}
	@Test
	public void testByPara() throws Exception{
		testByPara("12345");
	}
}
