package hu.gaborbalazs.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

	private List<Tyre> tyres;
	
	public Car() {
		this.tyres = new ArrayList<>();
	}
	
	public void addTire(Tyre tyre) {
		tyres.add(tyre);
	}
	
	public void setTires(List<Tyre> tyres) {
		this.tyres.clear();
		this.tyres.addAll(tyres);
	}
	
	public List<Tyre> getTyres() {
		return Collections.unmodifiableList(tyres);
	}
}
