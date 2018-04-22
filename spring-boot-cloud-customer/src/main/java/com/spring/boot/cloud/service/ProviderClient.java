package com.spring.boot.cloud.service;

import com.spring.boot.cloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("provider")
public interface ProviderClient {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    User searchUser(@RequestParam(name = "id", defaultValue = "1") Integer id);
}
