package com.xkcoding.bean.vo;

import lombok.Data;

/**
 * 返回页面的结果对象
 *
 * @param <T> 返回的 data 的泛型对象
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.13 at 10:22:36
 */
@Data
public class ResultVO<T> {
	private Integer code;
	private String msg;
	private T data;
}