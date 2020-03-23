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

	public static int id;

	public static void main(String[] args) throws IOException
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		try
		{
			AnchorPane root = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/connect.fxml"));
		        Scene scene = new Scene(root, 600, 400);
		        PrimaryStage = primaryStage;
		        PrimaryStage.setTitle("Login");
		        PrimaryStage.setScene(scene);
		        PrimaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void ChangerScene(String URL, int width, int height, String Title)
	{
		try {

			AnchorPane root = FXMLLoader.load(Main.class.getClassLoader().getResource("view/profile.fxml"));
			Scene scene = new Scene(root, width, height);
	        PrimaryStage.setTitle(Title);
	        PrimaryStage.setScene(scene);
	        PrimaryStage.setResizable(false);
	        PrimaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
