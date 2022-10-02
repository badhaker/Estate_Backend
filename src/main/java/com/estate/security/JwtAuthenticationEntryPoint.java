package com.estate.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.estate.Exception.AppException;
import com.estate.Response.BaseApiResponse;
import com.estate.Response.ResponseStatus;
import com.estate.resource.AppConstant;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException)
			throws IOException, ServletException {
		{
			BaseApiResponse baseApiResponse = new BaseApiResponse();
			AppException appException = new AppException(AppConstant.ErrorTypes.INVALID_TOKEN_ERROR_TYPE,
			AppConstant.ErrorCodes.INVALID_TOKEN_ERROR_CODE,
			AppConstant.ErrorMessage.INVALID_TOKEN_ERROR_MESSAGE);
			ResponseStatus status = new ResponseStatus();
			status.setStatusCode(AppConstant.StatusCodes.FAILURE);
			baseApiResponse.setResponseStatus(status);
			baseApiResponse.setMessage(appException.getMessage());
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			ObjectMapper Obj = new ObjectMapper();
			String json = Obj.writeValueAsString(baseApiResponse);
			response.getWriter().write(json);
		}
	}

}
