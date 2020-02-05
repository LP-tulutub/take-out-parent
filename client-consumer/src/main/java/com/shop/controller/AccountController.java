package com.shop.controller;

import com.shop.feigen.AccountProducerFeign;
import com.shop.pojo.Account;
import com.shop.pojo.TAdmin;
import com.shop.pojo.TUser;
import com.shop.utils.CookieUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountProducerFeign accountProducerFeign;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/login")
    public String login(Account account, HttpServletRequest req, HttpServletResponse rep){
        //访问数据库登陆
        Object object = this.accountProducerFeign.login(account);
        if (object!=null){
            String key = UUID.randomUUID().toString();
            switch (account.getType()){
                case "user":
                    //登陆成功，把用户记在redis中,
                    List<TUser> listUser = (List<TUser>) object;
                    this.redisTemplate.opsForValue().set(key, listUser.get(0));
                    this.redisTemplate.expire(key, 60*60, TimeUnit.SECONDS);
                    //把redis的key存到cookies中
                    CookieUtils.setCookie(req, rep, "TT_TOKEN", key, 60*60);
                    //完成登陆后重定向到首页
                    return "redirect:/userHome";
                case "admin":
                    //登陆成功，把用户记在redis中
                    List<TAdmin> listAdmin = (List<TAdmin>) object;
                    this.redisTemplate.opsForValue().set(key, listAdmin.get(0));
                    this.redisTemplate.expire(key, 60*60, TimeUnit.SECONDS);
                    //把redis的key存到cookies中
                    CookieUtils.setCookie(req, rep, "TT_TOKEN", key, 60*60);
                    //完成登陆后重定向到首页
                    return "redirect:/adminHome";
            }
        }
    return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req, HttpServletResponse rep){
        //删除redis的用户数据
        String token = CookieUtils.getCookieValue(req, "TT_TOKEN");
        this.redisTemplate.delete(token);
        //删除浏览器的cookies
        CookieUtils.deleteCookie(req, rep, "TT_TOKEN");
        return "login";
    }
}
