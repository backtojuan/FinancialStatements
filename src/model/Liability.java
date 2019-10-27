package model;

public class Liability extends Account{
	
	private String temporaryValue;
	
	public final static String SHORTPERIOD = "Corto Plazo";
	public final static String LONGPERIOD = "Largo Plazo";
	
	
	public Liability(String name,double value,String temporaryValue) {
		super(name,value);
		this.temporaryValue = temporaryValue;
	}

	public String getTemporaryValue() {
		return temporaryValue;
	}
}
