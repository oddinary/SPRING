// 라이브러리가 없으면 이렇게 만들어야한다.
package kr.co.greenart.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

	@Override
	// type이 유효한지 체크
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	//target이 유효성 검사할 객체, errors은 오류를 설정할 객체
	public void validate(Object target, Errors errors) {
		// 해당객체의 필드가 공백이거나 비어있으면 에러를 추가해줌.(메세지와 코드를 같이 심어줌)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름을 입력하세요");
		
		User user = (User) target;
		if( user.getName().length() > 7) {
			errors.rejectValue("name","name.toolong", "이름이 너무 길어요");
		}
		if (user.getAge() > 100 && user.getAge() <= 0) {
			errors.rejectValue("age","age.tooold","나이 막적지 마라");
		}
	}
	
}
