package com.shop.feigen;

import com.shop.feigen.fallback.OrderProducerFeignFallback;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "take-out-order-producer", fallback = OrderProducerFeignFallback.class)
public interface OrderProducerFeign {

    @RequestMapping("/selAll")
    List<TOrder> selAll();

    @RequestMapping("/selAllByPage/{page}/{rows}")
    LayUIDataGrid selAllByPage(@PathVariable int page, @PathVariable int rows);

    @RequestMapping("/ins")
    int ins(@RequestBody TOrder tOrder);

    @RequestMapping("/upd")
    int upd(@RequestBody TOrder tOrder);

    @RequestMapping("/selByUid/{uid}")
    List<TOrder> selByUid(@PathVariable int uid);

    @RequestMapping("/selByUidAndPage/{uid}/{page}/{rows}")
    LayUIDataGrid selByUidAndPage(@PathVariable int uid, @PathVariable int page, @PathVariable int rows);

    @RequestMapping("/findAllByUid/{uid}/{page}/{rows}")
    LayUIDataGrid findAllByUid(@PathVariable int uid, @PathVariable int page, @PathVariable int rows);

    @RequestMapping("/findAllByState/{page}/{rows}")
    LayUIDataGrid findAllByState(@PathVariable int page, @PathVariable int rows);
}
