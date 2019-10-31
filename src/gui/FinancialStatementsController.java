package gui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.Account;
import model.Asset;
import model.Business;
import model.Consume;
import model.Income;
import model.Liability;
import model.Patrimony;
import datastructures.AccountRegister;
import java.util.ArrayList;

public class FinancialStatementsController {

    @FXML
    private Text company;

    @FXML
    private Text period;
    
    @FXML
    private DatePicker datepicker;

    @FXML
    private Text currentperiod;

    @FXML
    private TableView<Account> registerBook;
    
    @FXML
    private ObservableList<Account> accounts;
    
    @FXML
    private TextField companyName;
    
    @FXML
    private TextField nameacc1;

    @FXML
    private TextField valueacc1;
    
    @FXML
    private ComboBox<String> acc1;

    @FXML
    private ComboBox<String> acc2;
    
    @FXML
    private ComboBox<String> assetacc1;

    @FXML
    private ComboBox<String> liabilityacc1;

    @FXML
    private ComboBox<String> incomeacc1;

    @FXML
    private ComboBox<String> assetacc2;

    @FXML
    private ComboBox<String> liabilityacc2;

    @FXML
    private ComboBox<String> incomeacc2;

    @FXML
    private TextField nameacc2;
    
    @FXML
    private TextField valueacc2;
    
    @FXML
    private Button button2;

    @FXML
    private Button button1;
    
    @FXML
    private Button button;
    
    private Business business;
    
   
    @FXML
    private void initialize() {
    	
    	//initialize first column of the register book
    	
    	TableColumn<Account,String> fecolumn = new TableColumn<Account,String>("Account´s Name");
    	fecolumn.setMinWidth(700.0);
    	fecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    	TableColumn<Account,Double> valuecolumn = new TableColumn<>(" $ Transaction Value");
    	valuecolumn.setMinWidth(750.0);
    	valuecolumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    	
    	registerBook.getColumns().add(fecolumn);
    	registerBook.getColumns().add(valuecolumn);
    
    	accounts = FXCollections.observableArrayList();
    	
    	//initializes the combobox items from second tab making available to register an account
    	
    	acc1.setItems(FXCollections.observableArrayList("Asset","Liability","Income","Consume","Patrimony"));
    	
    	assetacc1.setItems(FXCollections.observableArrayList(Asset.CURRENT,Asset.NONCURRENT));
    	liabilityacc1.setItems(FXCollections.observableArrayList(Liability.SHORTPERIOD,Liability.LONGPERIOD));
    	incomeacc1.setItems(FXCollections.observableArrayList(Income.OPERATIVE,Income.NONOPERATIVE));
    	
    	assetacc1.setDisable(true);
    	liabilityacc1.setDisable(true);
    	incomeacc1.setDisable(true);
    	button1.setDisable(true);
    	 	
    	acc2.setItems(FXCollections.observableArrayList("Asset","Liability","Income","Consume","Patrimony"));
    	
    	assetacc2.setItems(FXCollections.observableArrayList(Asset.CURRENT,Asset.NONCURRENT));
    	liabilityacc2.setItems(FXCollections.observableArrayList(Liability.SHORTPERIOD,Liability.LONGPERIOD));
    	incomeacc2.setItems(FXCollections.observableArrayList(Income.OPERATIVE,Income.NONOPERATIVE));
    	
    	assetacc2.setDisable(true);
    	liabilityacc2.setDisable(true);
    	incomeacc2.setDisable(true);
    	
    	button2.setDisable(true);	
    }
    
    @FXML
    private void createCompany(ActionEvent event) {
   
    	if(!companyName.getText().isEmpty()) {
    		if(datepicker.getValue()!=null) {
    			String name = companyName.getText();
    			String date = datepicker.getValue().toString();
    			business = new Business(name, date);
    			
    	    	Notifications.create()
    	    	.title("Information")
    	    	.text("Company created")
    	    	.darkStyle()
    			.hideAfter(Duration.seconds(3))
        		.hideCloseButton()
        		.position(Pos.CENTER)
    	    	.showConfirm();
    	    	;
   			}
   		}
    	
   		else if(companyName.getText().isEmpty() || datepicker.getValue()==null){
   			Notifications.create()
   			.title("Warning")
        	.text("You cannot create a company if you haven't enter enough information")
        	.darkStyle()
        	.hideAfter(Duration.seconds(3))
        	.hideCloseButton()
        	.position(Pos.CENTER)
        	.showWarning()
        	;
    	}
    }
       
    @FXML
    private void defineAccount1(ActionEvent event) {
    	if(acc1.getValue().equals("Asset")) {
    		assetacc1.setDisable(false);
        	liabilityacc1.setDisable(true);
        	incomeacc1.setDisable(true);
        	button1.setDisable(false);
    	}
    	else if(acc1.getValue().equals("Liability")) {
        	assetacc1.setDisable(true);
        	liabilityacc1.setDisable(false);
        	incomeacc1.setDisable(true);
        	button1.setDisable(false);
    	}
    	else if(acc1.getValue().equals("Income") || acc1.getValue().equals("Consume")) {
        	assetacc1.setDisable(true);
        	liabilityacc1.setDisable(true);
        	incomeacc1.setDisable(false);
        	button1.setDisable(false);
    	}
    }
    
    @FXML
    private void defineAccount2(ActionEvent event) {
    	if(acc2.getValue().equals("Asset")) {
    		assetacc2.setDisable(false);
        	liabilityacc2.setDisable(true);
        	incomeacc1.setDisable(true);
        	button2.setDisable(false);
    	}
    	else if(acc2.getValue().equals("Liability")) {
        	assetacc2.setDisable(true);
        	liabilityacc2.setDisable(false);
        	incomeacc2.setDisable(true);
        	button2.setDisable(false);
    	}
    	else if(acc2.getValue().equals("Income") || acc2.getValue().equals("Consume")) {
        	assetacc2.setDisable(true);
        	liabilityacc2.setDisable(true);
        	incomeacc2.setDisable(false);
        	button2.setDisable(false);
    	}
    }
    
    @FXML
    private void registerAccount1(ActionEvent event) {
    	
    	try {
    			if(acc1.getValue().equals("Asset") && !assetacc1.isDisable()) {
	    			if(assetacc1.getValue().equals(Asset.CURRENT)) {
	    				Account asset = new Asset(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Asset.CURRENT);
	    				addToRegisterBook(asset, "C");
	    				
	    			}
	    			else if(assetacc1.getValue().equals(Asset.NONCURRENT)) {
	    				Account asset = new Asset(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Asset.NONCURRENT);
	    				addToRegisterBook(asset, "C");
	    			}
    			}
    			else if(acc1.getValue().equals("Liability") && !liabilityacc1.isDisable()) {
    				if(liabilityacc1.getValue().equals(Liability.SHORTPERIOD)) {
	    				Account liability = new Liability(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Liability.SHORTPERIOD);
	    				addToRegisterBook(liability, "G");
    				}
	    			else if(liabilityacc1.getValue().equals(Liability.LONGPERIOD)) {
	    				Account liability = new Liability(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Liability.LONGPERIOD);
	    				addToRegisterBook(liability, "G");
	    			}
    			}
    			else if(acc1.getValue().equals("Income") && !incomeacc1.isDisable()) {
    				if(incomeacc1.getValue().equals(Income.OPERATIVE)) {
    					Account income = new Income(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Income.OPERATIVE);
    					addToRegisterBook(income, "A");
    				}
    				else if(incomeacc1.getValue().equals(Income.NONOPERATIVE)) {
    					Account income = new Income(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Income.NONOPERATIVE);
    					addToRegisterBook(income, "A");
    				}
    			}
    			else if(acc1.getValue().equals("Consume")) {
    				if(incomeacc1.getValue().equals(Income.OPERATIVE)) {
    					Account consume = new Consume(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Income.OPERATIVE);
    					addToRegisterBook(consume, "B");
    				}
    				else if(incomeacc1.getValue().equals(Income.NONOPERATIVE)) {
    					Account consume = new Consume(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Income.NONOPERATIVE);
    					addToRegisterBook(consume, "B");
    				}
    			}
    			else if(acc1.getValue().equals("Patrimony")) {
    				Account patrimony = new Patrimony(nameacc1.getText(),Double.parseDouble(valueacc1.getText()));
    				addToRegisterBook(patrimony, "F");
    			}
    			button1.setDisable(true);
    			button2.setDisable(false);
    	    	
    	    	Notifications.create()
    	    	.title("Information")
    	    	.text("First account succesfully created")
    	    	.darkStyle()
    			.hideAfter(Duration.seconds(3))
        		.hideCloseButton()
        		.position(Pos.CENTER)
    	    	.showConfirm();
    	    	;
    	}
    	catch(NumberFormatException nfe) {
    		Notifications.create()
    		.title("Warning")
    		.text("You cannot create an account with this invalid values")
    		.darkStyle()
    		.hideAfter(Duration.seconds(3))
    		.hideCloseButton()
    		.position(Pos.CENTER)
    		.showWarning()
    		;
    	}
    	catch(NullPointerException npe) {
    		Notifications.create()
    		.title("Warning")
    		.text("You cannot create an account if you either haven't create a company or"
    				+ "if you haven't enter enough information")
    		.darkStyle()
    		.hideAfter(Duration.seconds(3))
    		.hideCloseButton()
    		.position(Pos.CENTER)
    		.showWarning()
    		;
    	}
    }

    @FXML
    private void registerAccount2(ActionEvent event) {
    	
    	try {
			if(acc2.getValue().equals("Asset") && !assetacc2.isDisable()) {
    			if(assetacc2.getValue().equals(Asset.CURRENT)) {
    				Account asset = new Asset(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Asset.CURRENT);
    				addToRegisterBook(asset, "C");
    			}
    			else if(assetacc2.getValue().equals(Asset.NONCURRENT)) {
    				Account asset = new Asset(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Asset.NONCURRENT);
    				addToRegisterBook(asset, "C");
    			}
			}
			else if(acc2.getValue().equals("Liability") && !liabilityacc2.isDisable()) {
				if(liabilityacc2.getValue().equals(Liability.SHORTPERIOD)) {
    				Account liability = new Liability(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Liability.SHORTPERIOD);
    				addToRegisterBook(liability, "G");
				}
    			else if(liabilityacc2.getValue().equals(Liability.LONGPERIOD)) {
    				Account liability = new Liability(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Liability.LONGPERIOD);
    				addToRegisterBook(liability, "G");
    			}
			}
			else if(acc2.getValue().equals("Income") && !incomeacc2.isDisable()) {
				if(incomeacc2.getValue().equals(Income.OPERATIVE)) {
					Account income = new Income(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Income.OPERATIVE);
					addToRegisterBook(income, "A");
				}
				else if(incomeacc2.getValue().equals(Income.NONOPERATIVE)) {
					Account income = new Income(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Income.NONOPERATIVE);
					addToRegisterBook(income, "A");
				}
			}
			else if(acc2.getValue().equals("Consume")) {
				if(incomeacc1.getValue().equals(Income.OPERATIVE)) {
					Account consume = new Consume(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Income.OPERATIVE);
					addToRegisterBook(consume, "B");
				}
				else if(incomeacc1.getValue().equals(Income.NONOPERATIVE)) {
					Account consume = new Consume(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Income.NONOPERATIVE);
					addToRegisterBook(consume, "B");
				}
			}
			else if(acc2.getValue().equals("Patrimony")) {
				Account patrimony = new Patrimony(nameacc2.getText(),Double.parseDouble(valueacc2.getText()));
				addToRegisterBook(patrimony, "F");
			}
			
			button2.setDisable(true);
	    	
	    	Notifications.create()
	    	.title("Information")
	    	.text("Second account succesfully created")
	    	.darkStyle()
			.hideAfter(Duration.seconds(3))
    		.hideCloseButton()
    		.position(Pos.CENTER)
	    	.showConfirm();
	    	;
		}
		catch(NumberFormatException nfe) {
			Notifications.create()
			.title("Warning")
			.text("You cannot create an account with this invalid values")
			.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.showWarning()
			;
		}
		catch(NullPointerException npe) {
			Notifications.create()
			.title("Warning")
    		.text("You cannot create an account if you either haven't create a company or"
    				+ "if you haven't enter enough information")
			.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.showWarning()
			;
		}
    }
      
    @FXML
    private void generateBalanceSheet(ActionEvent event) throws FileNotFoundException {
    	
       	String balanceSheet = companyName.getText() + "\nBalance Sheet " + datepicker.getValue().toString().substring(0, 7) + "\n" + "\n";
    	double totalAssets = 0;
    	double totalLiabilities = 0;
    	double totalPatrimony = 0;
    	
    	ArrayList<AccountRegister<String,Account>> assets = business.getRegisterBook().getValues("C");
    	
    	for (int i = 0; i < assets.size(); i++) {
			balanceSheet += " " + assets.get(i).getValue().toString();
			totalAssets += assets.get(i).getValue().getValue();
			if(i+1>=assets.size()) {
				balanceSheet += "\nTotal Assets" + totalAssets + "\n" + "\n";
			}
		}
    	
    	ArrayList<AccountRegister<String,Account>> liabilities = business.getRegisterBook().getValues("G");
    	
    	for (int i = 0; i < liabilities.size(); i++) {
			balanceSheet += " " + liabilities.get(i).getValue().toString();
			totalLiabilities += liabilities.get(i).getValue().getValue();
			if(i+1>=liabilities.size()) {
				balanceSheet += "\nTotal Liabilities" + totalLiabilities + "\n" + "\n";
			}
		}
    	
    	ArrayList<AccountRegister<String,Account>> patrimony = business.getRegisterBook().getValues("F");
    	
    	for (int i = 0; i < patrimony.size(); i++) {
			balanceSheet += " " + patrimony.get(i).getValue().toString();
			totalPatrimony += patrimony.get(i).getValue().getValue();
			if(i+1>=patrimony.size()) {
				balanceSheet += "\nTotal Patrimony" + totalPatrimony + "\n" + "\n";
			}
		}
    	
    	balanceSheet += "-------------------------------------------------------" + "\n" + "Total Assets: " + (totalAssets) + "\n";
    	balanceSheet += "-------------------------------------------------------" + "\n" + "Total Liabilities and Patrimony: " 
    	+ (totalLiabilities+totalPatrimony) + "\n";
    	
    	Notifications.create()
    	.title("Information")
    	.text("Balance Sheet succesfully created")
    	.darkStyle()
		.hideAfter(Duration.seconds(3))
		.hideCloseButton()
		.position(Pos.CENTER)
    	.showConfirm();
    	;
    	
    	PrintWriter pw = new PrintWriter("data/BalanceSheet.txt");
    	 	
    	pw.print(balanceSheet);
    	
    	pw.close();
    }

    @FXML
    private void generateIncomeStatement(ActionEvent event) throws FileNotFoundException {
    	
    
    	String incomeStatement = companyName.getText() +"\nIncome Statement " + datepicker.getValue().toString().substring(0, 7) + "\n" + "\n";
    	double totalIncomes = 0;
    	double totalConsumes = 0;
    	
    	ArrayList<AccountRegister<String,Account>> incomes = business.getRegisterBook().getValues("A");
    	
    	for (int i = 0; i < incomes.size(); i++) {
			incomeStatement += " " + incomes.get(i).getValue().toString();
			totalIncomes += incomes.get(i).getValue().getValue();
			if(i+1>=incomes.size()) {
				incomeStatement += "\nTotal Incomes" + totalIncomes + "\n" + "\n";
			}
		}
    	
    	ArrayList<AccountRegister<String,Account>> consumes = business.getRegisterBook().getValues("B");
    	
    	for (int i = 0; i < consumes.size(); i++) {
    		System.out.println("for");
			incomeStatement += " " + consumes.get(i).getValue().toString();
			totalConsumes += consumes.get(i).getValue().getValue();
			if(i+1>=consumes.size()) {
				incomeStatement += "\nTotal Consumes" + totalConsumes + "\n" + "\n";
			}
			System.out.println(totalConsumes);
		}
    	
    	incomeStatement += "-------------------------------------------------------" + "\n" + "Total Utility: " + (totalIncomes - totalConsumes);
    	
    	Notifications.create()
    	.title("Information")
    	.text("Income Statement succesfully created")
    	.darkStyle()
		.hideAfter(Duration.seconds(3))
		.hideCloseButton()
		.position(Pos.CENTER)
    	.showConfirm();
    	;
    	
    	PrintWriter pw = new PrintWriter("data/IncomeStatement.txt");
    	
    	pw.print(incomeStatement);
    	
    	pw.close();
    }
    
    @FXML
    private void addToRegisterBook(Account account, String key) {
    	
    	if(exists(account)==false) { 
	    	business.addAccount(account);
	    	accounts.add(account);
	    	registerBook.setItems(accounts);
    	}
    }	
    
    @FXML
    private boolean exists(Account account) {
	    
    	boolean exists = false;
    	
    	for (int i = 0; i < accounts.size() && exists==false; i++) {
    		if(accounts.get(i).getName().equals(account.getName())) {
				accounts.get(i).setValue(accounts.get(i).getValue()+account.getValue());
				exists = true;
			}
    	}
    	return exists;
    }
}
