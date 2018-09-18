package com.n26.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class AppError {

    private final int status;

    private final String message;

    private List<FieldError> fieldErrors = new ArrayList<>();

    AppError(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public AppError(HttpStatus unprocessableEntity, String error, Throwable ex) {
    	this.status = unprocessableEntity.value();
        this.message = error;
	}

	public void addFieldError(String objectName, String path, String message) {
        FieldError error = new FieldError(objectName, path, message);
        fieldErrors.add(error);
    }

}