package com.xkcoding.util;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.util.ClassUtils;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;

/**
 * Mapper 名字生成器
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.18 at 12:07:47
 */
public class MapperNameGenerator implements BeanNameGenerator {
	Map<String, Integer> nameMap = new HashMap<String, Integer>();

	@Override
	public String generateBeanName(BeanDefinition beanDefinition, BeanDefinitionRegistry beanDefinitionRegistry) {

		// 获取类的名字，如 UserInfoMapper
		String shortClassName = ClassUtils.getShortName(beanDefinition.getBeanClassName());

		// 将类名转化为规范的变量名，如 userInfoMapper
		String beanName = Introspector.decapitalize(shortClassName);

		// 判断名字是否已经存在，如果存在，则在名字后面添加序号
		if (nameMap.containsKey(beanName)) {
			int index = nameMap.get(beanName) + 1;
			nameMap.put(beanName, index);
			// 增加序号
			beanName += index;
		} else {
			nameMap.put(beanName, 1);
		}

		return beanName;
	}
}
