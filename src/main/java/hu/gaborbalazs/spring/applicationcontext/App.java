package hu.gaborbalazs.spring.applicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class App {

	@Autowired
	private TestService service;
	
	public int doSomething() {
		return service.add(10, 20);
	}
	
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		App app = context.getBean(App.class);
		
		System.out.println("Hello, " + app.doSomething());
	}
}