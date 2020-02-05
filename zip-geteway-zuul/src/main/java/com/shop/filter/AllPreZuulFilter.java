package com.shop.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AllPreZuulFilter extends ZuulFilter{
    /**
     * 类型包含pre post route error
     * pre 代表在路由代理之前执行
     * route 达标代理的时候执行
     * error 代表出错的时候执行
     * post 代表在route或者是error执行完成后执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 这个值代表filter的优先顺序，值越小越优先
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否使用这个过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //写过滤条件
        return false;
    }

    /**
     * 具体需要做的事务
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取请求头的内容
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        String requestURL = req.getRequestURL().toString();
        System.err.println("AllPreZuulFilter已执行: "+requestURL);
        //重定向
        try {
            ctx.getResponse().sendRedirect("#设置重定向的url");
        } catch (IOException e) {}
        return null;
    }
}
