package teamProject.food114;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Food114Application extends SpringBootServletInitializer{// 추가 코드
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Food114Application.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(Food114Application.class, args);
	}

}
