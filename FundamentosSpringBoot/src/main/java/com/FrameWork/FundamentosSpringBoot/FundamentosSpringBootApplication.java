package com.FrameWork.FundamentosSpringBoot;

import com.FrameWork.FundamentosSpringBoot.bean.MyBean;
import com.FrameWork.FundamentosSpringBoot.bean.MyBeanWithDependency;
import com.FrameWork.FundamentosSpringBoot.bean.MyBeanWithProperties;
import com.FrameWork.FundamentosSpringBoot.bean.MyOperation;
import com.FrameWork.FundamentosSpringBoot.component.IComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosSpringBootApplication implements CommandLineRunner {
	private IComponentDependency iComponentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	@Autowired //en versiones mas nuevas de spring no es necesario declararlo
	//con @Qualifier decidimos la dependencia a utilizar
	public FundamentosSpringBootApplication(@Qualifier("componentImplementDos") IComponentDependency iComponentDependency,
											MyBean myBean, MyBeanWithDependency myBeanWithDependency,
											MyBeanWithProperties myBeanWithProperties){ //se debe crear un constructor
		System.out.println("arranca constructor");
		this.iComponentDependency = iComponentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
	}
	public static void main(String[] args) {
		System.out.println("main");
		SpringApplication.run(FundamentosSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("run");
		iComponentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.funcion());

	}
}
