package model;

public class Patrimony extends Account{

	private String name;
	
	public Patrimony(double value, String name) {
		super(value);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
