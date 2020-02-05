package com.shop.controller;

import com.shop.feigen.MenuProducerFeign;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuProducerFeign menuProducerFeign;

    /**
     * 测试查询全部
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public List<TMenu> getTMenuAll(){
        return this.menuProducerFeign.getTMenuAll();
    }

    /**
     * 分页查询
     * @param page 当前多少页
     * @param limit 每页多少条
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public LayUIDataGrid getTMenuByPage(int page, int limit){
        LayUIDataGrid layUIDataGrid = this.menuProducerFeign.getTMenuAndTTypeByPage(page, limit);
        return layUIDataGrid;
    }

}
