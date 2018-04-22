package com.spring.boot.cloud.Controller;

import com.google.gson.Gson;
import com.spring.boot.cloud.mapper.UserMapper;
import com.spring.boot.cloud.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProviderUserController {

    private final Logger logger = Logger.getLogger(ProviderUserController.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscoveryClient discoveryClient;

    final Gson gson = new Gson();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody User searchUser(@RequestParam(name = "id", defaultValue = "1") Integer id) {
        User user = userMapper.searchUser(id);
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("host:" + serviceInstance.getHost() + "\tserviceId:" + serviceInstance.getServiceId() + "\tresult:" + gson.toJson(user));
        return user;
    }
}
