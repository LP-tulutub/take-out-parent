package com.shop.pojo;

import java.io.Serializable;

public class TOrderAndTMenuAndTUser extends TOrder implements Serializable {
    private TMenu tMenu;
    private TUser tUser;

    public TOrderAndTMenuAndTUser() {
    }

    public TOrderAndTMenuAndTUser(TMenu tMenu, TUser tUser) {
        this.tMenu = tMenu;
        this.tUser = tUser;
    }

    public TMenu gettMenu() {
        return tMenu;
    }

    public void settMenu(TMenu tMenu) {
        this.tMenu = tMenu;
    }

    public TUser gettUser() {
        return tUser;
    }

    public void settUser(TUser tUser) {
        this.tUser = tUser;
    }
}
