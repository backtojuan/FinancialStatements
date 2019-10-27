package model;
import datastructures.RegisterBook;

public class Business {

	private RegisterBook<String,Double> registerbook;
	private String name;
	
	
	public Business(String name) {
		this.name = name;
		this.registerbook = new RegisterBook<String,Double>();
	}
	
	public void addAccount(Account account) {
		registerbook.add(account.getName(), account.getValue());
	}

	public String getName() {
		return name;
	}

}
