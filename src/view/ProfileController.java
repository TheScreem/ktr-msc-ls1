package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mod.Card;

public class ProfileController
{
	@FXML
	private TextField txt_name;

	@FXML
	private TextField txt_company_name;

	@FXML
	private TextField txt_email_address;

	@FXML
	private TextField txt_phone_number;

	@FXML
	private Button btn_save;

    @FXML
    private void initialize()
    {
    	Card currentCard = Card.getCardProfile();

    	if (currentCard != null)
    	{
    		txt_name.setText(currentCard.getName());
        	txt_company_name.setText(currentCard.getCompanyName());
        	txt_email_address.setText(currentCard.getEmail());
        	txt_phone_number.setText(currentCard.getPhoneNumber());
    	}

    	 btn_save.setOnAction((event) ->
    	 {
    		 Card newCard;

    		 if (currentCard != null)
    		 {
    			 newCard = new Card(currentCard.getId(), txt_name.getText(), txt_company_name.getText(), txt_email_address.getText(), txt_phone_number.getText());
    		 }
    		 else
    		 {
    			 newCard = new Card(null, txt_name.getText(), txt_company_name.getText(), txt_email_address.getText(), txt_phone_number.getText());
    		 }

    		 newCard.save();
    	 });
    }



}
