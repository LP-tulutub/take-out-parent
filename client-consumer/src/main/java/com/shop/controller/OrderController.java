package com.shop.controller;

import com.shop.feigen.OrderProducerFeign;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TOrder;
import com.shop.utils.CookieUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderProducerFeign orderProducerFeign;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/")
    @ResponseBody
    public List<TOrder> all(){
        return this.orderProducerFeign.selAll();
    }

    @RequestMapping("/save/{mid}")
    public String save(@PathVariable int mid, HttpServletRequest req){
        //获取用户id
        String token = CookieUtils.getCookieValue(req, "TT_TOKEN");
        Object obj = this.redisTemplate.opsForValue().get(token);
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap)obj;
        Object id = hashMap.get("id");
        TOrder tOrder = new TOrder();
        tOrder.setUid((int)id);
        tOrder.setMid(mid);
        tOrder.setState(0);
        //存到订单表中
        int i = this.orderProducerFeign.ins(tOrder);
        if (i==1){
            return "redirect:/userHome";
        }
        return "error";
    }

    @RequestMapping("/findAllByUid")
    @ResponseBody
    public LayUIDataGrid findAllByUid(int page, int limit, HttpServletRequest req){
        //获取用户id
        String token = CookieUtils.getCookieValue(req, "TT_TOKEN");
        Object obj = this.redisTemplate.opsForValue().get(token);
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap)obj;
        Object uid = hashMap.get("id");
        //分页查询TOrder
        return this.orderProducerFeign.findAllByUid((int)uid, page, limit);
    }

    @RequestMapping("/findAllByState")
    @ResponseBody
    public LayUIDataGrid findAllByState(int page, int limit){
        return this.orderProducerFeign.findAllByState(page, limit);
    }

    @RequestMapping("/updateState/{id}/{aid}")
    public String updateState(@PathVariable int id, @PathVariable int aid){
        TOrder tOrder = new TOrder();
        tOrder.setState(1);
        tOrder.setAid(aid);
        tOrder.setId(id);
        int i = this.orderProducerFeign.upd(tOrder);
        if (i==1){
            return "redirect:/view/account/redirect/order_handler";
        }
        return "error";
    }

}
