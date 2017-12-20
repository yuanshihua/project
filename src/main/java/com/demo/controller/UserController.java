package com.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private ObjectMapper objectMapper;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	/**
	 * 
	 * @Description: 跳转登录页面
	 * @return String
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月12日
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * @Description: 跳转到list页面(只能用post方式)
	 * @return String
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月12日
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String index() {
		return "list";
	}

	/**
	 * 
	 * @Description: 简要进行方法说明，并对基础数据类型的参数和返回值加以说明
	 * @return Map
	 * @throws @author
	 *             yuanshihua
	 * @date 2017年12月12日
	 */
	@SuppressWarnings("all")
	@RequestMapping(value = "/userlist", method = RequestMethod.POST)
	@ResponseBody
	public Map getUserList(String models) {
		Map searchParameters = new HashMap();
		if (models != null && models.length() > 0) {
			try {
				searchParameters = objectMapper.readValue(models, new TypeReference<Map>() {
				});
			} catch (JsonParseException e) {
				log.error("JsonParseException{}:", e.getMessage());
			} catch (JsonMappingException e) {
				log.error("JsonMappingException{}:", e.getMessage());
			} catch (IOException e) {
				log.error("IOException{}:", e.getMessage());
			}
		}
		Map userList = userService.getUserPage(searchParameters);
		System.out.println(userList);
		return userList;
	}
}
