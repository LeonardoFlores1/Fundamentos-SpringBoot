package com.FrameWork.FundamentosSpringBoot.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    private Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
    }
    @Override
    public void printWithDependency() {
        LOGGER.info("hemos ingresado al metodo printWithDependency");
        LOGGER.debug("se puso el numero: 10 como parametro");
        System.out.println(myOperation.sum(10));
        System.out.println("hola desde la implementacion de un bean con dependencia");
    }
}
