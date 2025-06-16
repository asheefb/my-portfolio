package com.asheef.portfolio.backend.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.asheef.portfolio.backend.utils.ErrorStructure;
import com.asheef.portfolio.backend.utils.ResponseBody;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseBody> buildGlobalExceptionForValidation(MethodArgumentNotValidException e) {
        List<ErrorStructure> errors = new ArrayList<>();
        for (FieldError field : e.getBindingResult().getFieldErrors()) {
            ErrorStructure errorStructure = new ErrorStructure();
            errorStructure.setMessage(null != field.getDefaultMessage()
                    ? field.getDefaultMessage()
                    : "Validation error");
            errorStructure.setErrorCode(400);
            errorStructure.setError("Validation Error");
            errors.add(errorStructure);
        }
        return new ResponseEntity<ResponseBody>(new ResponseBody("UnSuceess", 500, errors), HttpStatus.BAD_REQUEST);

    }
}
