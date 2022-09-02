import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybeans.MyBean;
import mybeans.MyLogic;
import mybeans.MyStatefulObj;

public class IOC_Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("myconfig.xml");

		MyStatefulObj fifth = context.getBean("fourth", MyStatefulObj.class);
		System.out.println(fifth);

//		MyStatefulObj third = context.getBean(MyStatefulObj.class);
//		System.out.println(third);
		
//		third.setName("new-name");
//		third.setNumber(200);
		
//		MyStatefulObj fourth = context.getBean(MyStatefulObj.class);
//		// 같은 인스턴스 참조여서 값이 바뀐다.(싱글턴 패턴)
//		System.out.println(fourth);

//		MyLogic logic = context.getBean(MyLogic.class);
//		logic.someMethod();

//		MyBean b = context.getBean(MyBean.class);
		
//		b.hello();
		
//		MyBean b2 = context.getBean("first", MyBean.class);
//		b2.hello();
		
//		// 같은 인스턴스에 대한 참조만 여러개를 반환한다.
//		System.out.println(b == b2);
	}
}
