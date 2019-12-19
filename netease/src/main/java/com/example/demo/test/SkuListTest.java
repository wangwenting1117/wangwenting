package com.example.demo.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class SkuListTest {
	@RequestMapping(value="/SkulistTest",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public JSONObject doGetSkulist( HttpServletRequest request) {
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		JSONObject result = new JSONObject();
		if(id!=null) {
			result.element("message","success");
			result.element("商品id为：","12345");
		}else {
			result.element("message","错误");
		}
		System.out.println(result);
		return result;
		
	}
}
