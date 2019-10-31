package model;

/**
 * This class manages the necessary attributes and methods to create accounts of type Asset
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class Asset extends Account{
	
	private String type;
	private boolean isDepreciable;
	
	public static final String CURRENT = "Current";
	public static final String NONCURRENT = "Non-Current";
	
	/**
	 * <b>Asset Constructor</b>
	 * @param name the name of this account
	 * @param value the value of this account
	 * @param type the type of this account
	 */
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

	/**
	 * This method returns the type of the account
	 * @return the type if the account
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method returns the depreciable value of the account
	 * @return the boolean value that indicates if either this account is depreciable or not 
	 */
	public boolean isDepreciable() {
		return isDepreciable;
	}
}
