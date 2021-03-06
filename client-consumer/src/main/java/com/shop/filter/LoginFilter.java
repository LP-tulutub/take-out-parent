package com.shop.filter;

import com.shop.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

@WebFilter(filterName = "RunNO2", urlPatterns = {"/userHome","/menu/*","/view/*","/order/*"})
public class LoginFilter implements Filter {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;

        //检查是否登录，用redis检查，没有登录重定向到登陆页面
        String token = CookieUtils.getCookieValue(req, "TT_TOKEN");
        if (token == null || token.equals("")) {
            rep.sendRedirect("http://192.168.1.106:11002/");
        } else {
            Object obj = this.redisTemplate.opsForValue().get(token);
            if (obj == null) {
                rep.sendRedirect("http://192.168.1.106:11002/");
            }
            LinkedHashMap<String, String> hashMap = (LinkedHashMap) obj;
            req.setAttribute("username", hashMap.get("username"));
        }
        //已登录放行
        filterChain.doFilter(req, rep);
    }

}
