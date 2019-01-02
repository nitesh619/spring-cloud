package com.njain.io.eurekaclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaClientApplication.class, args);
  }

  @RestController
  class ServiceInstanceRestController {

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @RequestMapping("/call-service/{applicationName}")
    public String serviceInstancesByApplicationName(
        @PathVariable String applicationName) {
      InstanceInfo instanceInfo = this.discoveryClient
          .getNextServerFromEureka(applicationName, false);
      String homePageUrl = instanceInfo.getHomePageUrl();
      RestTemplate restTemplate = restTemplateBuilder.build();

      ResponseEntity<String> responseEntity = restTemplate
          .exchange(homePageUrl, HttpMethod.GET, null, String.class);
      return "Returning response from " + homePageUrl + " :" +responseEntity.getBody();
    }
  }

}

