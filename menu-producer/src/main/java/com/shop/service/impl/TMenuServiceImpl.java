package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.TMenuMapper;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TMenu;
import com.shop.pojo.TMenuExample;
import com.shop.service.TMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TMenuServiceImpl implements TMenuService {
    @Resource
    private TMenuMapper tMenuMapper;

    /**
     * 查询全部TMenu
     * @return
     */
    @Override
    public List<TMenu> selAll() {
        return this.tMenuMapper.selectByExample(new TMenuExample());
    }

    /**
     * 按分页查询全部TMenu
     * @param page 第几页
     * @param rows 每页几条
     * @return
     */
    @Override
    public LayUIDataGrid selAllByPage(int page, int rows) {
        PageHelper.startPage(page, rows);

        List<TMenu> list = this.tMenuMapper.selectByExample(new TMenuExample());
        //分页代码
        //设置分页条件
        PageInfo<TMenu> pi = new PageInfo<>(list);
        //放入到实体类
        LayUIDataGrid dateGrid = new LayUIDataGrid();
        dateGrid.setCode(0);
        dateGrid.setMsg("OK");
        dateGrid.setCount((int) pi.getTotal());

        List<TMenu> piList = pi.getList();
        dateGrid.setData(piList);

        return dateGrid;
    }

    /**
     * 按id删除菜品TMenu
     * @param id
     * @return
     */
    @Override
    public int delTMenuById(int id) {
        return this.tMenuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改TMenu
     * @param tMenu
     * @return
     */
    @Override
    public int updTMenu(TMenu tMenu) {
        return this.tMenuMapper.updateByPrimaryKey(tMenu);
    }

    /**
     * 按id查询TMenu
     * @param id
     * @return
     */
    @Override
    public TMenu selById(int id) {
        return this.tMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增TMenu
     * @param tMenu
     * @return
     */
    @Override
    public int insTMenu(TMenu tMenu) {
        return this.tMenuMapper.insertSelective(tMenu);
    }
}
