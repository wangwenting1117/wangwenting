package com.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Common;

/*
 * 王文婷
 * 结算运费
 */
public class GetTransportFee {
	String url = "/transportFee";
	
	public String testTransfee1(String a,String b,String id,Object addressDetail) throws Exception{
		System.out.println(a+" "+b);
		
		CookieStore cookie=Common.getCookie(a, b);
		
		Map<String,Object> user =new HashMap<String,Object>(); 
		user.put("id",id);
		user.put("address",addressDetail);

		
		String result = HttpDriver.doGet(url, user, cookie);
		System.out.println(result);
		return result;
		
	}
	@Test
	public void test() throws Exception{
		testTransfee1("20000000000", "netease123", "1","江苏省_南京市_鼓楼区");
	}
}