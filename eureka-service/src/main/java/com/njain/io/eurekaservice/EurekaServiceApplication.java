package com.njain.io.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServiceApplication.class, args);
  }

  @RestController
  class ServiceInstanceRestController {

    @RequestMapping("/")
    public String serviceInstancesByApplicationName() {
      return "I am a bootiful eureka service!";
    }
  }

}

