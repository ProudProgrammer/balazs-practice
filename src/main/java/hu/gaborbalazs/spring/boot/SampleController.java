package hu.gaborbalazs.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class SampleController {
	
	@Autowired
	private TestService service;

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
    
    @RequestMapping(value = "/testJson", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public TestDto testJson() {
    	return new TestDto("Hello String", 10);
    }
    
    @RequestMapping(value = "/testXml", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
    public TestDto testXml() {
    	return new TestDto("Hello String", 10);
    }
    
    @RequestMapping("/add")
    public int add() {
    	return service.add(10, 20);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}