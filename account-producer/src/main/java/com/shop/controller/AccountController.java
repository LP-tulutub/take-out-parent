package com.shop.controller;

import com.shop.mapper.TAdminMapper;
import com.shop.mapper.TUserMapper;
import com.shop.pojo.Account;
import com.shop.pojo.TAdmin;
import com.shop.pojo.TAdminExample;
import com.shop.pojo.TUserExample;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private TUserMapper tUserMapper;
    @Resource
    private TAdminMapper tAdminMapper;

    @RequestMapping("/login")
    public Object login(@RequestBody Account account){
        String type = account.getType();
        Object object = null;
        switch (type){
            case "user":
                TUserExample tUserExample = new TUserExample();
                tUserExample.createCriteria()
                        .andUsernameEqualTo(account.getUsername())
                        .andPasswordEqualTo(account.getPassword());
                object = this.tUserMapper.selectByExample(tUserExample);
                break;
            case "admin":
                TAdminExample tAdminExample = new TAdminExample();
                tAdminExample.createCriteria()
                        .andUsernameEqualTo(account.getUsername())
                        .andPasswordEqualTo(account.getPassword());
                object = this.tAdminMapper.selectByExample(tAdminExample);
                break;
        }
        return object;
    }


}
