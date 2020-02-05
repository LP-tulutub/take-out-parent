package com.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.TUserMapper;
import com.shop.pojo.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@Transactional
public class TUserController {
    @Resource
    private TUserMapper tUserMapper;

    @RequestMapping("/selAll")
    public List<TUser> selAll(){
        return this.tUserMapper.selectByExample(new TUserExample());
    }

    @RequestMapping("/selAllByPage/{page}/{rows}")
    public LayUIDataGrid selAllByPage(@PathVariable int page, @PathVariable int rows){
        //设置分页条件
        PageHelper.startPage(page, rows);
        List<TUser> list = this.tUserMapper.selectByExample(new TUserExample());
        //分页
        PageInfo<TUser> pi = new PageInfo<>(list);
        //放入到实体类
        LayUIDataGrid dateGrid = new LayUIDataGrid();
        dateGrid.setCode(0);
        dateGrid.setMsg("OK");
        dateGrid.setCount((int) pi.getTotal());
        dateGrid.setData(pi.getList());

        return dateGrid;
    }

    @RequestMapping("/selByTUser")
    public String selByTUser(@RequestBody TUser tUser){
        TUserExample tUserExample = new TUserExample();
        tUserExample.createCriteria()
                .andIdEqualTo(tUser.getId())
                .andUsernameEqualTo(tUser.getUsername())
                .andPasswordEqualTo(tUser.getPassword());
        List<TUser> tAdminList = this.tUserMapper.selectByExample(tUserExample);
        if (!tAdminList.isEmpty()){
            return "true";
        }else {
            return "false";
        }

    }

    @RequestMapping("/ins")
    public int insById(@RequestBody TUser tUser){
        //当前日期为注册日期
        Date date = new Date();
        tUser.setRegisterdate(date);
        return this.tUserMapper.insertSelective(tUser);
    }

    @RequestMapping("/updPasswordById")
    public int updPasswordById(@RequestBody TUser tUser){
        //username不能改
        tUser.setUsername(null);
        return this.tUserMapper.updateByPrimaryKeySelective(tUser);
    }
}
