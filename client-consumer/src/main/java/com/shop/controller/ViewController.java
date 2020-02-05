package com.shop.controller;

import com.shop.feigen.MenuProducerFeign;
import com.shop.pojo.TMenuAndTType;
import com.shop.pojo.TType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {
    @Resource
    private MenuProducerFeign menuProducerFeign;

    /**
     * 管理员：连接修改TMenu的视图
     * @return
     */
    @RequestMapping("/menu/update/{id}")
    public String updTMenu(Model model, @PathVariable int id){
        List<TType> typeList = this.menuProducerFeign.selTTypeAll();
        TMenuAndTType tMenuAndTType = this.menuProducerFeign.selTMenuAndTTypeById(id);
        model.addAttribute("list", typeList);
        model.addAttribute("menu", tMenuAndTType);
        return "menu_update";
    }

    /**
     * 管理员：连接新增TMenu的视图
     * @param model
     * @return
     */
    @RequestMapping("/menu/insert")
    public String updTMenu(Model model){
        List<TType> typeList = this.menuProducerFeign.selTTypeAll();
        model.addAttribute("list", typeList);
        return "menu_add";
    }

    /**
     * 用户：连接查询TOrder的视图
     * @return
     */
    @RequestMapping("/account/redirect/order")
    public String selOrderByUidAndPage(){
        return "order";
    }

    /**
     * 管理员：连接查询TOrder的视图
     * @return
     */
    @RequestMapping("/account/redirect/order_handler")
    public String orderHandler(){
        return "order_handler";
    }

    /**
     * 管理员：连接查询TMenu的视图
     * @return
     */
    @RequestMapping("/account/redirect/menu_manage")
    public String menuManage(){
        return "menu_manage";
    }

    /**
     * 管理员：连接新增TUser的视图
     * @return
     */
    @RequestMapping("/account/redirect/user_add")
    public String useAdd(){
        return "user_add";
    }

    /**
     * 管理员：连接查询TUser的视图
     * @return
     */
    @RequestMapping("/account/redirect/user_manage")
    public String userManage(){
        return "user_manage";
    }
}
