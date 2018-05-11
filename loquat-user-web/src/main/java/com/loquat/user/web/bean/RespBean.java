package com.loquat.user.web.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespBean {
	
	private String status;
	private String msg;
	
	public RespBean(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}
}
