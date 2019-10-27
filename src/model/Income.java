package model;

public class Income extends Account{

	private String profitValue;
	
	public final static String OPERATIVE = "Operativo";
	public final static String NONOPERATIVE = "No Operativo";

	public Income(String name,double value,String profitValue) {
		super(name,value);
		this.profitValue = profitValue;
	}
	
	public String getProfitValue() {
		return profitValue;
	}
}
