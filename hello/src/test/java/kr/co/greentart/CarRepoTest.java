package kr.co.greentart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { kr.co.greenart.config.RootConfig.class })
public class CarRepoTest {
	@Autowired
	private CarRepository repository;

	@Test
	public void initTest() {
		assertNotNull(repository);
	}

	// 해당 메소드가 시작되기전에 먼저 시행 됨
	@BeforeClass
	public static void addTestData() {
		// 테스트 클래스 수행전에 실행됩니다~~ 스태틱하게 선언합니다.
	}

	@Test
	public void create() {
		Random r = new Random();
		Car car = new Car();
		car.setModel("새 모델" + r.nextInt(10000));
		car.setPrice(1000);
		int result = repository.add(car);
		assertEquals(1, result);
	}
	
	@Test
	public void read() {
		List<Car> list = repository.getAll();
		assertNotNull(list);
	}
	@Test
	public void update() {
		int result = repository.update(new Car(1,"변경", 300));
		
		assertEquals(1,result);
	}
}
