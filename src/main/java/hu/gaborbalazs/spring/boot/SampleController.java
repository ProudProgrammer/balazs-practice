package hu.gaborbalazs.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@RestController
@SpringBootApplication
@ComponentScan
public class SampleController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private TestService service;
	
    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
    
    @RequestMapping(value = "/testJson", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public TestDto testJson() {
    	LOGGER.debug("testJson() called");
    	return new TestDto("Hello String", 10);
    }
    
    @RequestMapping(value = "/testAnotherJson", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public TestDto testAnotherJson() {
    	LOGGER.debug("testAnotherJson() called");
    	return new TestDto("Hello String", 10);
    }
    
    @RequestMapping(value = "/testXml", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
    public TestDto testXml() {
    	LOGGER.debug("testXml() called");
    	return new TestDto("Hello String", 10);
    }
    
    @RequestMapping(value = "/testAnotherXml", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
    public TestDto testAnotherXml() {
    	LOGGER.debug("testAnotherXml() called");
    	return new TestDto("Hello String", 10);
    }
    
    @RequestMapping("/add")
    public int add() {
    	LOGGER.debug("add() called");
    	return service.add(10, 20);
    }
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam Long id, @RequestHeader String text) {
    	String myheader = "header";
    	return "Hello param: " + id + ", Hello header: " + text + "Hello " + myheader;
    }
    
    @RequestMapping(value = "/mapping", method = RequestMethod.POST)
    public String mapping(@RequestBody TestDto dto) {
    	return "StringField: " + dto.getStringField();
    }
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}