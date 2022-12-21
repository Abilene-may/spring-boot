package vn.mcredit.springbootfirstproject.ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootFirstProjectApplication {

	public static void main(String[] args) {
		//ApplicationContext chính là container, chứa toàn bộ các Bean
		ApplicationContext context = SpringApplication.run(SpringBootFirstProjectApplication.class, args);

		//context chứa các Bean có đánh dấu @Component

		//Lấy bean
//		Outfit outfit = context.getBean(Outfit.class);

		//In ra
//		System.out.println("Instance: " + outfit);

//		outfit.wear();

		Girl girl = context.getBean(Girl.class);

		System.out.println("Girl instance: " + girl);

		System.out.println("Girl Outfit: " + girl.getOutfit());

		girl.getOutfit().wear();


	}

}
