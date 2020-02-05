package com.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.TOrderMapper;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TOrder;
import com.shop.pojo.TOrderExample;

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
public class TOrderController {
    @Resource
    private TOrderMapper tOrderMapper;

    @RequestMapping("/selAll")
    public List<TOrder> selAll(){
        return this.tOrderMapper.selectByExample(new TOrderExample());
    }

    @RequestMapping("/selAllByPage/{page}/{rows}")
    public LayUIDataGrid selAllByPage(@PathVariable int page, @PathVariable int rows){
        //设置分页条件
        PageHelper.startPage(page, rows);
        List<TOrder> list = this.tOrderMapper.selectByExample(new TOrderExample());
        PageInfo<TOrder> pi = new PageInfo<>(list);
        //放入到实体类
        LayUIDataGrid dateGrid = new LayUIDataGrid();
        dateGrid.setCode(0);
        dateGrid.setMsg("OK");
        dateGrid.setCount((int) pi.getTotal());
        dateGrid.setData(pi.getList());

        return dateGrid;
    }

    @RequestMapping("/ins")
    public int ins(@RequestBody TOrder tOrder){
        Date date = new Date();
        tOrder.setDate(date);
        return this.tOrderMapper.insertSelective(tOrder);
    }

    @RequestMapping("/upd")
    public int upd(@RequestBody TOrder tOrder){
        //不能修改的属性
        tOrder.setDate(null);
        tOrder.setUid(null);
        tOrder.setMid(null);
        int keyUpd = this.tOrderMapper.updateByPrimaryKeySelective(tOrder);
        return keyUpd;
    }

    @RequestMapping("/selByUid/{uid}")
    public List<TOrder> selByUid(@PathVariable int uid){
        TOrderExample tOrderExample = new TOrderExample();
        tOrderExample.createCriteria().andUidEqualTo(uid);
        return this.tOrderMapper.selectByExample(tOrderExample);
    }

    @RequestMapping("/selByUidAndPage/{uid}/{page}/{rows}")
    public LayUIDataGrid selByUidAndPage(@PathVariable int uid, @PathVariable int page, @PathVariable int rows){
        //设置查询条件
        TOrderExample tOrderExample = new TOrderExample();
        tOrderExample.createCriteria().andUidEqualTo(uid);
        //设置分页条件
        PageHelper.startPage(page, rows);
        List<TOrder> list = this.tOrderMapper.selectByExample(tOrderExample);
        PageInfo<TOrder> pi = new PageInfo<>(list);
        //放入到实体类
        LayUIDataGrid dateGrid = new LayUIDataGrid();
        dateGrid.setCode(0);
        dateGrid.setMsg("OK");
        dateGrid.setCount((int) pi.getTotal());
        dateGrid.setData(pi.getList());

        return dateGrid;
    }



}
