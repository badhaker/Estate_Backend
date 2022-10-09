package com.estate.controller;

import com.estate.Response.BaseApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@PostMapping("/registration")
	public ResponseEntity<BaseApiResponse> createCoustomer(
			@Valid @RequestBody CoustomerSingupRequest coustomerSingupRequest, HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		CommonSuccessResponse commonResponse = userService.createCoustomer(coustomerSingupRequest);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				coustomerSingupRequest.getEmail(), coustomerSingupRequest.getPassword()));
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
