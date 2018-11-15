package com.su5.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.su5.dao.GoodsDao;
import com.su5.entry.Goods;
import com.su5.service.GoodsService;
import com.su5.utils.UUIDUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001515:40
 * @Version 1.0
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Goods getGoods(String id) {
        return goodsDao.getGoods(id);
    }

    @Override
    public PageInfo listGoods(int page, int size, Goods goods) {
        PageHelper.startPage(page, size);
        return new PageInfo(goodsDao.listGoods(page, size, goods));
    }

    @Override
    public boolean updateOrSaveGoods(Goods goods) {
        if (StringUtils.isNotBlank(goods.getId())) {
            return goodsDao.updateGoods(goods) > 0;
        }
        goods.setId(UUIDUtils.getUUID());
        return goodsDao.saveGoods(goods) > 0;
    }

}
