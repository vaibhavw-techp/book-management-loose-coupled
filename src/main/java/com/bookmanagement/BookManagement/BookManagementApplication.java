package com.bookmanagement.BookManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Book Management System",
				version = "1.0.0",
				description = "This project is used to maintain Book and Authors Management",
				termsOfService = "Copyright@2023",
				contact = @Contact(
						name = "Vaibhav",
						email = "vaibhav@gmail.com"
				),
				license = @License(
						name = "license",
						url = "something.google.com"
				)
		)
)
@SpringBootApplication
public class BookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementApplication.class, args);
	}

}
