package com.FrameWork.FundamentosSpringBoot.configuration;

import com.FrameWork.FundamentosSpringBoot.bean.MyBeanWithProperties;
import com.FrameWork.FundamentosSpringBoot.bean.MyBeanWithPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties funcion(){
        return new MyBeanWithPropertiesImplement(name, apellido);
    }
}
