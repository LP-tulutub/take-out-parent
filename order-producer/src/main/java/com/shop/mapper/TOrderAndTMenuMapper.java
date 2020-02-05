package com.shop.mapper;

import com.shop.pojo.TOrderAndTMenu;
import com.shop.pojo.TOrderAndTMenuAndTUser;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TOrderAndTMenuMapper {

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "mid", column = "mid"),
            @Result(property = "tMenu", column = "mid", one = @One(select = "com.shop.mapper.TMenuMapper.selectByPrimaryKey"))
    })
    @Select("select * from t_order where uid=#{uid}")
    List<TOrderAndTMenu> selByOderAndMenu(int uid);

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "mid", column = "mid"),
            @Result(property = "tUser", column = "uid", one = @One(select = "com.shop.mapper.TUserMapper.selectByPrimaryKey")),
            @Result(property = "tMenu", column = "mid", one = @One(select = "com.shop.mapper.TMenuMapper.selectByPrimaryKey"))
    })
    @Select("select * from t_order where state=#{state}")
    List<TOrderAndTMenuAndTUser> selAllByState(int state);

}
