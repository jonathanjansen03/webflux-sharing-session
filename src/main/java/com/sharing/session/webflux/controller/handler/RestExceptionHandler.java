package com.sharing.session.webflux.controller.handler;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sharing.session.webflux.controller.exception.DataNotFoundException;
import com.sharing.session.webflux.helper.ResponseHelper;
import com.sharing.session.webflux.model.response.WebResponse;

@RestControllerAdvice
public class RestExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(DataNotFoundException.class)
  public WebResponse<Map<String, String>> notFound(DataNotFoundException e) {
    return ResponseHelper.notFound(Collections.singletonMap(e.getField(), e.getMessage()));
  }
}
