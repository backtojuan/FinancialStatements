package model;

public class Income extends Account{

	private String profitValue;
	
	public final static String OPERATIVE = "Operative";
	public final static String NONOPERATIVE = "Non-Operative";

	public Income(String name,double value,String profitValue) {
		super(name,value);
		this.profitValue = profitValue;
	}
	
	public String getProfitValue() {
		return profitValue;
	}
}
