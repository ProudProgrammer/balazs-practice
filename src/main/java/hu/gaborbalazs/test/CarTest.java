package hu.gaborbalazs.test;

import java.util.List;

public class CarTest {

	public static void main(String[] args) {
		
		Car car = new Car();
		Tyre tyre1 = new Tyre(10);
		Tyre tyre2 = new Tyre(11);
		car.addTire(tyre1);
		car.addTire(tyre2);
		List<Tyre> tyres = car.getTyres();
		
		System.out.println("Before: " + car.getTyres().size());
		car.setTires(tyres);
		System.out.println("After(1): " + car.getTyres().size());
		System.out.println("After(2): " + tyres.size());
	}

}
