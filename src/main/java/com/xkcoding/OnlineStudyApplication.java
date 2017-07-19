package com.xkcoding;

import com.xkcoding.util.MapperNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.xkcoding.dao"}, nameGenerator = MapperNameGenerator.class)
public class OnlineStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStudyApplication.class, args);
	}
}
