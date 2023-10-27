package org.jsp.bootcrudrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info= @Info(title="bootcrud",description = "This is Simple Project", version = "SNAPSHOT v0.0.1" , contact=@Contact(url = "https://www.google.com/",name = "prakash")))
public class BootCrudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCrudRestApplication.class, args);
		
	}

}
