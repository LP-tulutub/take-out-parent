package com.shop.filter;

import com.shop.feigen.AccountProducerFeign;
import com.shop.pojo.Account;
import com.shop.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@WebFilter(filterName = "RunNO1", urlPatterns = {"/adminHome","/admin/*","/user/*"})
public class AdminFilter implements Filter {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private AccountProducerFeign accountProducerFeign;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse rep = (HttpServletResponse)servletResponse;
        //检查是否是管理员登录，用redis检查，没有登录重定向到登陆页面
        String token = CookieUtils.getCookieValue(req, "TT_TOKEN");
        if (token==null || token.equals("")){
            rep.sendRedirect("http://192.168.1.106:11002/");
        }else {
            Object obj = this.redisTemplate.opsForValue().get(token);
            //检查是否有该管理员
            LinkedHashMap<String, String> hashMap = (LinkedHashMap) obj;
            Account account = new Account();
            account.setUsername(hashMap.get("username"));
            account.setPassword(hashMap.get("password"));
            account.setType("admin");
            Object login = this.accountProducerFeign.login(account);
            if (login==null || login.equals((Object) new ArrayList<>())){
                rep.sendRedirect("http://192.168.1.106:11002/");
            }
            req.setAttribute("username", hashMap.get("username"));
        }
        //已登录放行
        filterChain.doFilter(req, rep);
    }
}
