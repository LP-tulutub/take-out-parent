package com.shop.pojo;


import java.io.Serializable;

public class TMenuAndTType extends TMenu implements Serializable {
    private TType tType;

    public TMenuAndTType() {
    }

    public TMenuAndTType(TType tType) {
        this.tType = tType;
    }

    public TType gettType() {
        return tType;
    }

    public void settType(TType tType) {
        this.tType = tType;
    }

}
