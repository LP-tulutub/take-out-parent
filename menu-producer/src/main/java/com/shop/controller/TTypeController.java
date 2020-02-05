package com.shop.controller;

import com.shop.pojo.TType;
import com.shop.service.impl.TTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TTypeController {
    @Autowired
    private TTypeServiceImpl tTypeServiceImpl;

    /**
     * 查询TType类型全部
     * @return
     */
    @RequestMapping("/selTTypeAll")
    public List<TType> selAll(){
        return this.tTypeServiceImpl.selAll();
    }

}
