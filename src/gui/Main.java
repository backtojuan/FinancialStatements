package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
	
		@Override
		public void start(Stage stage) throws Exception{
			Parent root =
					FXMLLoader.load(getClass().getResource("financialstatements.fxml"));
	
			Scene scene = new Scene(root);
			stage.setTitle("Financial Statements");
			stage.setFullScreen(true);
			stage.setScene(scene);
			
			Image icon = new Image("gui/imgs/icon.png");
			stage.getIcons().add(icon);
			stage.show();
		}
	
	public static void main(String[] args) {
		launch(args);
	}

}

