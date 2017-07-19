package com.xkcoding.controller;

import com.github.pagehelper.PageHelper;
import com.xkcoding.bean.vo.ResultVO;
import com.xkcoding.service.UserInfoService;
import com.xkcoding.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("/userInfos/{pageNum}/{pageSize}")
	public ResultVO findByPages(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
		pageNum = pageNum == null ? 0 : pageNum;
		pageSize = pageSize == null ? 1 : pageSize;
		PageHelper.startPage(pageNum, pageSize);
		return ResultVOUtil.success(userInfoService.findAll());
	}


}
