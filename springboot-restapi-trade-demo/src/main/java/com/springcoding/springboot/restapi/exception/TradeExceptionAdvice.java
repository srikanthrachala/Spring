package com.springcoding.springboot.restapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Handler for Trade Operations
 * 
 * @author Srikanth
 *
 */
@ControllerAdvice
public class TradeExceptionAdvice {

  @ResponseBody
  @ExceptionHandler(TradeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String tradeNotFoundHandler(TradeNotFoundException ex) {
    return ex.getMessage();
  }

  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  String tradeValidationHandler(MethodArgumentNotValidException ex) {
    return ex.getMessage();
  }

}