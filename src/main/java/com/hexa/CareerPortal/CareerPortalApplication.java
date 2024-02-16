package com.hexa.CareerPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="CareerCrafter",
				version="1.0.0",
				description="This project is basically a job portal",
				termsOfService = "Not yet decided",
				contact=@Contact(
						name="Kunal Sharma and Asim Zohair",
<<<<<<< HEAD
						email="itsmekunal0501@gmail.com , asimzohair4@gmail.com"
=======
						email="itsmekunal0501@gmail.com,asimzohair@gmail.com"
>>>>>>> e436b2a9f4c182ab98ff52261fc8198ab3eec6dc
						),
				license=@License(
						name="License",
						url="http://localhost:8080")
				)
		)
public class CareerPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareerPortalApplication.class, args);
	}

}
