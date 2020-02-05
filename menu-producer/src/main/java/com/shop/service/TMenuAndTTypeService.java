package com.shop.service;

import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenuAndTType;

public interface TMenuAndTTypeService {

    /**
     * TMenu和TType联合查询全部+分页
     * @param page 页码
     * @param rows 每页条数
     * @return
     */
    LayUIDataGrid selAllByMenuAndType(int page, int rows);

    /**
     * 按TMenu的id联合查询
     * @param id
     * @return
     */
    TMenuAndTType selTMenuAndTTypeById(int id);


}
