package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(){
        return "login";
    }

    @RequestMapping("/html/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/adminHome")
    public String adminHome(Model model, HttpServletRequest req){
        //查询用户名字
        Object username = req.getAttribute("username");
        model.addAttribute("adminName", username);
        return "main";
    }

    @RequestMapping("/userHome")
    public String userHome(Model model, HttpServletRequest req){
        //查询用户名字
        Object username = req.getAttribute("username");
        model.addAttribute("userName", username);
        return "index";
    }
}
