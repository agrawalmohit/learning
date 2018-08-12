package com.learning.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bean.BaseResponse;
import com.learning.bean.UserDetails;
import com.learning.exception.InvalidCouponReferenceException;

@RestController
@RequestMapping("/discount")
public class DiscountController {
	private final String COUPON_CODE = "COUPON";
	private static final String SUCCESS_STATUS = "success";
	private static final int CODE_SUCCESS = 100;

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public BaseResponse pay(@RequestParam(value = "code") String code, @RequestBody UserDetails request)
			throws InvalidCouponReferenceException {
		BaseResponse response = new BaseResponse();
		if (COUPON_CODE.equalsIgnoreCase(code)) {
			//business service calls
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
		} else {

			throw new InvalidCouponReferenceException();

		}
		return response;
	}
}
