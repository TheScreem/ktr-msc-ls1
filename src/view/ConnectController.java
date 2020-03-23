package view;

import static javax.swing.JOptionPane.showMessageDialog;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mod.JDBC;

public class ConnectController {
	@FXML
	private TextField txt_email;

	@FXML
	private TextField txt_password;

	@FXML
	private Button btn_login;

	@FXML
	private void initialize() {
		btn_login.setOnAction((event) -> {
			int id = JDBC.Login(txt_email.getText(), txt_password.getText());
			if (id != -1) {
				try {
					Main.id = id;
					Main.ChangerScene("profile.fxml", 600, 400, "My profile");
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else
			{
				showMessageDialog(null, "Bad password / email !");
			}
		});
	}
}
