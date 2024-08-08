package com.sharing.session.webflux.controller.exception;

import lombok.Getter;

@Getter
public class DataNotFoundException extends RuntimeException {

  private final String field;

  public DataNotFoundException(String message, String field) {
    super(message);
    this.field = field;
  }
}
