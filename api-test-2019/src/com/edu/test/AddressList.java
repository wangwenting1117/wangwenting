package com.edu.test;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
import com.sun.jna.platform.unix.solaris.LibKstat.KstatNamed.UNION.STR;

/*
 * 李紫璇
 * 地址列表
 */
public class AddressList {
	String url="/fgadmin/address/list";
	public String address_list(String a,String b)throws Exception{
		System.out.println(a+" "+b);
		CookieStore cookie=Common.getCookie(a,b);
	    String result=HttpDriver.doGet(url,cookie);
		System.out.println(result);
		return result;
		
	}
	@Test
	public void test()throws Exception{
		address_list("20000000000","netease123");
	}
}
