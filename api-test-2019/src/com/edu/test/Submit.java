package com.edu.test;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.http.client.CookieStore;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.ExcelDataProvider;
import com.edu.dataprovider.NSDataProvider;
import com.edu.utils.Checker;
import com.edu.utils.Common;

import net.sf.json.JSONObject;

/*
 * 张晓
 * 提交订单
 */
public class Submit {
	String submit_url="/submit";
	
	public String testSubmit(String a,String b
			,String skuIds,String receiverName,String cellPhone,String addressDetail,
			String province,String city,String area,String transportFee
			) throws Exception{
		System.out.println(a+" "+b);
		CookieStore cookie=Common.getCookie(a,b);
		
		JSONObject user=new JSONObject();
		user.element("skuIds",skuIds);
		user.element("receiverName", receiverName);
		user.element("cellPhone", cellPhone);
		user.element("addressDetail", addressDetail);
		user.element("province", province);
		user.element("city", city);
		user.element("area", area);
		user.element("transportFee",transportFee);
		
		String result=HttpDriver.doPost(submit_url,user, cookie);
//		String result=HttpDriver.doPost(submit_url, user);
		System.out.println(result);
		return result;
	}
	@Test
	public void test1() throws Exception{
		testSubmit("20000000000", "netease123","1","李四","15422222222","浙江大学","浙江省","杭州市","西湖区","6.0");
	}
}
