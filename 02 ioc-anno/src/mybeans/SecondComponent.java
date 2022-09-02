package mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
	// 필요한 의존성 위에 적어주면 해당타입의 bean을 찾아서 의존성을 주입해준다.
	// 생산자, 세터, 필드 위에 적어주면 된다.
	@Autowired
	private FirstComponent need;
	
	public SecondComponent(FirstComponent need) {
		this.need = need;
	}

	public void setNeed(FirstComponent need) {
		this.need = need;
	}

	public void myServiceMethod() {
		System.out.println("의존성이 필요해용");
		need.hello();
	}
}
