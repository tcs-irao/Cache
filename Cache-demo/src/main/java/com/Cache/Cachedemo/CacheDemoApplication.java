package com.Cache.Cachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan("com.Cache.Cachedemo")
public class CacheDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CacheDemoApplication.class, args);
	}

}
