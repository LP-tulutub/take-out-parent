package com.shop.mapper;

import com.shop.pojo.TMenu;
import com.shop.pojo.TMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    long countByExample(TMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int deleteByExample(TMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int insert(TMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int insertSelective(TMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    List<TMenu> selectByExample(TMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    TMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TMenu record, @Param("example") TMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TMenu record, @Param("example") TMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TMenu record);
}