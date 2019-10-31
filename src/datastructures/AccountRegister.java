package datastructures;

public class AccountRegister<Key, Value> {
	
	private Key key;
	private Value value;

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
}
