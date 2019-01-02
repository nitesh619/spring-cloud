package com.njain.io.gatewayservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GatewayController {

  @RequestMapping()
  public String getHomeService() {
    return "I am your gateway to Zuul-Eureka-Netflix!";
  }
}
