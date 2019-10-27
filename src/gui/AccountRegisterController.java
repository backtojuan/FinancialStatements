package gui;

import javafx.stage.Stage;
import javafx.util.Duration;
import model.Business;
import model.Account;
import model.Asset;
import model.Income;
import model.Liability;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AccountRegisterController {

    @FXML
    private TextField nameacc1;

    @FXML
    private TextField valueacc1;

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
    private Stage stage;
       
    @FXML
    public void initialize() {
    	
    	assetacc1.setItems(FXCollections.observableArrayList(Asset.CURRENT,Asset.NONCURRENT));
    	liabilityacc1.setItems(FXCollections.observableArrayList(Liability.SHORTPERIOD,Liability.LONGPERIOD));
    	incomeacc1.setItems(FXCollections.observableArrayList(Income.OPERATIVE,Income.NONOPERATIVE));
    	
    	assetacc1.setDisable(true);
    	liabilityacc1.setDisable(true);
    	incomeacc1.setDisable(true);
    	
    	button1.setDisable(true);
    	 	
    	assetacc2.setItems(FXCollections.observableArrayList(Asset.CURRENT,Asset.NONCURRENT));
    	liabilityacc2.setItems(FXCollections.observableArrayList(Liability.SHORTPERIOD,Liability.LONGPERIOD));
    	incomeacc2.setItems(FXCollections.observableArrayList(Income.OPERATIVE,Income.NONOPERATIVE));
    	
    	assetacc2.setDisable(true);
    	liabilityacc2.setDisable(true);
    	incomeacc2.setDisable(true);
    	
    	button2.setDisable(true);
    }
    
    @FXML
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
    
    @FXML
    public void makeAsset1Available(ActionEvent event) {
    	assetacc1.setDisable(false);
    	liabilityacc1.setDisable(true);
    	incomeacc1.setDisable(true);
    	button1.setDisable(false);
    }

    @FXML
    public void makeAsset2Available(ActionEvent event) {
    	assetacc2.setDisable(false);
    	liabilityacc2.setDisable(true);
    	incomeacc2.setDisable(true);
    }

    @FXML
    public void makeIncome1Available(ActionEvent event) {
    	assetacc1.setDisable(true);
    	liabilityacc1.setDisable(true);
    	incomeacc1.setDisable(false);
    	button1.setDisable(false);
    }

    @FXML
    public void makeIncome2Available(ActionEvent event) {
    	assetacc2.setDisable(true);
    	liabilityacc2.setDisable(true);
    	incomeacc2.setDisable(false);
    }

    @FXML
    public void makeLiability1Available(ActionEvent event) {
    	assetacc1.setDisable(true);
    	liabilityacc1.setDisable(false);
    	incomeacc1.setDisable(true);
    	button1.setDisable(false);
    }

    @FXML
    public void makeLiability2Available(ActionEvent event) {
    	assetacc2.setDisable(true);
    	liabilityacc2.setDisable(false);
    	incomeacc2.setDisable(true);
    }
    
    @FXML
    public void makePatrimony1Available(ActionEvent event) {
    	
    }

    @FXML
    public void makePatrimony2Available(ActionEvent event) {

    }
    
    @FXML
    public void registerAccount1(ActionEvent event) {
    	
    	try {
    			if(!assetacc1.isDisable()) {
	    			if(assetacc1.getValue().equals(Asset.CURRENT)) {
	    				Account asset = new Asset(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Asset.CURRENT);
	    			}
	    			else if(assetacc1.getValue().equals(Asset.NONCURRENT)) {
	    				Account asset = new Asset(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Asset.NONCURRENT);
	    			}
    			}
    			else if(!liabilityacc1.isDisable()) {
    				if(liabilityacc1.getValue().equals(Liability.SHORTPERIOD)) {
	    				Account liability = new Liability(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Liability.SHORTPERIOD);
	    			}
	    			else if(liabilityacc1.getValue().equals(Liability.LONGPERIOD)) {
	    				Account liability = new Liability(nameacc1.getText(),Double.parseDouble(valueacc1.getText()),Liability.LONGPERIOD);
	    			}
    			}
    			else if(!incomeacc1.isDisable()) {
    				if(incomeacc1.getValue().equals(Income.OPERATIVE)) {
    					Account income = new Income(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Income.OPERATIVE);
    				}
    				else if(incomeacc1.getValue().equals(Income.NONOPERATIVE)) {
    					Account income = new Income(nameacc1.getText(), Double.parseDouble(valueacc1.getText()), Income.NONOPERATIVE);
    				}
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
    		.text("You cannot create an account if you haven't enter enough information")
    		.darkStyle()
    		.hideAfter(Duration.seconds(7))
    		.hideCloseButton()
    		.position(Pos.CENTER)
    		.showWarning()
    		;
    	}
    }

    @FXML
    public void registerAccount2(ActionEvent event) {
    	
    	try {
			if(!assetacc2.isDisable()) {
    			if(assetacc2.getValue().equals(Asset.CURRENT)) {
    				Account asset = new Asset(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Asset.CURRENT);
    			}
    			else if(assetacc2.getValue().equals(Asset.NONCURRENT)) {
    				Account asset = new Asset(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Asset.NONCURRENT);
    			}
			}
			else if(!liabilityacc2.isDisable()) {
				if(liabilityacc2.getValue().equals(Liability.SHORTPERIOD)) {
    				Account liability = new Liability(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Liability.SHORTPERIOD);
    			}
    			else if(liabilityacc2.getValue().equals(Liability.LONGPERIOD)) {
    				Account liability = new Liability(nameacc2.getText(),Double.parseDouble(valueacc2.getText()),Liability.LONGPERIOD);
    			}
			}
			else if(!incomeacc2.isDisable()) {
				if(incomeacc2.getValue().equals(Income.OPERATIVE)) {
					Account income = new Income(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Income.OPERATIVE);
				}
				else if(incomeacc2.getValue().equals(Income.NONOPERATIVE)) {
					Account income = new Income(nameacc2.getText(), Double.parseDouble(valueacc2.getText()), Income.NONOPERATIVE);
				}
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
	    	Stage stage = (Stage) nameacc1.getScene().getWindow();
	    	stage.close();
		}
		catch(NumberFormatException nfe) {
			Notifications.create()
			.title("Warning")
			.text("You cannot create an account with this invalid values")
			.darkStyle()
			.hideAfter(Duration.seconds(7))
			.hideCloseButton()
			.position(Pos.CENTER)
			.showWarning()
			;
		}
		catch(NullPointerException npe) {
			Notifications.create()
			.title("Warning")
			.text("You cannot create an account if you haven't enter enough information")
			.darkStyle()
			.hideAfter(Duration.seconds(7))
			.hideCloseButton()
			.position(Pos.CENTER)
			.showWarning()
			;
		}
    }
}
