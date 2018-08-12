package com.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.learning.bean.BaseResponse;

@ControllerAdvice(basePackages={"com.learning.controller"})
public class ControllerExceptionHandler {

	private static final String ERROR_STATUS = "Invalid coupon!";
	private static final int INVALID_COUPON = 102;

	@ExceptionHandler({ InvalidCouponReferenceException.class })
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ResponseBody
	public BaseResponse handleAuthenticationException(Exception ex, WebRequest req) {
		BaseResponse response = new BaseResponse();
		response.setStatus(ERROR_STATUS);
		response.setCode(INVALID_COUPON);
		return response;
	}
}
