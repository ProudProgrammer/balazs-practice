package hu.gaborbalazs.spring.boot;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestDto {

	private String stringField;
	private int intField;
	
	public TestDto() {}
	
	public TestDto(String stringField, int intField) {
		super();
		this.stringField = stringField;
		this.intField = intField;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
	}
}
