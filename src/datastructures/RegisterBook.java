package datastructures;

import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 * This class manages the necessary attributes and methods to create the registerbook as a Hash Table
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class RegisterBook<Key, Value> implements HashInterface<Key,Value>{
	
	private AccountRegister<Key,Value>[] nodes;
	
	private int tablesize; 
	
	private int numnodes;
	
	@SuppressWarnings("unchecked")
	public RegisterBook() {

		tablesize = 5;
		
		nodes = new AccountRegister[tablesize];
	
	}
	
	@Override
	public ArrayList<AccountRegister<Key,Value>> getValues(Key key) {
	
		ArrayList<AccountRegister<Key,Value>> values = new ArrayList<>();
		
		int index = getIndex(key);
		
		AccountRegister<Key,Value> account = nodes[index];
		
		if(account!=null) {
			values.add(account);
			while(account.getNext()!=null) {
				values.add(account.getNext());
				account = account.getNext();
			}
		}
		return values;
	}

	@Override
	public void add(Key key,Value value) {
		
		int index = getIndex(key);
		AccountRegister<Key,Value> account = nodes[index];
		
		if(account==null) {
			nodes[index] = new AccountRegister<>(key, value);
		}
		else {
			if(account.getNext()==null) {
				account.setNext(new AccountRegister<>(key,value));
			}
			else {
				while(account.getNext()!=null) {
					account = account.getNext();
				}
				account.setNext(new AccountRegister<>(key,value));
			}
		}		
	}

	public int getIndex(Key key) {
		int index = 0;
		
		int hashCode = Math.abs(key.hashCode());
		
		double A = (Math.sqrt(5) - 1 )/ 2;
		int h1 = (int) Math.floor(tablesize*(A*hashCode% 1));
		
		index = (h1 )%tablesize;
		
		return index;
	}
}