package model;

public class Asset extends Account{
	
	private String type;
	private boolean isDepreciable;
	
	public static final String CURRENT = "Corriente";
	public static final String NONCURRENT = "No Corriente";
	
	public Asset(String name,double value, String type) {
		
		super(name,value);
		
		this.type = type;
		if (type.equals(CURRENT)){
			isDepreciable = false;
		}
		else {
			isDepreciable = true;
		}
	}

	public String getType() {
		return type;
	}

	public boolean isDepreciable() {
		return isDepreciable;
	}
}
