package com.su5.controller;

import com.su5.constants.Code;
import com.su5.entry.Goods;
import com.su5.service.GoodsService;
import com.su5.utils.Result;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping(path = "/goods/{id}")
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

    @PostMapping(path = "/goods")
    public Result updateOrSaveGoods(@RequestBody Goods goods) {
        try {
            final boolean flag = goodsService.updateOrSaveGoods(goods);
            if (flag) {
                return new Result().builder().code(Code.SUCCESS_CODE).data(Boolean.TRUE).message("添加成功").build();
            }
        } catch (Exception e) {
            log.error("exception");
            return new Result().builder().code(Code.EXCEPTION_CODE).data(Boolean.FALSE).message("添加失败"+e).build();
        }
        return new Result().builder().code(Code.ERROER_CODE).data(Boolean.FALSE).message("添加失败").build();
    }

    @GetMapping(path = "/listgood")
    public Result listBook (int page, int size, Goods goods) {
        return
            new Result().builder().code(Code.SUCCESS_CODE)
                    .data(goodsService.listGoods(page, size, goods)).message("查询成功！").build();
    }
}
