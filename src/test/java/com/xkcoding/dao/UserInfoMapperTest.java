package com.xkcoding.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xkcoding.bean.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoMapperTest {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Test
	public void selectAll() throws Exception {
		PageHelper.startPage(1, 2);
		List<UserInfo> userInfos = userInfoMapper.selectAll();
		Page page = (Page) userInfos;
		log.info("totalRow: {}, totalPage: {}, currentPage: {}, pageSize: {}", page.getTotal(), page.getPages(), page.getPageNum(), page.getPageSize());
		log.info("userInfos = {}", userInfos);
		Assert.assertNotEquals(0, userInfos.size());
	}

	@Test
	public void selectById() throws Exception {
		UserInfo userInfo = userInfoMapper.selectById("11111");
		log.info("userInfo = {}", userInfo);
		Assert.assertNotNull(userInfo);
	}

}