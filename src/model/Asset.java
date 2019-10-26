package model;

public class Asset extends Account{
	
	private String name;
	private String type;
	private boolean isDepreciable;
	
	public static final String CURRENT = "Corriente";
	public static final String NONCURRENT = "No Corriente";
	
	public Asset(double value, String type) {
		
		super(value);
		
		this.type = type;
		if (type.equals(CURRENT)){
			isDepreciable = false;
		}
		else {
			isDepreciable = true;
		}
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public boolean isDepreciable() {
		return isDepreciable;
	}
}
