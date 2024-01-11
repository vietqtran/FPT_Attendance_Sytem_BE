package com.fas.models.exceptions;

import com.fas.models.utils.ErrorObject;
import com.fas.models.utils.MessageDetails;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        List<ErrorObject> details = new ArrayList<>();

        ex.getConstraintViolations().forEach(error -> {
            ErrorObject errorObject = new ErrorObject(error.getPropertyPath().toString(), error.getMessage());
            details.add(errorObject);
        });

        MessageDetails errorDetails = new MessageDetails("Validation Failed", details, "Failure");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleNullPointerException(UsernameNotFoundException ex, WebRequest request) {

        ErrorObject errorObject = new ErrorObject("account", ex.getMessage());

        MessageDetails errorDetails = new MessageDetails("Error", errorObject, "Failure");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleNullPointerException(AccountExceptions ex, WebRequest request) {

        ErrorObject errorObject = new ErrorObject("account", ex.getMessage());

        MessageDetails errorDetails = new MessageDetails("Error", errorObject, "Failure");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {

        ErrorObject errorObject = new ErrorObject("account", ex.getMessage());

        MessageDetails errorDetails = new MessageDetails("Error", errorObject, "Failure");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
