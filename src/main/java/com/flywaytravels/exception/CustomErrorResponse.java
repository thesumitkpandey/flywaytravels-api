package com.flywaytravels.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomErrorResponse {
    private boolean success;
    private String errorCode;
    private String errorMessage;
}
