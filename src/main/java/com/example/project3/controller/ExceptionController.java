package com.example.project3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class ExceptionController {
    @GetMapping("/error")
    public ResponseEntity<String> throwError(){
        throw new CustomException("An error occurred while executing a query.");
    }
    @ExceptionHandler(CustomException.class)
        public ResponseEntity<String> handleCustomException(CustomException ex){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("exception worked"+ex.getMessage());
}
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 public static class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
  }
}
