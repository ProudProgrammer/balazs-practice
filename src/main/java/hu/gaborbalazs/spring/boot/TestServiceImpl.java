package hu.gaborbalazs.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

}
