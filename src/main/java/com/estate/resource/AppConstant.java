package com.estate.resource;

public interface AppConstant {
	
	public interface ErrorTypes {
		String INVALID_TOKEN_ERROR_TYPE = "Token Invalid";
		String ENTITY_NOT_EXISTS_ERROR = "ENTITY_NOT_EXISTS_ERROR";
	}

	public interface ErrorMessage {
		String INVALID_TOKEN_ERROR_MESSAGE = "Invalid Token";
		String ENTITY_NOT_EXISTS_ERROR_MESSAGE = "ENTITY_NOT_EXISTS_ERROR_MESSAGE";
	}
	
	public interface ErrorCodes {
		String INVALID_TOKEN_ERROR_CODE = "100";
		String ENTITY_NOT_EXISTS_ERROR_CODE = "ENTITY_NOT_EXISTS_ERROR_CODE";
	}
	
	public interface StatusCodes {
		int SUCCESS = 0;
		int FAILURE = 1;
	}
	
	public interface FileLocation {
		String PROPERTY_PATH ="classpath:application.properties";
	}
}
