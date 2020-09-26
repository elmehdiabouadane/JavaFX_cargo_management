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

public class AccueilController implements Initializable {
	
	@FXML private Button bt_quit;
	@FXML private Button bt_ajout_c;
	@FXML private Button bt_ajout_m;
	@FXML private Button bt_list_c;
	@FXML private Button bt_list_m;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

	}
	
	@FXML
	private void handleButtonQuitterAction(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	private void handleButtonAjouterCargaisonAction(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("AjoutCarg.fxml"));
		Scene scene = new Scene(root);
		StageSlider.getPrimaryStage().setScene(scene);
		StageSlider.getPrimaryStage().show();
		
	}
	
	@FXML
	private void handleButtonAjouterMarchandiseAction(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("AjoutMarch.fxml"));
		Scene scene = new Scene(root);
		StageSlider.getPrimaryStage().setScene(scene);
		StageSlider.getPrimaryStage().show();
		
	}
	
	@FXML
	private void handleButtonListCargaisonAction(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("ListCargaisons.fxml"));
		Scene scene = new Scene(root);
		StageSlider.getPrimaryStage().setScene(scene);
		StageSlider.getPrimaryStage().show();
		
	}
	
	@FXML
	private void handleButtonListMarchandiseAction(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("ListMarchandises.fxml"));
		Scene scene = new Scene(root);
		StageSlider.getPrimaryStage().setScene(scene);
		StageSlider.getPrimaryStage().show();
		
	}
	
}
