package com.shop.service.impl;

import com.shop.mapper.TTypeMapper;
import com.shop.pojo.TType;
import com.shop.pojo.TTypeExample;
import com.shop.service.TTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TTypeServiceImpl implements TTypeService {
    @Resource
    private TTypeMapper tTypeMapper;

    /**
     * 查询TType类型全部
     * @return
     */
    @Override
    public List<TType> selAll() {
        return this.tTypeMapper.selectByExample(new TTypeExample());
    }
}
