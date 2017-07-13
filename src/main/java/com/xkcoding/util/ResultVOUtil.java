package com.xkcoding.util;

import com.xkcoding.bean.vo.ResultVO;
import com.xkcoding.enums.ResultStatusEnum;

/**
 * 返回页面的结果对象封装工具类
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.13 at 10:37:46
 */
public class ResultVOUtil {

	/**
	 * 操作失败的方法
	 *
	 * @return 返回页面的结果对象
	 */
	public static ResultVO fail() {
		ResultVO resultVO = new ResultVO();

		resultVO.setCode(ResultStatusEnum.FAIL.getCode());
		resultVO.setMsg(ResultStatusEnum.FAIL.getMsg());

		return resultVO;
	}

	/**
	 * 操作成功，但不返回数据
	 *
	 * @return 返回页面的结果对象
	 */
	public static ResultVO success() {
		return success(null);
	}

	/**
	 * 操作成功，返回数据
	 *
	 * @param object 返回给页面的数据
	 * @return 返回页面的结果对象
	 */
	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();

		resultVO.setCode(ResultStatusEnum.SUCCESS.getCode());
		resultVO.setMsg(ResultStatusEnum.SUCCESS.getMsg());
		resultVO.setData(object);

		return resultVO;
	}
}