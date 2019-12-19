package com.example.demo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/*
 * 高清鑫
 * 添加地址
 */
@RestController
public class AddAddressTest {
	@RequestMapping(value = "/fgadmin/address/new", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public JSONObject NewAddress(@RequestBody JSONObject jsonParam,HttpServletResponse response,HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();

		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();		
		
		String id=jsonParam.getString("id");
		String receiverName=jsonParam.getString("receiverName");
		String cellPhone=jsonParam.getString("cellPhone");
		String addressDetail=jsonParam.getString("addressDetail");
		String province=jsonParam.getString("province");
		String city=jsonParam.getString("city");
		String area=jsonParam.getString("area");
		JSONObject result = new JSONObject();
		
		if (Objects.isNull(cookies)) {
			return result.element("message","请先登录");
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				if(list.size()<6) {
					Map<String, Object> goods1 = new HashMap<String, Object>();
					goods1.put("id", id);
					goods1.put("receieverName", receiverName);
					goods1.put("cellPhone", cellPhone);
					goods1.put("addressDetail", addressDetail);
					goods1.put("province", province);
					goods1.put("city", city);
					goods1.put("area", area);
					list.add(0,goods1);
					for(Map<String, Object> map:list){
						String value = (String) map.get("id");
						if(id.equals(value)) {
							return result.element("message","添加地址成功");
						}
					}
				}
				else	return result.element("message","最多只能添加 6 个地址");
			}
		}
		return result;
	}

}
