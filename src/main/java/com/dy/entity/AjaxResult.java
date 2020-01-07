package com.dy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 黄俊
 * @date 2019/11/6 16:12
 * @Disc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResult {
    private boolean flag;
    private Object data;
}
