package com.asheef.portfolio.backend.utils;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class ResponseBody {

    private String message;
    private Object data;
    private Integer statusCode;
    private List<ErrorStructure> errors;

    ResponseBody(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    ResponseBody(String message, Object data, Integer statusCode) {
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }

    ResponseBody(String message, Object data, Integer statusCode, List<ErrorStructure> errors) {
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
        this.errors = errors;
    }

    ResponseBody(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }   

    public ResponseBody(String message, Integer statusCode, List<ErrorStructure> errors) {
        this.message = message;
        this.statusCode = statusCode;
        this.errors = errors;
    }
    
}