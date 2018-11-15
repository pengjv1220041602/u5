package com.su5.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001515:45
 * @Version 1.0
 * @Description:
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    private String id;

    private String name;

    private Integer flag;

}
