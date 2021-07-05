package exam.test05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
	@Bean
	public Score score() {
		Score s = new Score();
		s.setName("임꺽정");
		s.setKor(99);
		s.setEng(93);
		s.setMath(30);
		return s;
	}
	@Bean
	public Score score2() {
		Score s2 = new Score();
		return s2;
	}
}
