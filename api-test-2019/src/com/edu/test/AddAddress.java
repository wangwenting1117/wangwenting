package com.edu.test;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.Common;
import com.sun.jna.platform.unix.solaris.LibKstat.KstatNamed.UNION.STR;

import net.sf.json.JSONObject;

/*
 * 高清鑫
 * 添加地址
 */
public class AddAddress {
	String new_url="/fgadmin/address/new";
	Checker check = null;
	@Test
	public void Testadd() throws Exception {
		CookieStore cookie=Common.getCookie("20000000000", "netease123");
		JSONObject para=new JSONObject();
		para.element("id","22");
		para.element("receiverName","22");
		para.element("cellPhone","12615813537");
		para.element("addressDetail","22");
		para.element("province","22");
		para.element("city","22");
		para.element("area","22");
		String result=HttpDriver.doPost(new_url, para, cookie);
		check = new Checker(result);
		System.out.println(result);
	}
}
