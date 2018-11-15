package com.su5.service;

import com.github.pagehelper.PageInfo;
import com.su5.entry.Goods;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001515:39
 * @Version 1.0
 * @Description:
 */
public interface GoodsService {

    Goods getGoods(String id);

    PageInfo listGoods(int page, int size, Goods goods);

    boolean updateOrSaveGoods(Goods goods);

}
