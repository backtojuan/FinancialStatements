package datastructures;

import java.util.ArrayList;
import java.util.List;
import model.Account;

public class RegisterBook<Key, Value> implements HashInterface<Key,Value>{
	
	private List<AccountRegister<Key,Value>> nodes;
	
	private int tablesize; 
	
	public RegisterBook() {
		tablesize = 10;
		nodes = new ArrayList<>();
		
		for (int i = 0; i < tablesize; i++) {
			nodes.add(null);
		}
	}

	@Override
	public Value getValue(Key key) {
		
		Value value = null;
		boolean found = false;
		
		for(int counter = 0; counter<tablesize;counter++) {
			
			int index = getIndex(key, counter);
		
			if(nodes.get(index)!= null && nodes.get(index).getKey().equals(key)) {
				found = true;
				value = nodes.get(index).getValue();
			}
		}
			return value;
	}

	@Override
	public void add(Key key,Value value) {
		
		System.out.println();
		System.out.println("add in register book");
		System.out.println(key);
		System.out.println(value);
		System.out.println();
		
		boolean found = false;
	
		for(int counter=0; !found && counter<tablesize;counter++) {
			int index = getIndex(key, counter);
			
			System.out.println(index);
			
			if(nodes.get(index)==null) {
				found = true;
				nodes.remove(index);
				nodes.add(index, new AccountRegister<Key,Value>(key, value));
			}
						
			if(counter==tablesize && !found) {
				tablesize*=2;
				
				for (int i = counter; i < tablesize; i++) {
					nodes.add(null);
				}
			}
		}
		
	}
	
	private int getIndex(Key key, int counter) {
		int index = 0;
		
		int hashCode = Math.abs(key.hashCode());
		
		double A = (Math.sqrt(5) - 1 )/ 2;
		int h1 = (int) Math.floor(tablesize*(A*hashCode% 1));
		
		int h2 = hashCode % tablesize;
		
		index = (h1 + h2*counter)%tablesize;
		
		System.out.println();
		System.out.println("index" + index);
		System.out.println();
		
		return index;
	}
}