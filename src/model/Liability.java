package model;

/**
 * This class manages the necessary attributes and methods to create accounts of type Liability.-
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class Liability extends Account{
	
	private String temporaryValue;
	
	public final static String CURRENT = "Current";
	public final static String NONCURRENT = "Non-Current";
	
	/**
	 * <b>Liability constructor</b>
	 * @param name the name of this account
	 * @param value the value of this account
	 * @param temporaryValue the type of this account
	 */
	public Liability(String name,double value,String temporaryValue) {
		super(name,value);
		this.temporaryValue = temporaryValue;
	}

	/**
	 * This method returns the type of this account
	 * @return the type of this account
	 */
	public String getTemporaryValue() {
		return temporaryValue;
	}
}
