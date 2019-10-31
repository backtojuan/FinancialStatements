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
	
	/**
	 * <b>Business Constructor</b>
	 * @param namen the name of the company
	 * @param date the current date for the period
	 */
	public Business(String name,String date) {
		this.name = name;
		this.registerbook = new RegisterBook<String,Account>(date);
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
	 * This method returns the registerbook of the company
	 * @return the registerbook of the company
	 */
	public RegisterBook<String,Account> getRegisterBook(){
		return registerbook;
	}

}
