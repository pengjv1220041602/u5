package com.su5.dao.provider;

import com.su5.constants.Code;
import com.su5.entry.Goods;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001515:54
 * @Version 1.0
 * @Description:
 */
@Slf4j
public class GoodsProvider {

    public String listGoods (Goods goods) {
        String sql = new SQL(){
            {
                SELECT("id as id, name as name");
                FROM("t_goods");
                WHERE("flag = " + Code.EXIST_CODE);
                if (StringUtils.isNotBlank(goods.getName())) {
                    AND();
                    WHERE("name = #{name}");
                }
            }
        }.toString();
        log.debug(String.format("list Goods sql -------------------->%s", sql));
        return sql;
    }

    public String updateGoods(Goods goods) {
        String sql = new SQL(){
                {
                   UPDATE("t_goods");
                   if (StringUtils.isNotBlank(goods.getName())) {
                       SET("name = #{name}");
                   }
                   if (goods.getFlag() != null) {
                       SET("flag = #{flag}");
                   }
                   WHERE("id = #{id}");
                }
        }.toString();
        log.debug(String.format("update Goods sql -------------------->%s", sql));
        return sql;
    }

}
