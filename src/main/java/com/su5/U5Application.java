package com.su5;

import com.su5.dao.GoodsDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001515:37
 * @Version 1.0
 * @Description:
 */
@SpringBootApplication
@MapperScan(basePackageClasses = GoodsDao.class)
public class U5Application {

    public static void main(String[] args) {
        SpringApplication.run(U5Application.class,args);
    }

}
