package com.smartparking.payment.controller;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.time.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(java.util.NoSuchElementException.class)
 public ResponseEntity<ErrorResponse> notFound(Exception e){return ResponseEntity.status(404).body(new ErrorResponse(404,e.getMessage()));}
 @ExceptionHandler(IllegalArgumentException.class)
 public ResponseEntity<ErrorResponse> badRequest(Exception e){return ResponseEntity.badRequest().body(new ErrorResponse(400,e.getMessage()));}
 @ExceptionHandler(IllegalStateException.class)
 public ResponseEntity<ErrorResponse> conflict(Exception e){return ResponseEntity.status(409).body(new ErrorResponse(409,e.getMessage()));}
 record ErrorResponse(int status,String message,LocalDateTime timestamp) {
   ErrorResponse(int status,String message){this(status,message,LocalDateTime.now());}
 }
}
