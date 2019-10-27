package datastructures;

import java.util.ArrayList;
import java.util.List;
import model.Account;

public class RegisterBook<Key, Value> implements HashInterface<Key,Value>{
	
	private List<Value> nodes;
	
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
		
			if(nodes.get(index)!= null) {
				found = true;
				value = nodes.get(index);
			}
		}
			return value;
	}

	@Override
	public void add(Key key, Value value) {
		
		boolean found = false;
	
		for(int counter=0; !found && counter<tablesize;counter++) {
			int index = getIndex(key, counter);
			
			if(nodes.get(index)==null) {
				found = true;
				nodes.remove(index);
				nodes.add(index, value);
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
		return index;
	}
}