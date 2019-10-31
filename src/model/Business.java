package model;
import datastructures.RegisterBook;

public class Business {

	private RegisterBook<String,Account> registerbook;
	private String name;
	
	
	public Business(String name) {
		this.name = name;
		this.registerbook = new RegisterBook<String,Account>();
	}
	
	public void addAccount(Account account) {
		System.out.println(account.getName() + " " + account.getValue());
		registerbook.add(account.getName(), account);
	}

	public String getName() {
		return name;
	}
	
	public RegisterBook<String,Account> getRegisterBook(){
		return registerbook;
	}

}
