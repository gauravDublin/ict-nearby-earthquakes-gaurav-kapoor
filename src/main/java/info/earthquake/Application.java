package info.earthquake;

import info.earthquake.helper.USGCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class Application {

	@Autowired
	private static USGCService service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		context.getBean(USGCService.class).calculateNearestEarthquakes();
	}
}
