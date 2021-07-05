package exam.test04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
	@Bean
	public Score score() {
		Score s = new Score();
		return s;
	}
	@Bean
	public Score score2() {
		Score s2 = new Score();
		return s2;
	}
}
