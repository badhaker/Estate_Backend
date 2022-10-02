package com.estate.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppSecurityInterceptorHandler extends HandlerInterceptorAdapter {
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info(" the requested method is    " + request.getMethod() + "   the provided url is   "
				+ request.getRequestURI());

		response.addHeader("Access-Control-Allow-Methods", "*");

		response.setHeader("Access-Control-Allow-Headers", "*");

		response.setHeader("Access-Control-Expose-Headers", "Content-disposition, Authorization");
		response.addHeader("Access-Control-Max-Age", "3600");
		return true;
	}
}
