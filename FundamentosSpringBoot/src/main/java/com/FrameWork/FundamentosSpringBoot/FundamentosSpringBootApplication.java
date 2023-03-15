package com.FrameWork.FundamentosSpringBoot;

import com.FrameWork.FundamentosSpringBoot.bean.MyBean;
import com.FrameWork.FundamentosSpringBoot.bean.MyBeanWithDependency;
import com.FrameWork.FundamentosSpringBoot.bean.MyBeanWithProperties;
import com.FrameWork.FundamentosSpringBoot.bean.MyOperation;
import com.FrameWork.FundamentosSpringBoot.component.IComponentDependency;
import com.FrameWork.FundamentosSpringBoot.entity.User;
import com.FrameWork.FundamentosSpringBoot.pojo.UserPojo;
import com.FrameWork.FundamentosSpringBoot.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosSpringBootApplication implements CommandLineRunner {
	private Log LOGGER = LogFactory.getLog(FundamentosSpringBootApplication.class);
	private IComponentDependency iComponentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private UserRepository userRepository;

	@Autowired //en versiones mas nuevas de spring no es necesario declararlo
	//con @Qualifier decidimos la dependencia a utilizar
	public FundamentosSpringBootApplication(@Qualifier("componentImplementDos") IComponentDependency iComponentDependency,
											MyBean myBean, MyBeanWithDependency myBeanWithDependency,
											MyBeanWithProperties myBeanWithProperties, UserPojo userPojo,
											UserRepository userRepository){ //se debe crear un constructor

		System.out.println("arranca constructor");
		this.iComponentDependency = iComponentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		System.out.println("main");
		SpringApplication.run(FundamentosSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersDb();
		getInformationJpqlfromUser();
	}

	private void getInformationJpqlfromUser(){
		LOGGER.info("usuario encontrado con JPQL: " + userRepository.findByUserEmail("juan@gamil.com")
				.orElseThrow(() -> new RuntimeException("no hay registros")));

		userRepository.findAndSort("ju", Sort.by("id").descending()).stream().forEach(user -> LOGGER.info("usuarios sort " + user));
	}

	private void saveUsersDb(){
		User user1 = new User("juan", "juan@gamil.com", LocalDate.of(2023, 03, 14));
		User user2 = new User("pedro", "pedro@gamil.com", LocalDate.of(2023, 02, 13));
		User user3 = new User("pablo", "pablo@gamil.com", LocalDate.of(2023, 03, 13));
		User user4 = new User("julio", "julio@gamil.com", LocalDate.of(2023, 03, 11));
		User user5 = new User("leon", "leon@gamil.com", LocalDate.of(2023, 03, 10));
		User user6 = new User("charli", "charli@gamil.com", LocalDate.of(2023, 01, 01));
		User user7 = new User("vicente", "vicen@gamil.com", LocalDate.of(2023, 02, 02));
		User user8 = new User("anuel", "anuel@gamil.com", LocalDate.of(2023, 03, 03));
		User user9 = new User("ferxoo", "ferxoo@gamil.com", LocalDate.of(2023, 03, 04));
		User user10 = new User("el guason bebe", "guason@gamil.com", LocalDate.of(2023, 03, 05));

		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		list.stream().forEach(userRepository :: save);
	}

	private void ejemplosAnteriores(){
		System.out.println("run");
		iComponentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.funcion());
		System.out.println(userPojo.getEmail() + "-" +userPojo.getPassword());
		try {
			//error

		} catch (Exception e) {
			LOGGER.error("hubo un error" + e.getStackTrace());
		}
	}
}
