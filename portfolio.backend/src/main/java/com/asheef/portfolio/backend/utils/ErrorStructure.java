package com.asheef.portfolio.backend.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorStructure {
    private String message;
    private Integer errorCode;
    private String error;
}
