package datastructures;

public class AccountRegister<Key, Value> {
	
	private Key key;
	private Value value;
	
	private AccountRegister<Key,Value> next;

	public AccountRegister(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
	
	public Key getKey () {
		return key;
	}
	
	public Value getValue() {
		return value;
	}
	
	public AccountRegister<Key, Value> getNext(){
		return next;
	}

	public void setNext(AccountRegister<Key,Value> n) {
		next = n;
	}
}
