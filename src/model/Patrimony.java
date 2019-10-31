package model;

/**
 * This class manages the necessary attributes and methods to create accounts of type Patrimony
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class Patrimony extends Account{
	
	/**
	 * <b>Patrimony constructor</b>
	 * @param name the name of the account
	 * @param value the value of the account
	 */
	public Patrimony(String name,double value) {
		super(name,value);
	}
}
