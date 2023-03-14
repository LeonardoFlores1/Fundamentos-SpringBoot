package com.FrameWork.FundamentosSpringBoot.configuration;

import com.FrameWork.FundamentosSpringBoot.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfiguration {
    @Bean
    public MyBean beanOperation(){
        //return new MyBeanImplement(); //esta instancia es de MyBeanImplemeant.java
        return new MyBean2Implement(); //con esta instancia en la configuracion elegimos otra funcionalidad
    }

    @Bean
    public MyOperation beanOperation2(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperation3(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
