package com.estate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estate.Response.BaseApiResponse;
import com.estate.Response.CommonSuccessResponse;
import com.estate.Response.ResponseBuilder;
import com.estate.request.UserRegistration;
import com.estate.resource.SecurityConstants;
import com.estate.security.JwtTokenProvider;
import com.estate.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;	
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/registration")
	public ResponseEntity<BaseApiResponse> registerUser(
			@Valid @RequestBody UserRegistration userRegistrationRequest, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		CommonSuccessResponse commonResponse = userService.userRegistration(userRegistrationRequest);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				userRegistrationRequest.getEmail(), userRegistrationRequest.getPassword()));
		String jwt = jwtTokenProvider.generateToken(authentication);
		System.out.println("  signupResponse  " + commonResponse);
		response.setHeader("Access-Control-Allow-Headers",
				"Authorization, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, "
						+ "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
		response.setHeader("Access-Control-Expose-Headers", "Authorization");
		response.setHeader(SecurityConstants.SecretKey.TOKEN_HEADER, SecurityConstants.SecretKey.TOKEN_PREFIX + jwt);
		BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(commonResponse);
		return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.CREATED);

	}

}
