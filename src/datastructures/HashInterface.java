package datastructures;

/**
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
import java.util.ArrayList;

public interface HashInterface<Key,Value> {
		
	public void add(Key key,Value value);
	
	public int size();
	
	public ArrayList<AccountRegister<Key,Value>> getValues(Key key);
}
