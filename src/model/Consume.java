package model;

public class Consume extends Account {
	
	private String derivatedValue;
	
	public final static String OPERATIVE = "Operative";
	public final static String NONOPERATIVE = "Non-Operative";
	
	public Consume(String name, double value, String derivatedValue) {
		super(name, value);
		this.derivatedValue = derivatedValue;
	}
	
	public String getDerivatedValue() {
		return derivatedValue;
	}
}
