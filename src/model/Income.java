package model;

public class Income extends Account{

	private String name;
	private String profitValue;
	
	private final static String OPERATIVE = "Operativo";
	private final static String NONOPERATIVE = "No Operativo";

	public Income(double value, String name, String profitValue) {
		super(value);
		this.name = name;
		this.profitValue = profitValue;
	}

	public String getName() {
		return name;
	}

	public String getProfitValue() {
		return profitValue;
	}
}
