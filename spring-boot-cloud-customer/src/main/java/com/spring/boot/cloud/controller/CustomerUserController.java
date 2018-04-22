package com.spring.boot.cloud.controller;

import com.google.gson.Gson;
import com.spring.boot.cloud.model.User;
import com.spring.boot.cloud.service.ProviderClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerUserController {

    private final Logger logger = Logger.getLogger(CustomerUserController.class);

    final Gson gson = new Gson();

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProviderClient providerClient;

    /**
     * @author guofeng
     * @create 2018/4/22
     * @Description ribbon连接方式
     **/
    @RequestMapping(value = "/searchRibbon", method = RequestMethod.GET)
    public String searchRibbonUser() {

        User user = new User();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> userHttpEntity = new HttpEntity<User>(user, headers);
        ResponseEntity<User> userResponseEntity = restTemplate.exchange("http://PROVIDER/user?id=1", HttpMethod.GET, userHttpEntity, User.class);
        user = userResponseEntity.getBody();

        return gson.toJson(user);
    }

    /**
     * @author guofeng
     * @create 2018/4/22
     * @Description feign连接方式
     **/
    @RequestMapping(value = "/searchFeign", method = RequestMethod.GET)
    public String searchFeignUser() {

        User user = providerClient.searchUser(1);
        return gson.toJson(user);
    }
}
