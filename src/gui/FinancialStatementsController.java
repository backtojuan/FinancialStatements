package gui;

import java.io.IOException;

import org.controlsfx.control.Notifications;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import model.Account;
import model.Business;

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
    
    private Business business;

    @FXML
    public void initialize() {
    	TableColumn<Account,String> fecolumn = new TableColumn<Account,String>("Account´s Name");
    	fecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    	
    	business = new Business("Universidad Icesi");
    }
    
    @FXML
    public void addAccount(ActionEvent event) throws IOException{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("accountregister.fxml"));
			
			Scene scene = new Scene(root);
	    	
			Stage stage = new Stage();
	    	AccountRegisterController arc = new AccountRegisterController();
			arc.setStage(stage);
			
			stage.setTitle("Account Register");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.centerOnScreen();
			stage.initStyle(StageStyle.UNDECORATED);
			stage.initModality(Modality.APPLICATION_MODAL);

			
			Image icon = new Image("gui/imgs/icon.png");
			stage.getIcons().add(icon);
			stage.show();
			
		} catch (IOException ioe) {
			Notifications.create()
			.title("IMPORTANT")
			.text("The graphic interface cannot be loaded due to file problems")
			.darkStyle()
			.hideAfter(Duration.seconds(7))
			.hideCloseButton()
			.position(Pos.CENTER)
			.showError();
			;
		}
    	
    }

    @FXML
    public void generateBalanceSheet(ActionEvent event) {
    	
    }

    @FXML
    public void generateIncomeStatement(ActionEvent event) {

    }
    
    @FXML
    public void initializeRegisterBook(Account account) {
    	TableColumn<Account,Double> valuecolumn = new TableColumn<>("Transaction Value");
    	valuecolumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    	
    	
    }
}
