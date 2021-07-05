package exam.test05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("exam/test05/beans.xml");
		
		Score score1 = (Score) ctx.getBean("score1");
		System.out.println(score1+"평균"+score1.average());
		Score score2 = (Score) ctx.getBean("score2");
		System.out.println(score2+"평균"+score2.average());
		

}
}
