package com.litongjava.tio.boot.table.to.json.inteceptor;

import com.litongjava.tio.boot.http.TioRequestContext;
import com.litongjava.tio.boot.utils.HttpBasicAuthUtils;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.common.RequestLine;
import com.litongjava.tio.http.server.intf.HttpRequestInterceptor;
import com.litongjava.tio.utils.environment.EnvUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalInterceptor implements HttpRequestInterceptor {

  public HttpResponse doBeforeHandler(HttpRequest request, RequestLine requestLine, HttpResponse responseFromCache) throws Exception {
    if(!EnvUtils.isDev()) {
      // 执行认证
      String authorization = request.getHeader("authorization");
      if (!HttpBasicAuthUtils.authenticate(authorization, "admin", "Imaginix@2024")) {
        HttpResponse response = TioRequestContext.getResponse();
        response.setStatus(401);
        response.addHeader("WWW-Authenticate", "Basic realm=\"Access to the site\"");
        return response;
      }
    }
    return null;
  }

  public void doAfterHandler(HttpRequest request, RequestLine requestLine, HttpResponse response, long cost) throws Exception {
    log.info("request completed: {}", request);
  }
}
