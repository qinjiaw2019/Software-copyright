package com.cloud.station;

import com.cloud.station.controller.socket.Instructions;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.cloud.station.mapper")
@ServletComponentScan//扫描所有的监听注解(@WebListener)
@EnableCaching//使用缓存(Redis)
//public class WebappApplication {
//	public static void main(String[] args) {
//		SpringApplication.run(WebappApplication.class, args);
//	}
//}
//部署时候用
public class WebappApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebappApplication.class);
	}

}
