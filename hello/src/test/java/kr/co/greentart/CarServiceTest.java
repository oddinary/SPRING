package kr.co.greentart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional
public class CarServiceTest {
	@Autowired
	private CarService service;
	
	@Test(expected = DataAccessException.class)
	public void bulkInsert() {
		List<Car> list = Arrays.asList(new Car(0,"AAA",100)
				,new Car(0,"BBB",100)
				,new Car(0,"AAA",1000)
				,new Car(0,"DDD",2000));
		
		int[] result = service.bulkInsert(list);
		assertNull(result);
	} 
	
	@Test
	@Rollback(value = true)
	public void delete() {
		int result= service.delete(2);
		assertEquals(1, result);
	}
}
