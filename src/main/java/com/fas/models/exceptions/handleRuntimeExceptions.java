//package com.fas.models.exceptions;
//
//import com.fas.models.utils.MessageDetails;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//
//
//@ControllerAdvice
//
//public class handleRuntimeExceptions {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<MessageDetails> otherExceptionHandler(RuntimeException exception, WebRequest request) {
//        MessageDetails error = new MessageDetails(request.getDescription(false), exception.getMessage(), "Failure");
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
//}
