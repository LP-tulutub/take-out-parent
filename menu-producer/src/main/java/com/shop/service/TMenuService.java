package com.shop.service;

import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenu;

import java.util.List;

public interface TMenuService {

    /**
     * 查询全部
     * @return
     */
    List<TMenu> selAll();
    /**
     * 分页查询全部
     * @param page 第几页
     * @param rows 每页几条
     * @return
     */
    LayUIDataGrid selAllByPage(int page, int rows);

    /**
     * 按id删除菜品
     * @param id
     * @return
     */
    int delTMenuById(int id);

    /**
     * 修改TMenu
     * @param tMenu
     * @return
     */
    int updTMenu(TMenu tMenu);

    /**
     * 按id查询
     * @param id
     * @return
     */
    TMenu selById(int id);

    /**
     * 新增TMenu
     * @param tMenu
     * @return
     */
    int insTMenu(TMenu tMenu);
}
