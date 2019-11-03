package model;
import datastructures.RegisterBook;

/**
 * This class manages the necessary attributes and methods to create objects of type Business-
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class Business {

	private RegisterBook<String,Account> registerbook;
	private String name;
	private double utility;
	
	/**
	 * <b>Business Constructor</b>
	 * @param namen the name of the company
	 * @param date the current date for the period
	 */
	public Business(String name) {
		this.name = name;
		this.registerbook = new RegisterBook<String,Account>();
	}
	
	/**
	 * This method adds an account into the register book.
	 * @param account the account that is going to be register
	 */
	public void addAccount(Account account) {
		if(account instanceof Asset) {
			registerbook.add("C", account);
		}
		else if(account instanceof Patrimony) {
			registerbook.add("F", account);
		}
		else if(account instanceof Liability) {
			registerbook.add("G", account);
		}
		else if(account instanceof Income) {
			registerbook.add("A", account);
		}
		else if(account instanceof Consume) {
			registerbook.add("B", account);
		}
	}
	
	/**
	 * this method returns the name of the company
	 * @return the name of the company
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the utility of the company
	 * @return the utility value of this company
	 */
	public double getUtility() {
		return utility;
	}
	
	/**
	 * This methos sets the current utility of the company
	 * @param ut the utility generated in a period that is going to be sum to the acumulated utility of the company
	 */
	public void setUtility(double ut) {
		utility += ut;
	}
	
	/**
	 * This method returns the registerbook of the company
	 * @return the registerbook of the company
	 */
	public RegisterBook<String,Account> getRegisterBook(){
		return registerbook;
	}

}
