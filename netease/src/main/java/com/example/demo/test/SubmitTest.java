package com.example.demo.test;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/*
 * 张晓
 * 提交订单
 */
@RestController
public class SubmitTest {
	@ResponseBody
	@RequestMapping(value = "/submit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public JSONObject doPostSubmit(HttpServletRequest request,@RequestBody JSONObject jsonParam
			,HttpServletResponse response) throws Exception {
		
		System.out.println(jsonParam.toString());
		String skuIds=jsonParam.getString("skuIds");
		String receiverName=jsonParam.getString("receiverName");
		String cellPhone=jsonParam.getString("cellPhone");
		String addressDetail=jsonParam.getString("addressDetail");
		String province=jsonParam.getString("province");
		String city=jsonParam.getString("city");
		String area=jsonParam.getString("area");
		String transportFee=jsonParam.getString("transportFee");
		
		JSONObject result=new JSONObject();
		
		Cookie[] cookies=request.getCookies();
		if(Objects.isNull(cookies)) {
			result.element("message","请先登录！");
		}
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("login")&&cookie.getValue().equals("true")) {
				if(skuIds!=null&&receiverName!=null&&cellPhone!=null&&addressDetail!=null&&province!=null
						&&city!=null&&area!=null&&transportFee!=null) {
					result.element("message","success");
				} 
				else {
					result.element("message","错误！" );
				}
			}
		}
		System.out.println(result);
		return result;
	}

}
