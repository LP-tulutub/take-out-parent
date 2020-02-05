package com.shop.controller;

import com.shop.feigen.MenuProducerFeign;
import com.shop.pojo.TMenu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private MenuProducerFeign menuProducerFeign;

    /**
     * 按id删除TMenu
     * @param id
     * @return
     */
    @RequestMapping("/menu/delete/{id}")
    public String delTMenuById(@PathVariable int id){
        int i = this.menuProducerFeign.delTMenuById(id);
        if (i==1){
            return "redirect:/adminHome";
        }else {
            return "error";
        }
    }

    /**
     * 修改TMenu
     * @param tMenu
     * @return
     */
    @RequestMapping("/menu/update")
    public String updTMenuById(TMenu tMenu){
        System.err.println(tMenu);
        int i = this.menuProducerFeign.updTMenu(tMenu);
        if (i==1){
            return "redirect:/adminHome";
        }else {
            return "error";
        }
    }

    /**
     * 新增TMenu
     * @param tMenu
     * @return
     */
    @RequestMapping("/menu/save")
    public String insTMenu(TMenu tMenu){
        int i = this.menuProducerFeign.insTMenu(tMenu);
        if (i==1){
            return "redirect:/adminHome";
        }else {
            return "error";
        }
    }

}
