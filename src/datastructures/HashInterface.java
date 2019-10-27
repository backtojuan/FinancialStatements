package datastructures;

public interface HashInterface<Key,Value> {
	
	public Value getValue(Key key);
	
	public void add(Key key, Value value);
		
}
