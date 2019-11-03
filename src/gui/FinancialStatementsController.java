package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

/**
 * This class manages the necessary attributes and methods to make the graphical user interface works without any trouble for the user
 * @author Lina Salinas Delgado
 * @author Juancho Juan José Valencia Jaramillo
 * @version V.01
 *
 */
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
    /**
     * This method initialize the elements before the fxml file is launched
     */
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
    	liabilityacc1.setItems(FXCollections.observableArrayList(Liability.CURRENT,Liability.NONCURRENT));
    	incomeacc1.setItems(FXCollections.observableArrayList(Income.OPERATIVE,Income.NONOPERATIVE,Consume.SELLSCOST));
    	
    	assetacc1.setDisable(true);
    	liabilityacc1.setDisable(true);
    	incomeacc1.setDisable(true);
    	button1.setDisable(true);
    	 	
    	acc2.setItems(FXCollections.observableArrayList("Asset","Liability","Income","Consume","Patrimony"));
    	
    	assetacc2.setItems(FXCollections.observableArrayList(Asset.CURRENT,Asset.NONCURRENT));
    	liabilityacc2.setItems(FXCollections.observableArrayList(Liability.CURRENT,Liability.NONCURRENT));
    	incomeacc2.setItems(FXCollections.observableArrayList(Income.OPERATIVE,Income.NONOPERATIVE,Consume.SELLSCOST));
    	
    	assetacc2.setDisable(true);
    	liabilityacc2.setDisable(true);
    	incomeacc2.setDisable(true);
    	
    	button2.setDisable(true);	
    }
    
    @FXML
    /**
     * This method creates the company with the required information to generate the required financial statements
     * @param event the event triggered by the user
     */
    private void createCompany(ActionEvent event) {
   
    	if(!companyName.getText().isEmpty()) {
    		if(datepicker.getValue()!=null) {
    			String name = companyName.getText();
    			String date = datepicker.getValue().toString();
    			business = new Business(name);
    	
    	    	Notifications.create()
    	    	.title("Information")
    	    	.text("Company created")
    	    	.darkStyle()
    			.hideAfter(Duration.seconds(3))
        		.hideCloseButton()
        		.position(Pos.CENTER)
    	    	.graphic(new ImageView(new Image("gui/imgs/success.png")))
    	    	.show()
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
        	.graphic(new ImageView(new Image("gui/imgs/warning.png")))
        	.show();
        	;
    	}
    }
       
    @FXML
    /**
     * This method allows to the user only choose 1 option depending of the account of their choice
     * @param event the event triggered by the user.
     */
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
    	else {
        	assetacc1.setDisable(true);
        	liabilityacc1.setDisable(true);
        	incomeacc1.setDisable(true);
        	button1.setDisable(false);
    	}
    }
    
    @FXML
    /**
     * This method allows to the user only choose 1 option depending of the account of their choice
     * @param event the event triggered by the user.
     */
    private void defineAccount2(ActionEvent event) {
    	if(acc2.getValue().equals("Asset")) {
    		assetacc2.setDisable(false);
        	liabilityacc2.setDisable(true);
        	incomeacc2.setDisable(true);
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
    	else {
        	assetacc2.setDisable(true);
        	liabilityacc2.setDisable(true);
        	incomeacc2.setDisable(true);
        	button2.setDisable(false);
    	}
    }
    
    @FXML
    /**
     * this method allows to register an account
     * @param event the event triggered by the user.
     */
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
    				if(liabilityacc1.getValue().equals(Liability.CURRENT)) {
	    				Account liability = new Liability(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Liability.CURRENT);
	    				addToRegisterBook(liability, "G");
    				}
	    			else if(liabilityacc1.getValue().equals(Liability.NONCURRENT)) {
	    				Account liability = new Liability(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Liability.NONCURRENT);
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
    				if(incomeacc1.getValue().equals(Consume.OPERATIVE)) {
    					Account consume = new Consume(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Consume.OPERATIVE);
    					addToRegisterBook(consume, "B");
    				}
    				else if(incomeacc1.getValue().equals(Consume.NONOPERATIVE)) {
    					Account consume = new Consume(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Consume.NONOPERATIVE);
    					addToRegisterBook(consume, "B");
    				}
    				else if(incomeacc1.getValue().equals(Consume.SELLSCOST)) {
    					Account consume = new Consume(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Consume.SELLSCOST);
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
        		.graphic(new ImageView(new Image("gui/imgs/success.png")))
        		.show();
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
    		.graphic(new ImageView(new Image("gui/imgs/error.png")))
    		.show();
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
    		.graphic(new ImageView(new Image("gui/imgs/suggestion.png")))
    		.show();
    		;
    	}
    }

    @FXML
    /**
     * this method allows to register an account
     * @param event the event triggered by the user.
     */
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
				if(liabilityacc2.getValue().equals(Liability.CURRENT)) {
    				Account liability = new Liability(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Liability.CURRENT);
    				addToRegisterBook(liability, "G");
				}
    			else if(liabilityacc2.getValue().equals(Liability.NONCURRENT)) {
    				Account liability = new Liability(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Liability.NONCURRENT);
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
				if(incomeacc2.getValue().equals(Consume.OPERATIVE)) {
					Account consume = new Consume(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Consume.OPERATIVE);
					addToRegisterBook(consume, "B");
				}
				else if(incomeacc2.getValue().equals(Consume.NONOPERATIVE)) {
					Account consume = new Consume(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Consume.NONOPERATIVE);
					addToRegisterBook(consume, "B");
				}
				else if(incomeacc2.getValue().equals(Consume.SELLSCOST)) {
					Account consume = new Consume(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Consume.SELLSCOST);
					addToRegisterBook(consume, "B");
				}
			}
			else if(acc2.getValue().equals("Patrimony")) {
				Account patrimony = new Patrimony(nameacc2.getText(),Double.parseDouble(valueacc2.getText()));
				addToRegisterBook(patrimony, "F");
			}
			
			button2.setDisable(true);
			button1.setDisable(false);
	    	
	    	Notifications.create()
	    	.title("Information")
	    	.text("Second account succesfully created")
	    	.darkStyle()
			.hideAfter(Duration.seconds(3))
    		.hideCloseButton()
    		.position(Pos.CENTER)
    		.graphic(new ImageView(new Image("gui/imgs/success.png")))
    		.show();
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
			.graphic(new ImageView(new Image("gui/imgs/error.png")))
			.show()
			;
		}
		catch(NullPointerException npe) {
			Notifications.create()
			.title("Warning")
    		.text("You cannot create an account if you either haven't create a company"
    				+ "if you haven't enter enough information")
			.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.graphic(new ImageView(new Image("gui/imgs/suggestion.png")))
			.show()
			;
		}
    }
    
    @FXML
    /**
     * This method allows to generate the incomeStatement for a period of the company
     * @param event the event triggered by the user
     * @throws FileNotFoundException
     */
    private void generateIncomeStatement(ActionEvent event) throws FileNotFoundException {
    	
    	try {
	    	String incomeStatement = "---------------------------------------------------------\n "
	    			+ companyName.getText() + "\nIncome Statement " + 
	    	datepicker.getValue().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)).substring(5) + " \n" +
	    	" \n-------------------------------------------------------\n";
	    	
	    	String operativeIncomes = " =========OPERATIVE INCOMES==========\n ";
	    	String nonOperativeIncomes = " =========NON-OPERATIVE INCOMES==========\n ";
	    	String operativeConsumes = " =========OPERATIVE CONSUMES==========\n ";
	    	String nonOperativeConsumes = " =========NON-OPERATIVE CONSUMES==========\n ";
	    	String sellsCostConsumes = " =========SELLS COST CONSUME==========\n ";
	    	double totalIncomes = 0;
	    	double totalConsumes = 0;
	    	
	    	ArrayList<AccountRegister<String,Account>> incomes = business.getRegisterBook().getValues("A");
	    	
	    	for (int i = 0; i < incomes.size(); i++) {
	    		Income in = (Income) incomes.get(i).getValue();
	    		if(in.getProfitValue().equals(Income.OPERATIVE)) {
	    			operativeIncomes += " " + incomes.get(i).getValue().toString() + "\n "; 
	    			totalIncomes += incomes.get(i).getValue().getValue();
	    		}
	    		else if(in.getProfitValue().equals(Income.NONOPERATIVE)) {
	    			nonOperativeIncomes += " " + incomes.get(i).getValue().toString() + "\n "; 
	    			totalIncomes += incomes.get(i).getValue().getValue();
	    		}
				if(i+1>=incomes.size()) {
					incomeStatement += operativeIncomes;
					incomeStatement += nonOperativeIncomes;
					incomeStatement += " \nTotal Incomes " + "$" + totalIncomes + "\n " + "\n ";
				}
			}
	    	
	    	ArrayList<AccountRegister<String,Account>> consumes = business.getRegisterBook().getValues("B");
	    	
	    	for (int i = 0; i < consumes.size(); i++) {
	    		Consume c = (Consume) consumes.get(i).getValue();
	    		if(c.getDerivatedValue().equals(Consume.OPERATIVE)) {
	    			operativeConsumes +=" " + consumes.get(i).getValue().toString() + "\n ";
					totalConsumes += consumes.get(i).getValue().getValue();
	    		} 				
	    		else if(c.getDerivatedValue().equals(Consume.NONOPERATIVE)) {
	    			nonOperativeConsumes +=" " + consumes.get(i).getValue().toString() + "\n ";
					totalConsumes += consumes.get(i).getValue().getValue();
	    		}
	    		else if(c.getDerivatedValue().equals(Consume.SELLSCOST)) {
	    			sellsCostConsumes += " " + consumes.get(i).getValue().toString() + "\n ";
					totalConsumes += consumes.get(i).getValue().getValue();
	    		}
				if(i+1>=consumes.size()) {
					incomeStatement += operativeConsumes;
					incomeStatement += nonOperativeConsumes;
					incomeStatement += sellsCostConsumes;
					incomeStatement += " \nTotal Consumes " + "$" + totalConsumes + "\n " + "\n ";
				}
			}
	    	
	    	incomeStatement += "---------------------------------------------------------\n " 
	    	+ "Total Utility: " + "$" + (totalIncomes - totalConsumes);
	    	
	    	business.setUtility(totalIncomes-totalConsumes);
	    	
	    	Notifications.create()
	    	.title("Information")
	    	.text("Income Statement succesfully created")
	    	.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.graphic(new ImageView(new Image("gui/imgs/success.png")))
			.show();
	    	;
	    	
	    	PrintWriter pw = new PrintWriter("data/IncomeStatement.txt");
	    	
	    	pw.print(incomeStatement);
	    	
	    	pw.close();
    	}
    	catch(NullPointerException npe) {
			Notifications.create()
			.title("Warning")
    		.text("You cannot generate a financial statement if you haven't enter a period")
			.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.graphic(new ImageView(new Image("gui/imgs/suggestion.png")))
			.show();
			;
    	}
    }
    
    @FXML
    /**
     * This method allows to generate the balance sheet for a period of the company
     * @param event the event triggered by the user
     * @throws FileNotFoundException
     */
    private void generateBalanceSheet(ActionEvent event) throws FileNotFoundException {
    	
    	try {
    		File incomestatement = new File("data/incomestatement.txt");
    		
    		if(!incomestatement.exists()) {
    			throw new FileNotFoundException();
    		}
	       	String balanceSheet = "---------------------------------------------------------\n " + 
    		companyName.getText() + " \nBalance Sheet " + 
	       	datepicker.getValue().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)) + "\n " +
	       	" \n-------------------------------------------------------\n ";
	    	
	       	String currentAssets = " =========CURRENT ASSETS==========\n ";
	       	String noncurrentAssets = " =========NONCURRENT ASSETS==========\n ";
	       	String currentLiabilities = " =========CURRENT LIABILITY==========\n ";
	       	String noncurrentLiabilities = " =========CURRENT LIABILITY==========\n ";
	       	
	       	double totalAssets = 0;
	    	double totalLiabilities = 0;
	    	double totalPatrimony = 0;
	    	
	    	ArrayList<AccountRegister<String,Account>> assets = business.getRegisterBook().getValues("C");
	    	
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
					balanceSheet += currentAssets;
					balanceSheet += noncurrentAssets;
					balanceSheet += " \nTotal Assets " + "$" + totalAssets + "\n " + "\n ";
				}
			}
	    	
	    	ArrayList<AccountRegister<String,Account>> liabilities = business.getRegisterBook().getValues("G");
	    	
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
					balanceSheet += currentLiabilities;
					balanceSheet += noncurrentLiabilities;
					balanceSheet += " \nTotal Liabilities " + "$" + totalLiabilities + "\n " + " \n ";
				}
			}
	    	
	    	ArrayList<AccountRegister<String,Account>> patrimony = business.getRegisterBook().getValues("F");
	    	
	    	for (int i = 0; i < patrimony.size(); i++) {
				balanceSheet += " " + patrimony.get(i).getValue().toString() + "\n ";
				totalPatrimony += patrimony.get(i).getValue().getValue();
				if(i+1>=patrimony.size()) {
					balanceSheet += " " + "Name: Utility " + "Value: " + business.getUtility() + "\n";
					totalPatrimony += business.getUtility();
					balanceSheet += " \nTotal Patrimony " + "$" + totalPatrimony + "\n " + "\n ";
				}
			}
	    	
	    	balanceSheet += " -------------------------------------------------------\n" + " Total Assets: " + "$" 
	    	+ (totalAssets) + "\n";
	    	balanceSheet += " -------------------------------------------------------\n" + " Total Liabilities and Patrimony: " 
	    	+ "$"+ (totalLiabilities+totalPatrimony) + "\n";
	    	
	    	Notifications.create()
	    	.title("Information")
	    	.text("Balance Sheet succesfully created")
	    	.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.graphic(new ImageView(new Image("gui/imgs/success.png")))
			.show();
	    	;
	    	
	    	PrintWriter pw = new PrintWriter("data/BalanceSheet.txt");
	    	 	
	    	pw.print(balanceSheet);
	    	
	    	pw.close();
    	}
    	catch(NullPointerException npe) {
			Notifications.create()
			.title("Warning")
    		.text("You cannot generate a financial statement if you haven't enter a period")
			.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.graphic(new ImageView(new Image("gui/imgs/suggestion.png")))
			.show();
			;
    	}
    	catch(FileNotFoundException fnfe) {
    		Notifications.create()
			.title("Warning")
    		.text("You cannot generate a balance sheet if you haven't generate your income statement first")
			.darkStyle()
			.hideAfter(Duration.seconds(3))
			.hideCloseButton()
			.position(Pos.CENTER)
			.graphic(new ImageView(new Image("gui/imgs/suggestion.png")))
			.show();
			;
    	}
    }
    
    @FXML
    /**
     * this method allows to adds an account to the graphical table in the user interface
     * @param account the account that is going to be added
     * @param key the identifier of the account
     */
    private void addToRegisterBook(Account account, String key) {
    	
    	if(exists(account)==false) { 
	    	business.addAccount(account);
	    	accounts.add(account);
	    	registerBook.setItems(accounts);
    	}
    }	
    
    @FXML
    /**
     * This method allows to decide if given an account it already exists or not 
     * @param account the account that is going to be checked
     * @return a boolean value that indicates if either this account already exists or not
     */
    private boolean exists(Account account) {
	    
    	boolean exists = false;
    	
    	for (int i = 0; i < accounts.size() && exists==false; i++) {
    		if(accounts.get(i).getName().equals(account.getName())) {
				accounts.get(i).setValue(accounts.get(i).getValue()+account.getValue());
				registerBook.refresh();
				exists = true;
			}
    	}
    	return exists;
    }
}
