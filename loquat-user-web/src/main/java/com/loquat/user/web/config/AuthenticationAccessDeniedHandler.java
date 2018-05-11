package com.loquat.user.web.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 权限验证失败Handler
 * @author liugy
 *
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp, AccessDeniedException e)
			throws IOException, ServletException {
		resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("{\"status\":\"error\",\"msg\":\"权限不足，请联系管理员!\"}");
		out.flush();
		out.close();
	}

}
