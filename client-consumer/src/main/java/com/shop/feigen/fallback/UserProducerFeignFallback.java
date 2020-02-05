package com.shop.feigen.fallback;

import com.shop.feigen.UserProducerFeign;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserProducerFeignFallback implements UserProducerFeign {


    @Override
    public List<TUser> selAll() {
        return null;
    }

    @Override
    public LayUIDataGrid selAllByPage(int page, int rows) {
        return null;
    }

    @Override
    public String selByTUser(TUser tUser) {
        return null;
    }

    @Override
    public int ins(TUser tUser) {
        return 0;
    }

    @Override
    public int updPasswordById(TUser tUser) {
        return 0;
    }
}
