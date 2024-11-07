package com.litongjava.tio.boot.table.to.json.controller;

import com.litongjava.annotation.RequestPath;
import com.litongjava.tio.boot.http.TioRequestContext;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;

@RequestPath("/")
public class IndexController {
  @RequestPath()
  public HttpResponse index(HttpRequest request) {
    HttpResponse response = TioRequestContext.getResponse();
    response.sendRedirect("/index.html");
    return response;

  }
}
