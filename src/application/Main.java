package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mod.Card;
import mod.JDBC;

public class Main extends Application
{

	public static Stage PrimaryStage;

	public static void main(String[] args) throws IOException
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		try
		{
			AnchorPane root = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/profile.fxml"));
		        Scene scene = new Scene(root, 600, 500);
		        PrimaryStage = primaryStage;
		        PrimaryStage.setTitle("My Profile");
		        PrimaryStage.setScene(scene);
		        PrimaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		Card card = new Card("John", "Amazon", "johnsmith@gmail.com", "0407548795");
		card.save();
	}
}
