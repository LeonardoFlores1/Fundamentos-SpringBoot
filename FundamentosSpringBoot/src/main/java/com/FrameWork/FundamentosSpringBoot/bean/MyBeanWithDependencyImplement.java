package com.FrameWork.FundamentosSpringBoot.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation){
        this.myOperation = myOperation;
    }
    @Override
    public void printWithDependency() {
        System.out.println(myOperation.sum(10));
        System.out.println("hola desde la implementacion de un bean con dependencia");
    }
}
