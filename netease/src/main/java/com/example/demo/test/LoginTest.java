package com.example.demo.test;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class LoginTest{
	@ResponseBody
	@RequestMapping(value="/login", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public JSONObject doPostLogin(@RequestBody JSONObject jsonParam,HttpServletResponse response)
	{
		System.out.println(jsonParam.toString());
		String phoneArea=jsonParam.getString("phoneArea");
		String phoneNumber=jsonParam.getString("phoneNumber");
		String password=jsonParam.getString("password");
		
		JSONObject result=new JSONObject();
		
		if (phoneArea.equals("86") && phoneNumber.equals("20000000000")&&password.equals("netease123")) {
			Cookie cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			
			result.element("message","success");
		}
		else {
			result.element("message","fail");
		}
		System.out.println(result);
		return result;
	}
}
