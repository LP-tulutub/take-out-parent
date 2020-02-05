package com.shop.feigen.fallback;

import com.shop.feigen.MenuProducerFeign;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenu;
import com.shop.pojo.TMenuAndTType;
import com.shop.pojo.TType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuProducerFeignFallback implements MenuProducerFeign {
    @Override
    public List<TMenu> getTMenuAll() {
        TMenu tMenu = new TMenu();
        tMenu.setName("错误");
        List<TMenu> list = new ArrayList<>();
        list.add(tMenu);
        return list;
    }

    @Override
    public LayUIDataGrid getTMenuByPage(int page, int rows) {
        LayUIDataGrid layUIDataGrid = new LayUIDataGrid();
        layUIDataGrid.setCode(0);
        layUIDataGrid.setMsg("ERROR: getTMenuByPage");
        layUIDataGrid.setCount(0);
        //layUIDataGrid.setData(null);
        return layUIDataGrid;
    }

    @Override
    public LayUIDataGrid getTMenuAndTTypeByPage(int page, int rows) {
        LayUIDataGrid layUIDataGrid = new LayUIDataGrid();
        layUIDataGrid.setCode(0);
        layUIDataGrid.setMsg("ERROR: getTMenuAndTTypeByPage");
        layUIDataGrid.setCount(0);
        //layUIDataGrid.setData(null);
        return layUIDataGrid;
    }

    @Override
    public int delTMenuById(int id) {
        return 0;
    }

    @Override
    public TMenu selTMenuById(int id) {
        return null;
    }

    @Override
    public int updTMenu(TMenu tMenu) {
        return 0;
    }

    @Override
    public TMenuAndTType selTMenuAndTTypeById(int id) {
        return null;
    }

    @Override
    public int insTMenu(TMenu tMenu) {
        return 0;
    }

    @Override
    public List<TType> selTTypeAll() {
        return null;
    }
}
