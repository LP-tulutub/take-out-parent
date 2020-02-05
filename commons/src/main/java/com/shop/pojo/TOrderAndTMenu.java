package com.shop.pojo;

import java.io.Serializable;

public class TOrderAndTMenu extends TOrder implements Serializable {
    private TMenu tMenu;

    public TOrderAndTMenu() {
    }

    public TOrderAndTMenu(TMenu tMenu) {
        this.tMenu = tMenu;
    }

    public TMenu gettMenu() {
        return tMenu;
    }

    public void settMenu(TMenu tMenu) {
        this.tMenu = tMenu;
    }
}
