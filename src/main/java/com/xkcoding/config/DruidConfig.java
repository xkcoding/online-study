package com.xkcoding.config;

import java.sql.SQLException;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import lombok.extern.slf4j.Slf4j;

/**
 * Druid 配置类
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.07.17 at 05:27:53
 */
@Slf4j
@Configuration
public class DruidConfig {
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.initialSize}")
	private int initialSize;
	@Value("${spring.datasource.minIdle}")
	private int minIdle;
	@Value("${spring.datasource.maxActive}")
	private int maxActive;
	@Value("${spring.datasource.maxWait}")
	private int maxWait;
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;
	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${spring.datasource.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${spring.datasource.testOnReturn}")
	private boolean testOnReturn;
	@Value("${spring.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${spring.datasource.filters}")
	private String filters;
	@Value("${spring.datasource.connectionProperties}")
	private Properties connectionProperties;

	/**
	 * Druid 数据源
	 *
	 * @return DruidDataSource
	 */
	@Bean
	@Primary
	public DataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();

		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxWait(maxWait);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setPoolPreparedStatements(poolPreparedStatements);

		try {
			dataSource.setFilters(filters);
		} catch (SQLException e) {
			log.error("【 Druid 数据源初始化异常 】: {}", e.getStackTrace());
		}

		dataSource.setConnectProperties(connectionProperties);

		return dataSource;
	}

	/**
	 * 访问 Druid 的 Servlet
	 *
	 * @return 注册的 Servlet
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

		servletRegistrationBean.addInitParameter("loginUsername", "xkcoding");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		servletRegistrationBean.addInitParameter("resetEnable", "false");

		return servletRegistrationBean;
	}

	/**
	 * Druid 拦截器
	 *
	 * @return 注册的拦截器
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

		return filterRegistrationBean;
	}
}