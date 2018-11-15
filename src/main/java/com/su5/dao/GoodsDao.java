package com.su5.dao;

import com.su5.constants.Code;
import com.su5.dao.provider.GoodsProvider;
import com.su5.entry.Goods;
import org.apache.ibatis.annotations.*;

import java.awt.print.Book;
import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001515:39
 * @Version 1.0
 * @Description:
 */
@Mapper
public interface GoodsDao {

    @Select("select id as id , name as name from t_goods where id = #{id} and flag = " + Code.EXIST_CODE)
    Goods getGoods(String id);

    @SelectProvider(type = GoodsProvider.class, method = "listGoods")
    List<Goods> listGoods(Goods goods);

    @UpdateProvider(type = GoodsProvider.class, method = "updateGoods")
    int updateGoods(Goods goods);

    @Insert("insert into t_goods (id, `name`,flag) values (#{id}, #{name}, #{flag})")
    int saveGoods(Goods goods);

}
