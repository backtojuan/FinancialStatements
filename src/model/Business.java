package model;
import datastructures.RegisterBook;

public class Business {

	private RegisterBook<String,Account> registerbook;
	private String name;
	
	public Business(String name,String date) {
		this.name = name;
		this.registerbook = new RegisterBook<String,Account>(date);
	}
	
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

	public String getName() {
		return name;
	}
	
	public RegisterBook<String,Account> getRegisterBook(){
		return registerbook;
	}

}
