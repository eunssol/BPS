package exam.test03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		
			Score score = ctx.getBean("score",Score.class);
			// 두번째 값으로 자동 형변환?!?
			System.out.println("합계:" + score.sum());
			System.out.println("평균:" + score.average());

	}

}
