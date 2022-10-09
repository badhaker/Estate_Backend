package com.estate.service;

import org.springframework.stereotype.Component;

import com.estate.Response.CommonSuccessResponse;
import com.estate.request.UserRegistration;

@Component
public interface UserService {

	CommonSuccessResponse userRegistration(UserRegistration userRegistrationRequest);

}
