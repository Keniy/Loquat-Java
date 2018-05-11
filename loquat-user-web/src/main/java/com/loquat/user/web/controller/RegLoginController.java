package com.loquat.user.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loquat.user.web.bean.RespBean;

@RestController
public class RegLoginController {
	
	@Autowired
	protected HttpServletResponse response;
	
	@RequestMapping("/login_p")
	@ResponseBody
	public RespBean login() {
		return new RespBean("error", "尚未登录，请登录！");
	}
}
