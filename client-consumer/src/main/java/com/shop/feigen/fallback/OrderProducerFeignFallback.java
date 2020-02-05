package com.shop.feigen.fallback;

import com.shop.feigen.OrderProducerFeign;
import com.shop.pojo.LayUIDataGrid;
import com.shop.pojo.TOrder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderProducerFeignFallback implements OrderProducerFeign {
    @Override
    public List<TOrder> selAll() {
        return null;
    }

    @Override
    public LayUIDataGrid selAllByPage(int page, int rows) {
        return null;
    }

    @Override
    public int ins(TOrder tOrder) {
        return 0;
    }

    @Override
    public int upd(TOrder tOrder) {
        return 0;
    }

    @Override
    public List<TOrder> selByUid(int uid) {
        return null;
    }

    @Override
    public LayUIDataGrid selByUidAndPage(int uid, int page, int rows) {
        return null;
    }

    @Override
    public LayUIDataGrid findAllByUid(int uid, int page, int rows) {
        return null;
    }

    @Override
    public LayUIDataGrid findAllByState(int page, int rows) {
        return null;
    }
}
