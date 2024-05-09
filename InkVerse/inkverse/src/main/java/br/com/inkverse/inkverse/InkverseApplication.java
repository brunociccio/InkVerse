package br.com.inkverse.inkverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
		title = "InkVerse API",
		version = "1.0.0",
		description = "API do app InkVerse: marketing place de tatuagens",
		contact = @Contact(name = "Bruno Ciccio", email = "dev.bruno.ciccio@gmail.com")
	)
)
public class InkverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(InkverseApplication.class, args);
	}

	@RequestMapping("/home")
	@ResponseBody
	public String home(){
		return "WebApp Inkverse";
	}

}
