package com.estate.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.estate.Repository.UserRepository;
import com.estate.Response.CommonSuccessResponse;
import com.estate.entity.User;
import com.estate.request.UserRegistration;
import com.estate.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public CommonSuccessResponse userRegistration(UserRegistration userRegistrationRequest) {

		User user = new User();
		user.setEmail(userRegistrationRequest.getEmail());
		user.setName(userRegistrationRequest.getName());
		user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
		user.setMobile(userRegistrationRequest.getMobileNumber());
		userRepository.save(user);
		return new CommonSuccessResponse(true);
	}

}
