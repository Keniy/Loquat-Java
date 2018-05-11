package com.loquat.user.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuMeta {
	
	private boolean keepAlive;
	private boolean requireAuth;
}
