package com.xkcoding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xkcoding.bean.vo.ResultVO;
import com.xkcoding.util.ResultVOUtil;

/**
 * 测试返回页面的结果对象 Controller
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.13 at 10:45:50
 */
@RestController()
@RequestMapping("/test")
public class TestController {

	/**
	 * 测试返回页面的结果对象
	 *
	 * @return 返回页面的结果对象
	 */
	@RequestMapping("/")
	public ResultVO test() {
		return ResultVOUtil.success();
	}
}