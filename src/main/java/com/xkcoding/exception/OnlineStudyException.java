package com.xkcoding.exception;

import com.xkcoding.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常类
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.17 at 11:32:30
 */
@Slf4j
public class OnlineStudyException extends RuntimeException {
	private Integer code;

	public OnlineStudyException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
		log.error("【 发生异常 】: 错误码: {}; 错误消息: {}", resultEnum.getCode(), resultEnum.getMsg());
	}

	public OnlineStudyException(Integer code, String msg) {
		super(msg);
		this.code = code;
		log.error("【 发生异常 】: 错误码: {}; 错误消息: {}", code, msg);
	}
}