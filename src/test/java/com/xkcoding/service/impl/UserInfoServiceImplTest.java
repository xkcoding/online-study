package com.xkcoding.service.impl;

import com.xkcoding.bean.entity.UserInfo;
import com.xkcoding.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoServiceImplTest {
	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void save() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		userInfo.setUsername("xkcoding");
		userInfo.setPassword("sfafa");
		userInfo.setSalt("saafas");
		userInfo.setPhone("11011101110");
		userInfo.setQqOpenid("1111");
		userInfo.setWxOpenid("2222");
		userInfo.setIp("10.0.0.1");
		userInfo.setIsTeacher(0);
		userInfo.setLoginTimes(0);
		userInfo.setLastTime(new Date());
		userInfo.setCreateTime(new Date());
		userInfo.setUpdateTime(new Date());

		UserInfo result = userInfoService.save(userInfo);

		Assert.assertNotNull(result);
	}

	@Test
	public void findAll() throws Exception {
		List<UserInfo> result = userInfoService.findAll();

		Assert.assertNotEquals(0, result.size());
	}

	@Test
	public void findById() throws Exception {
		UserInfo result = userInfoService.findById("11111");

		Assert.assertNotNull(result);
	}

}