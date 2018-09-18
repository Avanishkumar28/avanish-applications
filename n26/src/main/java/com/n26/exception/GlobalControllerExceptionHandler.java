package com.n26.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;


@ControllerAdvice
public class GlobalControllerExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppError> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        
        AppError error = new AppError(INTERNAL_SERVER_ERROR, "Please contect application administrator", e);
        return buildResponseEntity(error, OK);
    }

    /**
     * Exception handler for if any of the fields are not parsable or the transaction date is in the future
     */
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<AppError> fieldsNotParsable(HttpMessageNotReadableException ex) {
    	String errorMsg = "Malformed JSON request";
    	AppError error = null;
    	if(ex.getRootCause().getClass().equals(MismatchedInputException.class))
    		error = new AppError(BAD_REQUEST, errorMsg, ex);
    	else
    		error = new AppError(UNPROCESSABLE_ENTITY, errorMsg, ex);
        return buildResponseEntity(error, HttpStatus.valueOf(error.getStatus()));
    }

   
    /**
     * Exception handler for bad requests
     */
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<AppError> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ResponseEntity<AppError> processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        AppError error = null;
        if(!fieldErrors.isEmpty()) {
        	error = new AppError(UNPROCESSABLE_ENTITY.value(), "the fields are not parsable");
        	for (org.springframework.validation.FieldError fieldError : fieldErrors) {
                error.addFieldError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            }
        	
        }else
        	error = new AppError(BAD_REQUEST.value(), "validation error");
        
        return buildResponseEntity(error, HttpStatus.valueOf(error.getStatus()));
    }
    
    private ResponseEntity<AppError> buildResponseEntity(AppError appError, HttpStatus status) {
        return new ResponseEntity<AppError>(appError, status);
    }
    

}