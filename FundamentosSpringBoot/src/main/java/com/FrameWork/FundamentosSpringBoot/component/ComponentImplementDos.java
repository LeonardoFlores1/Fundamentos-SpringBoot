package com.FrameWork.FundamentosSpringBoot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplementDos implements IComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Metodo saludar desde segunda dependencia");
    }
}
