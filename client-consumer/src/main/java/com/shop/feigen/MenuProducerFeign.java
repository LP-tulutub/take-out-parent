package com.shop.feigen;

import com.shop.feigen.fallback.MenuProducerFeignFallback;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenu;
import com.shop.pojo.TMenuAndTType;
import com.shop.pojo.TType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "take-out-menu-producer", fallback = MenuProducerFeignFallback.class)
public interface MenuProducerFeign {

    @RequestMapping("/menu")
    List<TMenu> getTMenuAll();

    @RequestMapping("/menu/{page}/{rows}")
    LayUIDataGrid getTMenuByPage(@PathVariable int page, @PathVariable int rows);

    @RequestMapping("/menuAType/{page}/{rows}")
    LayUIDataGrid getTMenuAndTTypeByPage(@PathVariable int page, @PathVariable int rows);

    @RequestMapping("/delete/{id}")
    int delTMenuById(@PathVariable int id);

    @RequestMapping("/selTMenuById/{id}")
    TMenu selTMenuById(@PathVariable int id);

    @RequestMapping("/selTTypeAll")
    List<TType> selTTypeAll();

    @RequestMapping("/update")
    int updTMenu(@RequestBody TMenu tMenu);

    @RequestMapping("/selTMenuAndTTypeById/{id}")
    TMenuAndTType selTMenuAndTTypeById(@PathVariable int id);

    @RequestMapping("/insTMenu")
    int insTMenu(@RequestBody TMenu tMenu);
}
