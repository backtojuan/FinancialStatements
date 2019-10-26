package model;

public class Liability extends Account{
	
	private String name;
	private String temporaryValue;
	

	public final static String SHORTPERIOD = "Corto Plazo";
	public final static String LONGPERIOD = "Largo Plazo";
	
	
	public Liability(double value, String name,String temporaryValue) {
		super(value);
		this.name = name;
		this.temporaryValue = temporaryValue;
	}

	public String getName() {
		return name;
	}

	public String getTemporaryValue() {
		return temporaryValue;
	}
}
