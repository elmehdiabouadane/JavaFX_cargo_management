package org.sid.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListMarchandisesController implements Initializable {
	
	@FXML private Button bt_quit;
	@FXML private Button bt_accueil;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	@FXML
	private void handleButtonQuitterAction(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	private void handleButtonAccueilAction(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		Scene scene = new Scene(root);
		StageSlider.getPrimaryStage().setScene(scene);
		StageSlider.getPrimaryStage().show();
		
	}

}
