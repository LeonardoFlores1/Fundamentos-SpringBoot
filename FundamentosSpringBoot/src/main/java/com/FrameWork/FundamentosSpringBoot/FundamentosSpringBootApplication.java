package com.FrameWork.FundamentosSpringBoot;

import com.FrameWork.FundamentosSpringBoot.component.IComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosSpringBootApplication implements CommandLineRunner {
	private IComponentDependency iComponentDependency;

	@Autowired //en versiones mas nuevas de spring no es necesario declararlo
	public FundamentosSpringBootApplication(@Qualifier("componentImplementDos") IComponentDependency iComponentDependency){ //se debe crear un constructor
		this.iComponentDependency = iComponentDependency;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		iComponentDependency.saludar();
	}
}
