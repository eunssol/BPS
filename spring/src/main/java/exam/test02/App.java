package exam.test02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
	@Bean
	public Score score() {
		Score s = new Score();
		return s;
	}
}
