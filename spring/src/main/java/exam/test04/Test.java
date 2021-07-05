package exam.test04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("exam/test04/beans.xml");
		
		Score score1 = (Score) ctx.getBean("score1");
		System.out.println(score1+"평균"+score1.average());
		Score score2 = (Score) ctx.getBean("score2");
		System.out.println(score2+"평균"+score2.average());
		Score score3 = (Score) ctx.getBean("score3");
		System.out.println(score3+"평균"+score3.average());
		Score score4 = (Score) ctx.getBean("score4");
		System.out.println(score4+"평균"+score4.average());
		Score score5 = (Score) ctx.getBean("score5");
		System.out.println(score5+"평균"+score5.average());
	}

}
