package datastructures;

import java.util.ArrayList;

public interface HashInterface<Key,Value> {
		
	public void add(Key key,Value value);
	
	public int size();
	
	public ArrayList<AccountRegister<Key,Value>> getValues(Key key);
}
