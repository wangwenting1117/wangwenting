package com.edu.test;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import net.sf.json.JSONObject;

public class LoginTest {
	String Login_url = "/login";

	public String login(Object phoneNumber, Object password, Object phoneArea) throws Exception {
		JSONObject user = new JSONObject();
		user.element("phoneNumber", phoneNumber);
		user.element("password", password);
		user.element("phoneArea", phoneArea);
		String result = HttpDriver.doPost(Login_url, user);
		System.out.println(result);
		return result;
	}

	@Test
	public void testLoginSuccess() throws Exception {
		login("20000000000", "netease123", "86");
	}
}
