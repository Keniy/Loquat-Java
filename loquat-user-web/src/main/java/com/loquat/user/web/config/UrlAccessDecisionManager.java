package com.loquat.user.web.config;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * URL访问决策
 * @author liugy
 *
 */
@Component
public class UrlAccessDecisionManager implements AccessDecisionManager{

	@Override
	public void decide(Authentication authentication, Object obj, Collection<ConfigAttribute> collection)
			throws AccessDeniedException, InsufficientAuthenticationException {
		Iterator<ConfigAttribute> iterator = collection.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute attr = iterator.next();
			// 当前请求需要的权限
			String needRole = attr.getAttribute();
			if ("ROLE_LOGIN".equals(needRole)) {
				if (authentication instanceof AnonymousAuthenticationToken) {
					throw new BadCredentialsException("用户未登录");
				} else {
					return;
				}
			}
			// 当前用户所具有的权限
			Collection<? extends GrantedAuthority> authorites = authentication.getAuthorities();
			authorites.stream().forEach((authority) -> {
				if (authority.equals(needRole)) {
					return;
				}
			});
		}
		throw new AccessDeniedException("权限不足");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
