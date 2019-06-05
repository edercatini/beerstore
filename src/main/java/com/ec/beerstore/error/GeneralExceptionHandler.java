package com.ec.beerstore.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Order
@RestControllerAdvice
public class GeneralExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    private final ApiExceptionHandler apiExceptionHandler;

    @Autowired
    public GeneralExceptionHandler(ApiExceptionHandler apiExceptionHandler) {
        this.apiExceptionHandler = apiExceptionHandler;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleServerError(Exception exception, Locale locale) {

        LOGGER.error("Not expected runtime error", exception);

        final String errorCode = "error-1";
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErrorResponse response = ErrorResponse.of(status, apiExceptionHandler.toApiError(errorCode, locale));

        return ResponseEntity.status(status).body(response);
    }
}