package com.njain.io.genericservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class GenericServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(GenericServiceApplication.class, args);
  }

  @RestController
  class ServiceInstanceRestController {

    @RequestMapping("/")
    public String genericService() {
      return "I am generic message via generic service.!";
    }

    @RequestMapping("/location")
    public String genericLocation(@RequestHeader("x-location") String loc) {
      return "I am from " + loc + " buddy!";
    }
  }

}

