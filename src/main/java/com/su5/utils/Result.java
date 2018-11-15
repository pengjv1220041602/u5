package com.su5.utils;

import javafx.scene.control.cell.PropertyValueFactory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ZhPJ
 * @Date 2018/11/15 001516:20
 * @Version 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    private int code ;

    private Object data;

    private String message;

}
