package com.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.TOrderAndTMenuMapper;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TOrderAndTMenu;
import com.shop.pojo.TOrderAndTMenuAndTUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TOrderAndTMenuController {
    @Resource
    private TOrderAndTMenuMapper tOrderAndTMenuMapper;

    /**
     * 联合查询：查询用户订单+订单的商品详细信息
     * @param uid
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findAllByUid/{uid}/{page}/{rows}")
    public LayUIDataGrid findAllByUid(@PathVariable int uid, @PathVariable int page, @PathVariable int rows){
        //设置分页条件
        PageHelper.startPage(page, rows);
        List<TOrderAndTMenu> list = this.tOrderAndTMenuMapper.selByOderAndMenu(uid);
        PageInfo<TOrderAndTMenu> pi = new PageInfo<>(list);
        //放入到实体类
        LayUIDataGrid dateGrid = new LayUIDataGrid();
        dateGrid.setCode(0);
        dateGrid.setMsg("OK");
        dateGrid.setCount((int) pi.getTotal());
        dateGrid.setData(pi.getList());

        return dateGrid;
    }

    /**
     * 联合查询：按state+查询用户订单+订单的商品详细信息
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/findAllByState/{page}/{rows}")
    public LayUIDataGrid findAllByState(@PathVariable int page, @PathVariable int rows){
        //设置分页条件
        PageHelper.startPage(page, rows);
        List<TOrderAndTMenuAndTUser> list = this.tOrderAndTMenuMapper.selAllByState(0);
        PageInfo<TOrderAndTMenuAndTUser> pi = new PageInfo<>(list);
        //放入到实体类
        LayUIDataGrid dateGrid = new LayUIDataGrid();
        dateGrid.setCode(0);
        dateGrid.setMsg("OK");
        dateGrid.setCount((int) pi.getTotal());
        dateGrid.setData(pi.getList());

        return dateGrid;
    }

}
