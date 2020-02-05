package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.TMenuAndTTypeMapper;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenuAndTType;
import com.shop.service.TMenuAndTTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TMenuAndTTypeServiceImpl implements TMenuAndTTypeService {

    @Resource
    private TMenuAndTTypeMapper tMenuAndTTypeMapper;

    /**
     * TMenu和TType联合查询全部+分页
     * @param page 页码
     * @param rows 每页条数
     * @return
     */
    @Override
    public LayUIDataGrid selAllByMenuAndType(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<TMenuAndTType> list = this.tMenuAndTTypeMapper.selByMenuAndType();
        //分页代码
        //设置分页条件
        PageInfo<TMenuAndTType> pi = new PageInfo<>(list);
        //放入到实体类
        LayUIDataGrid dateGrid = new LayUIDataGrid();
        dateGrid.setCode(0);
        dateGrid.setMsg("OK");
        dateGrid.setCount((int) pi.getTotal());

        List<TMenuAndTType> piList = pi.getList();
        dateGrid.setData(piList);
        return dateGrid;
    }

    /**
     * 按TMenu的id联合查询
     * @param id
     * @return
     */
    @Override
    public TMenuAndTType selTMenuAndTTypeById(int id) {
        return this.tMenuAndTTypeMapper.selTMenuAndTTypeById(id);
    }
}
