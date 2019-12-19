package com.example.demo.test;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/*
 * 李紫璇
 * 地址列表
 */
@RestController
public class AddressListTest {
		@ResponseBody
		@RequestMapping(value="/fgadmin/address/list",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
		public JSONObject doGetSkulist( HttpServletRequest request) {
			
			
			JSONObject result = new JSONObject();
			Cookie[] cookies=request.getCookies();
			
			if(Objects.isNull(cookies)) {
				System.out.println("请先登录！");
				return result;
			}
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("login")&&cookie.getValue().equals("true")) {
						result.element("message","success");
						result.element("用户名：","12345");
						result.element("地址：","12345");
				}
			System.out.println(result);
			
		}
			return result;
	}

}
