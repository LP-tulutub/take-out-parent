package com.shop.mapper;

import com.shop.pojo.TMenuAndTType;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TMenuAndTTypeMapper {

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "tid", column = "tid"),
            @Result(property = "tType", column = "tid", one = @One(select = "com.shop.mapper.TTypeMapper.selectByPrimaryKey"))
    })
    @Select("select * from takeout.t_menu")
    List<TMenuAndTType> selByMenuAndType();

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "tid", column = "tid"),
            @Result(property = "tType", column = "tid", one = @One(select = "com.shop.mapper.TTypeMapper.selectByPrimaryKey"))
    })
    @Select("select * from t_menu where id=#{id}")
    TMenuAndTType selTMenuAndTTypeById(int id);
}
