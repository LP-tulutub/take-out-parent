package com.shop.feigen.fallback;

import com.shop.feigen.AccountProducerFeign;
import com.shop.pojo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountProducerFeignFallback implements AccountProducerFeign {
    @Override
    public Object login(Account account) {
        return null;
    }
}
