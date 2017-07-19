package com.xkcoding.repository;

import com.xkcoding.bean.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Test
	public void testSave() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("dhjask");
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

		UserInfo result = userInfoRepository.save(userInfo);

		Assert.assertNotNull(result);
	}
}