package com.shop.controller;

import com.shop.feigen.UserProducerFeign;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserProducerFeign userProducerFeign;

    /**
     * 分页查询用户全部TUser
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public LayUIDataGrid selAllByPage(int page, int limit){
        return this.userProducerFeign.selAllByPage(page, limit);
    }

    /**
     * 新增用户TUser
     * @param tUser
     * @return
     */
    @RequestMapping("/save")
    public String save(TUser tUser){
        int i = this.userProducerFeign.ins(tUser);
        if (i==1){
            return "user_manage";
        }
        return "error";
    }

}
