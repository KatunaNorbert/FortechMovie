package hello.service;

import org.springframework.stereotype.Service;


public class MyService implements IMyService {

	public static final int MAX_AGE = 100;
	
	@Override
	public int floorAgeToMaxValue(int age) {
		if (age > MAX_AGE) {
			return MAX_AGE;
		} else {
		return age;
		}
	}

}
