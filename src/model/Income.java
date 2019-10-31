package model;

/**
 * This class manages the necessary attributes and methods to create Accounts of type Income-
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class Income extends Account{

	private String profitValue;
	
	public final static String OPERATIVE = "Operative";
	public final static String NONOPERATIVE = "Non-Operative";

	/**
	 * <b> Income Constructor </b> 
	 * @param name the name of this account
	 * @param value the value of this account
	 * @param profitValue the type of this account
	 */
	public Income(String name,double value,String profitValue) {
		super(name,value);
		this.profitValue = profitValue;
	}
	
	/**
	 * This method returns the type of this account
	 * @return the type of this account
	 */
	public String getProfitValue() {
		return profitValue;
	}
}
