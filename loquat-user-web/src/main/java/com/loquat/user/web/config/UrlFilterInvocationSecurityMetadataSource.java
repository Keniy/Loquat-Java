package com.loquat.user.web.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.loquat.user.entity.Menu;
import com.loquat.user.entity.Role;
import com.loquat.user.service.MenuService;

/**
 * URL权限过滤器
 * @author liugy
 *
 */
@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	
	@Autowired
	MenuService menuService;
	
	AntPathMatcher antPathMatcher = new AntPathMatcher();

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
		// 获取请求地址
		String requestUrl = ((FilterInvocation) o).getRequestUrl();
		if ("/login_p".equals(requestUrl)) {
			return null;
		}
		List<Menu> allMenu = menuService.findAll();
		for (Menu menu: allMenu) {
			if (antPathMatcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size() > 0) {
				List<Role> roles = menu.getRoles();
				int size = roles.size();
				String[] values = new String[size];
				for (int i = 0; i < size; i++) {
					values[i] = roles.get(i).getName();
				}
				return SecurityConfig.createList(values);
			}
		}
		// 没有匹配上的资源， 默认登录权限
		return SecurityConfig.createList("ROLE_LOGIN");
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return FilterInvocation.class.isAssignableFrom(arg0);
	}

}
