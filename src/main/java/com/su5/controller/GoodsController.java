package com.su5.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.su5.constants.Code;
import com.su5.entry.Goods;
import com.su5.service.GoodsService;
import com.su5.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001515:39
 * @Version 1.0
 * @Description:
 */
@Controller
@ResponseBody
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods/{id}")
    public Result goodsById (@PathVariable("id") String id) {
        Result result = new Result();
        try {
            final Goods goods = goodsService.getGoods(id);
            return result.builder().code(Code.SUCCESS_CODE).data(goods).message("查询成功").build();
        } catch (Exception e) {
            return result.builder().code(Code.EXCEPTION_CODE).message("出现异常").build();
        }
    }

    @GetMapping("/goods")
    public Result goodsByIdPa (@RequestParam("id") String id) {
        Result result = new Result();
        try {
            final Goods goods = goodsService.getGoods(id);
            return result.builder().code(Code.SUCCESS_CODE).data(goods).message("查询成功").build();
        } catch (Exception e) {
            return result.builder().code(Code.EXCEPTION_CODE).message("出现异常").build();
        }
    }
}
