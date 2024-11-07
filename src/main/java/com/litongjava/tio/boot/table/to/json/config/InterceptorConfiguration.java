package com.litongjava.tio.boot.table.to.json.config;

import com.litongjava.annotation.AConfiguration;
import com.litongjava.annotation.Initialization;
import com.litongjava.tio.boot.http.interceptor.HttpInteceptorConfigure;
import com.litongjava.tio.boot.http.interceptor.HttpInterceptorModel;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.boot.table.to.json.inteceptor.GlobalInterceptor;

@AConfiguration
public class InterceptorConfiguration {

  @Initialization
  public void configureInterceptors() {
    HttpInterceptorModel global = new HttpInterceptorModel();
    global.setName("global");
    global.addBlockUrl("/**");
    global.setInterceptor(new GlobalInterceptor());

    HttpInteceptorConfigure config = new HttpInteceptorConfigure();
    config.add(global);

    TioBootServer.me().setHttpInteceptorConfigure(config);
  }
}
