package model;

/**
 * This class manages the necessary attributes and methods to create accounts of type Consume-
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class Consume extends Account {
	
	private String derivatedValue;
	
	public final static String OPERATIVE = "Operative";
	public final static String NONOPERATIVE = "Non-Operative";
	public final static String SELLSCOST = "Sells-Cost";
	
	/**
	 * <b>Consume Constructor</b>
	 * @param name the name of the account
	 * @param value the value of the account
	 * @param derivatedValue the type of this account
	 */
	public Consume(String name, double value, String derivatedValue) {
		super(name, value);
		this.derivatedValue = derivatedValue;
	}
	
	/**
	 * this method gets the type of the account
	 * @return the type of the account
	 */
	public String getDerivatedValue() {
		return derivatedValue;
	}
}
