package org.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.test.error.ApiError;

@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DuplicateStudentException.class)
	protected ResponseEntity<Object> handleDuplicateEntityException(DuplicateStudentException ex) {
		ApiError error = new ApiError(HttpStatus.ALREADY_REPORTED);
		error.setMessage(ex.getMessage());
		return buildResposeEntity(error);
	}

	private ResponseEntity<Object> buildResposeEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
