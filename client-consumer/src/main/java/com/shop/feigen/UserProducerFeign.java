package com.shop.feigen;

import com.shop.feigen.fallback.UserProducerFeignFallback;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "take-out-user-producer", fallback = UserProducerFeignFallback.class)
public interface UserProducerFeign {

    @RequestMapping("/selAll")
    List<TUser> selAll();

    @RequestMapping("/selAllByPage/{page}/{rows}")
    LayUIDataGrid selAllByPage(@PathVariable int page, @PathVariable int rows);

    @RequestMapping("/selByTUser")
    String selByTUser(@RequestBody TUser tUser);

    @RequestMapping("/ins")
    int ins(@RequestBody TUser tUser);

    @RequestMapping("/updPasswordById")
    int updPasswordById(@RequestBody TUser tUser);
}
