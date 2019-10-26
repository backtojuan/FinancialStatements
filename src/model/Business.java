package model;
import datastructures.RegisterBook;

public class Business {

	private RegisterBook<String,Account> registerbook;
	private String name;
	private String address;
	
	public Business(String name, String address) {
		this.name = name;
		this.address = address;
		this.registerbook = new RegisterBook<String,Account>();
	}
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
}
