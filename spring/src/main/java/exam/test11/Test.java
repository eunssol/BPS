package exam.test11;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("exam/test11/beans.xml");
		
		Tire t1 = (Tire) ctx.getBean("hankookTire");
		Tire t2 = (Tire) ctx.getBean("kumhoTire");
		Tire t3 = (Tire) ctx.getBean("hankookTire");
		
		System.out.println("t1 -->" +t1.toString());
		System.out.println("t2 -->" +t2.toString());
		System.out.println("t3 -->" +t3.toString());
		
		if(t1 != t2) {
			System.out.println("t1 != t2");
		}
		if(t1 == t3){
			System.out.println("t1 == t3");
		}
		Tire t4 = TireFactory.createTire("hankookTire");
		Tire t5 = TireFactory.createTire("kumhoTire");
		Tire t6 = TireFactory.createTire("hankookTire");
		
		System.out.println("t4 -->" +t4.toString());
		System.out.println("t5 -->" +t5.toString());
		System.out.println("t6 -->" +t6.toString());
		if(t4 != t5) {
			System.out.println("t4 != t5");
		}
		if(t4 == t6){
			System.out.println("t4 == t6");
		}
}
}
