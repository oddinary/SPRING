package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CarRepositoryNamed implements CarRepository{
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public List<Car> getAll() {
		// BeanPropertyRowMapper : 필드 이름과 컬럼 이름이 동일 하면 매핑을 자동으로 해주는 객체
		// 컬럼 이름과 객체의 필드의 이름이 같고 게터 세터가 존재한다면 알아서 세터를 호출 해서 하나하나 매칭해줌
		return jdbc.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
	}

	@Override
	public Car getById(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		// ?대신 :id를 쓰면 이름과 값을 가진 맵을 하나 넘겨주면 된다.
		return jdbc.queryForObject("SELECT * FROM cars WHERE id=:id", map, new BeanPropertyRowMapper<Car>(Car.class));
	}

	@Override
	public int add(Car car) {
		// BeanPropertySqlParameterSource에 객체를 넣어주면 맵을 생성해서 맞는 값을 찾아서 넣어줌.
		return jdbc.update("INSERT INTO cars (model,price) VALUES (:model, :price)", new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		//new BeanPropertySqlParameterSource(car)의 배열을 만들어 주는 메소드
		return jdbc.batchUpdate("INSERT INTO cars (model,price) VALUES (:model, :price)", SqlParameterSourceUtils.createBatch(list));
	}

	@Override
	public int update(Car car) {
		return jdbc.update("UPDATE cars SET model=:model, price=:price where id=:id", new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int delete(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.update("DELETE FROM cars where id=:id", map);
	}
	
}
