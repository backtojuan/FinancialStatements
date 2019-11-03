package datastructures;

/**
 * This class manages the necessary attributes and methods to creat hash nodes
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
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
	
	@Override
	public String toString() {
		return "Key: " + key + "Value: " + value.toString();
	}
}
