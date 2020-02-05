package com.shop.controller;

import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenu;
import com.shop.pojo.TMenuAndTType;
import com.shop.pojo.TType;
import com.shop.service.TMenuAndTTypeService;
import com.shop.service.impl.TMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TMenuController {
    @Autowired
    private TMenuServiceImpl tMenuServiceImpl;
    @Autowired
    private TMenuAndTTypeService tMenuAndTTypeServiceImpl;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/menu")
    public List<TMenu> welcome(){
        return this.tMenuServiceImpl.selAll();
    }

    /**
     * 分页查询TMenu
     * @param page 页码
     * @param rows 每页条数
     * @return
     */
    @RequestMapping("/menu/{page}/{rows}")
    public LayUIDataGrid welcome(@PathVariable int page, @PathVariable int rows){
        LayUIDataGrid layUIDataGrid = this.tMenuServiceImpl.selAllByPage(page, rows);
        return layUIDataGrid;
    }

    /**
     * TMenu和TType联合查询全部+分页
     * @param page 页码
     * @param rows 每页条数
     * @return
     */
    @RequestMapping("/menuAType/{page}/{rows}")
    public LayUIDataGrid selAllByMenuAType(@PathVariable int page, @PathVariable int rows){
        return this.tMenuAndTTypeServiceImpl.selAllByMenuAndType(page, rows);
    }

    /**
     * 按id删除TMenu
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public int delTMenuById(@PathVariable int id){
        return this.tMenuServiceImpl.delTMenuById(id);
    }

    /**
     * 按id修改TMenu
     * @param tMenu
     * @return
     */
    @RequestMapping("/update")
    public int updTMenu(@RequestBody TMenu tMenu){
        return this.tMenuServiceImpl.updTMenu(tMenu);
    }

    /**
     * 按id查询TMenu
     * @param id
     * @return
     */
    @RequestMapping("/selTMenuById/{id}")
    TMenu selById(@PathVariable int id){
        return this.tMenuServiceImpl.selById(id);
    }

    /**
     * 按TMenu的id联合查询
     * @param id
     * @return
     */
    @RequestMapping("/selTMenuAndTTypeById/{id}")
    TMenuAndTType selTMenuAndTTypeById(@PathVariable int id){
        return this.tMenuAndTTypeServiceImpl.selTMenuAndTTypeById(id);
    }

    /**
     * 新增TMenu
     * @param tMenu
     * @return
     */
    @RequestMapping("/insTMenu")
    public int insTMenu(@RequestBody TMenu tMenu){
        return this.tMenuServiceImpl.insTMenu(tMenu);
    }
}
