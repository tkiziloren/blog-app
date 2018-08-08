package tr.com.havelsan.summerschool.blogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BlogAppApplication{

	// http://localhost:8080/h2
	// http://localhost:8080/api/swagger-ui.html
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}
}
