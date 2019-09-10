package com.adc.databaseConnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Copyright@http://github.com/guogewudi
 * Author:国宇航
 * Date:2019/9/10
 * Description:
 */
@SpringBootApplication

public class DataBaseConnectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseConnectionApplication.class,args);

    }


}
