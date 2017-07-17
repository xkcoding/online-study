package com.xkcoding.enums;

import lombok.Getter;

/**
 * 异常返回的枚举类
 *
 * @author	Yangkai.Shen
 * @version	1.0
 * @date	2017.07.17 at 11:31:27
 */
@Getter
public enum ResultEnum {
    ;

    private Integer code;
    private String  msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg  = msg;
    }
}
