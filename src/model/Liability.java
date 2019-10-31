package model;

public class Liability extends Account{
	
	private String temporaryValue;
	
	public final static String SHORTPERIOD = "Short Period";
	public final static String LONGPERIOD = "Long Period";
	
	
	public Liability(String name,double value,String temporaryValue) {
		super(name,value);
		this.temporaryValue = temporaryValue;
	}

	public String getTemporaryValue() {
		return temporaryValue;
	}
}
