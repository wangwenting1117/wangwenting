package com.edu.test;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 张鹏宇
 * 删除地址
 */
public class DeleteAddress {
	String url="/delete";
	public String deleteAddress(String userName,String password,String addressId,String addressDetail)throws Exception {
		System.out.println(userName+" "+password);
		
		CookieStore cookie=Common.getCookie(userName, password);
		
		
		JSONObject address=new JSONObject();
		address.element("addressId", addressId);
		address.element("addressDetail", addressDetail);
		
		String  result=HttpDriver.doPost(url,address,cookie);
		System.out.println(result);
		return result;
		
	}
	
	@Test
     public void test1() throws Exception {
		deleteAddress("20000000000","netease123","111","wow");
	}
}