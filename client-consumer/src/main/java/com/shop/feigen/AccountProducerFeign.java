package com.shop.feigen;

import com.shop.feigen.fallback.AccountProducerFeignFallback;
import com.shop.pojo.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "take-out-account-producer", fallback = AccountProducerFeignFallback.class)
public interface AccountProducerFeign {

    @RequestMapping("/account/login")
    Object login(@RequestBody Account account);



}
