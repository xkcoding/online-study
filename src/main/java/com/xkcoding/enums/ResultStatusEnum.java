package com.xkcoding.enums;

import lombok.Getter;

/**
 * 返回页面的结果对象的状态的枚举类
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.13 at 10:33:13
 */
@Getter
public enum ResultStatusEnum {
	SUCCESS(0, "successful"), FAIL(1, "failed");

	private Integer code;
	private String msg;

	ResultStatusEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}