package com.FrameWork.FundamentosSpringBoot.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{
    private String name;
    private String apellido;

    public MyBeanWithPropertiesImplement(String name, String apelike) {
        this.name = name;
        this.apellido = apelike;
    }

    @Override
    public String funcion() {
        return name + "-" + apellido;
    }
}
