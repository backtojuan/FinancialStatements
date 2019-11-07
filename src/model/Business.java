package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import datastructures.AccountRegister;
import datastructures.RegisterBook;

/**
 * This class manages the necessary attributes and methods to create objects of type Business-
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
public class Business {

	private RegisterBook<String,Account> registerbook;
	private String name;
	private double utility;
	
	/**
	 * <b>Business Constructor</b>
	 * @param namen the name of the company
	 * @param date the current date for the period
	 */
	public Business(String name) {
		this.name = name;
		this.registerbook = new RegisterBook<String,Account>();
	}
	
	/**
	 * This method adds an account into the register book.
	 * @param account the account that is going to be register
	 */
	public void addAccount(Account account) {
		if(account instanceof Asset) {
			registerbook.add("C", account);
		}
		else if(account instanceof Patrimony) {
			registerbook.add("F", account);
		}
		else if(account instanceof Liability) {
			registerbook.add("G", account);
		}
		else if(account instanceof Income) {
			registerbook.add("A", account);
		}
		else if(account instanceof Consume) {
			registerbook.add("B", account);
		}
	}
	
	/**
	 * this method returns the name of the company
	 * @return the name of the company
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the utility of the company
	 * @return the utility value of this company
	 */
	public double getUtility() {
		return utility;
	}
	
	/**
	 * This methos sets the current utility of the company
	 * @param ut the utility generated in a period that is going to be sum to the acumulated utility of the company
	 */
	public void setUtility(double ut) {
		utility += ut;
	}
	
	/**
	 * This method returns the registerbook of the company
	 * @return the registerbook of the company
	 */
	public RegisterBook<String,Account> getRegisterBook(){
		return registerbook;
	}
	
	/**
	 * This method generates the income statement for this company in a determinated period
	 * @param date the current date when it is going to be generated the income statement
	 * @return the income statement for this company
	 */
	public String generateIncomeStatement(LocalDate date) {
		
		String incomeStatement = "---------------------------------------------------------\n "
    			+ name + "\n Income Statement " + 
    	date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)).substring(5) +
    	"\n---------------------------------------------------------\n ";
    	
    	String operativeIncomes = "\n =========OPERATIVE INCOMES==========\n " + "\n";
    	int operativeLength = operativeIncomes.length();
    	String nonOperativeIncomes = " =========NON-OPERATIVE INCOMES==========\n " + "\n";
    	int nonoperativeLength = nonOperativeIncomes.length();
    	String operativeConsumes = " =========OPERATIVE CONSUMES==========\n " + "\n";
    	int operativecLength = operativeConsumes.length();
    	String nonOperativeConsumes = " =========NON-OPERATIVE CONSUMES==========\n " + "\n";
    	int nonoperativecLenght = nonOperativeConsumes.length();
    	String sellsCostConsumes = " =========SELLS COST CONSUME==========\n " + "\n";
    	int sellscostscLenght = sellsCostConsumes.length();
    	double totalIncomes = 0;
    	double totalConsumes = 0;
    	
    	ArrayList<AccountRegister<String,Account>> incomes = registerbook.getValues("A");
    	
    	for (int i = 0; i < incomes.size(); i++) {
    		Income in = (Income) incomes.get(i).getValue();
    		if(in.getProfitValue().equals(Income.OPERATIVE)) {
    			operativeIncomes += "  " + incomes.get(i).getValue().toString() + "\n "; 
    			totalIncomes += incomes.get(i).getValue().getValue();
    		}
    		else if(in.getProfitValue().equals(Income.NONOPERATIVE)) {
    			nonOperativeIncomes += " " + incomes.get(i).getValue().toString() + "\n "; 
    			totalIncomes += incomes.get(i).getValue().getValue();
    		}
			if(i+1>=incomes.size()) {
				if(operativeIncomes.length()!=operativeLength) {
					incomeStatement += operativeIncomes;
				}
				if(nonOperativeIncomes.length()!=nonoperativeLength) {
					incomeStatement += nonOperativeIncomes + "\n";
				}
				incomeStatement += " \nTotal Incomes " + "$" + totalIncomes + "\n "
				+ "\n---------------------------------------------------------\n ";
			}
		}
    	
    	ArrayList<AccountRegister<String,Account>> consumes = registerbook.getValues("B");
    	
    	for (int i = 0; i < consumes.size(); i++) {
    		Consume c = (Consume) consumes.get(i).getValue();
    		if(c.getDerivatedValue().equals(Consume.OPERATIVE)) {
    			operativeConsumes += "  " + consumes.get(i).getValue().toString() + "\n ";
				totalConsumes += consumes.get(i).getValue().getValue();
    		} 				
    		else if(c.getDerivatedValue().equals(Consume.NONOPERATIVE)) {
    			nonOperativeConsumes += "  " + consumes.get(i).getValue().toString() + "\n ";
				totalConsumes += consumes.get(i).getValue().getValue();
    		}
    		else if(c.getDerivatedValue().equals(Consume.SELLSCOST)) {
    			sellsCostConsumes += "  " + consumes.get(i).getValue().toString() + "\n ";
				totalConsumes += consumes.get(i).getValue().getValue();
    		}
			if(i+1>=consumes.size()) {
				if(operativeConsumes.length()!=operativecLength) {
					incomeStatement += operativeConsumes + "\n";
				}
				if(nonOperativeConsumes.length()!=nonoperativecLenght) {
					incomeStatement += nonOperativeConsumes + "\n";
				}
				if(sellsCostConsumes.length()!=sellscostscLenght) {
					incomeStatement += sellsCostConsumes;
				}
				incomeStatement += " \nTotal Consumes " + "$" + totalConsumes + "\n " + "\n " + 
				"---------------------------------------------------------\n ";
			}
		}
    	
    	incomeStatement += "Total Utility: " + "$" + (totalIncomes - totalConsumes);
    	
    	setUtility(totalIncomes-totalConsumes);
	
    	return incomeStatement;
	}
	
	/**
	 * This method generates the balance sheet of this company in a determinated period
	 * @param date the current date when it is going to be generated the balance sheet
	 * @return the balance sheet of this company
	 * @throws FileNotFoundException in the case that the incomestatement haven't been generated first
	 */
	public String generateBalanceSheet(LocalDate date) throws FileNotFoundException {
		File incomestatement = new File("data/incomestatement.txt");
		
		if(!incomestatement.exists()) {
			throw new FileNotFoundException();
		}
       	String balanceSheet = "---------------------------------------------------------\n " + 
		name + " \n Balance Sheet " + 
       	date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) + "\n " +
       	" -------------------------------------------------------\n ";
    	
       	String currentAssets = " =========CURRENT ASSETS==========\n "+ "\n";
       	int currentaLength = currentAssets.length();
       	String noncurrentAssets = " =========NONCURRENT ASSETS==========\n " + "\n";
       	int noncurrentaLength = noncurrentAssets.length();
       	String currentLiabilities = " =========CURRENT LIABILITY==========\n "+ "\n";
       	int currentlLength = currentLiabilities.length();
       	String noncurrentLiabilities = " =========CURRENT LIABILITY==========\n "+ "\n";
       	int noncurrentlLength = noncurrentLiabilities.length();
       	String patrim = " =========PATRIMONY==========\n " + "\n";
       	
       	double totalAssets = 0;
    	double totalLiabilities = 0;
    	double totalPatrimony = 0;
    	
    	ArrayList<AccountRegister<String,Account>> assets = registerbook.getValues("C");
    	
    	for (int i = 0; i < assets.size(); i++) {
    		Asset a = (Asset) assets.get(i).getValue();
    		if(a.getType().equals(Asset.CURRENT)) {
    			currentAssets += " " + assets.get(i).getValue().toString() + "\n ";
    			totalAssets += assets.get(i).getValue().getValue();
    		}
    		else if(a.getType().equals(Asset.NONCURRENT)) {
    			noncurrentAssets += " " + assets.get(i).getValue().toString() + "\n ";
    			totalAssets += assets.get(i).getValue().getValue();
    		}
			if(i+1>=assets.size()) {
				if(currentAssets.length()!=currentaLength) {
					balanceSheet += currentAssets + "\n";
				}
				if(noncurrentAssets.length()!=noncurrentaLength) {
					balanceSheet += noncurrentAssets;
				}
				balanceSheet += " \nTotal Assets " + "$" + totalAssets + "\n " + "\n " + 
				"---------------------------------------------------------\n ";
			}
		}
    	
    	ArrayList<AccountRegister<String,Account>> liabilities = registerbook.getValues("G");
    	
    	for (int i = 0; i < liabilities.size(); i++) {
    		Liability l = (Liability) liabilities.get(i).getValue();
    		if(l.getTemporaryValue().equals(Liability.CURRENT)) {
    			currentLiabilities += " " + liabilities.get(i).getValue().toString() + "\n ";
    			totalLiabilities += liabilities.get(i).getValue().getValue();
    		}
    		else if(l.getTemporaryValue().equals(Liability.NONCURRENT)) {
    			noncurrentLiabilities += " " + liabilities.get(i).getValue().toString() + "\n ";
    			totalLiabilities += liabilities.get(i).getValue().getValue();
    		}
			if(i+1>=liabilities.size()) {
				if(currentLiabilities.length()!=currentlLength) {
					balanceSheet += currentLiabilities + "\n";
				}
				if(noncurrentLiabilities.length()!=noncurrentlLength) {
					balanceSheet += noncurrentLiabilities;
				}
				balanceSheet += " \nTotal Liabilities " + "$" + totalLiabilities + "\n " + " \n " + 
				"---------------------------------------------------------\n ";
			}
		}
    	
    	ArrayList<AccountRegister<String,Account>> patrimony = registerbook.getValues("F");
    	
    	balanceSheet += patrim;
    	
    	for (int i = 0; i < patrimony.size(); i++) {
			balanceSheet += " " + patrimony.get(i).getValue().toString() + "\n ";
			totalPatrimony += patrimony.get(i).getValue().getValue();
			if(i+1>=patrimony.size()) {
				balanceSheet += " " + " Utility " + getUtility() + "\n";
				totalPatrimony += getUtility();
				balanceSheet += " \nTotal Patrimony " + "$" + totalPatrimony + "\n " + "\n ";
			}
		}
    	
    	balanceSheet += " -------------------------------------------------------\n" + " Total Assets: " + "$" 
    	+ (totalAssets) + "\n";
    	balanceSheet += " -------------------------------------------------------\n" + " Total Liabilities and Patrimony: " 
    	+ "$"+ (totalLiabilities+totalPatrimony) + "\n";
    	
    	return balanceSheet;
    	
	}
}
