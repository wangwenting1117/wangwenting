package com.example.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * 张鹏宇
 * 删除地址
 */
@RestController
public class DeleteAddressTest{
@ResponseBody
@RequestMapping(value="/delete",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
public JSONObject getByJSON(@RequestBody JSONObject jsonParam,HttpServletResponse reponse,HttpServletRequest request)throws Exception {

	String theaddressId=jsonParam.getString("addressId");
	String theaddressDetail=jsonParam.getString("addressDetail");
	
	HashMap<String,String> map= new HashMap<String, String>();
	map.put("addressId", theaddressId);
	map.put("addressDetail", theaddressDetail);
	
	System.out.println(map);
	 
	HashMap<String, String> map0 = new HashMap<String, String>();
	map0.put( "addressId", "123");
	map0.put("addressDetail", "HeBei Normal University");
	
	HashMap<String, String> map1 = new HashMap<String, String>();
	map1.put("addressId", "223");
	map1.put("addressDetail","河北省石家庄市河北师范大学");
	
	HashMap<String, String> map2 = new HashMap<String, String>();
	map2.put("addressId", "111");
	map2.put("addressDetail","wow");
	
	List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
	list.add(map0);
	list.add(map1);
	list.add(map2);

	JSONObject result=new JSONObject();
	
		Cookie[] cookies = request.getCookies();
		if(Objects.isNull(cookies)) {
			result.element("message", "请先登录");
			return result;
		}
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("login")&&cookie.getValue().equals("true")) {
				System.out.println(list);
				for(int i=0;i<list.size();i++) {
					System.out.println(list.get(i).equals(map));
					if(list.get(i).equals(map)) {
						result.element("message","地址存在" );
						list.remove(i);
						result.element("message","地址已删除" );
					}else {
						result.element("message","地址不存在" );
					}
				}
		    }
		}	
	System.out.println(result);
	return result;
		}
}