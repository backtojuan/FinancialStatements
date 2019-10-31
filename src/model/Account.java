package model;

/**
 * This class manages the necessary attributes and methods to accounts-
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public abstract class Account {

	private String name;
	private double value;
	
	/**
	 * <b> Account Constructor </b>
	 * @param name the name of the account
	 * @param value the value of the account
	 */
	public Account(String name,double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * This method returns the name associated to this account
	 * @return the name of this account
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the value associated for this account
	 * @return the value of this account
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * This method sets the value of the account in the case that's needed
	 * @param the new value that is going to get the account 
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	/**
	 * This method overrides the toString method to returns the information for the account
	 */
	public String toString() {
		return "Name: " + name + " Value: " + value;
	}
}
