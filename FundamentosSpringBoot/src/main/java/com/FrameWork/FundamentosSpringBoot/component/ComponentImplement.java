package com.FrameWork.FundamentosSpringBoot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements IComponentDependency{
    @Override
    public void saludar() {//metodo que se creo en la interfaz
        System.out.println("metodo implementado desde interfaz");
    }
}
