package com.sharing.session.webflux.helper;

import org.springframework.http.HttpStatus;

import com.sharing.session.webflux.model.response.WebResponse;

public class ResponseHelper {

  private ResponseHelper() {}

  public static <T> WebResponse<T> ok() {
    return toWebResponse(HttpStatus.OK, null);
  }

  public static <T> WebResponse<T> ok(T data) {
    return toWebResponse(HttpStatus.OK, data);
  }

  public static <T> WebResponse<T> notFound(T data) {
    return toWebResponse(HttpStatus.NOT_FOUND, data);
  }

  private static <T> WebResponse<T> toWebResponse(HttpStatus httpStatus, T data) {
    return WebResponse.<T>builder().code(httpStatus.value()).status(httpStatus.getReasonPhrase())
        .data(data).build();
  }
}
