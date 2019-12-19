package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/*
 * 王文婷
 * 结算运费
 */
@RestController
public class TransportFeeTest {
	@RequestMapping(value="/transportFee", method = RequestMethod.GET)
    public Map<String, Object> getFee(HttpServletRequest request){
	  Cookie[] cookies = request.getCookies();
	  JSONObject fee = new JSONObject();
	  String id = request.getParameter("id");
	  String addressDetail = request.getParameter("address");
	  
	  System.out.println(id+"  "+addressDetail);
	  
	  if (Objects.isNull(cookies)==true) {
		  fee.put("message","请先登录!");
		}
	  for(Cookie cookie : cookies) {
		  if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
			  if(id.contains("1")&&addressDetail.contains("江苏省_南京市_鼓楼区")) {
		        fee.element("fee", "999");
		        fee.element("address","江苏省_南京市_鼓楼区");
		        fee.element("message","success");
		        System.out.println(fee);
			  }
			  else 
			  {
				  fee.element("message", "错误！");
			  }
		  }
	  }
	return fee;
    }
}
