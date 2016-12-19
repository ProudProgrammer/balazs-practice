package hu.gaborbalazs.spring.applicationcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App {

	private final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	@Autowired
	@Qualifier("impl1")
	private TestService service;
	
	@Autowired
	@Qualifier("impl2")
	private TestService service2;
	
	
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		App app = context.getBean(App.class);
		
		System.out.println("Hello, " + app.service.add(10, 20));
		System.out.println("Hello, " + app.service2.add(10, 20));
	}
}