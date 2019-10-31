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
	
	private String date;
	
	@SuppressWarnings("unchecked")
	public RegisterBook(String date) {
		
		this.date = date;
		
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
			numnodes++;
		}
		else {
			while(account.getNext()!=null) {
				if(account.getKey().equals(key)) {
					account.setNext(new AccountRegister<>(key,value));
					numnodes++;
				}
				account = account.getNext();
			}
		}		
	}

	@Override
	public int size() {
		return numnodes;
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