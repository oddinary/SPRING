package kr.co.greentart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import kr.co.greenart.model.User;

public class MyFirstTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		int a = 10;
		int b = 20;
		
		int sum = a + b;
		assertEquals(30, sum);
	}

	@Test
	public void test2() {
		String abc = "abc";
		String abc2 = abc;
		
		assertSame(abc2, abc);
	}
	
	@Test
	public void test3() {
		User u = new User();
		
		assertNotNull(u);
	}
}












