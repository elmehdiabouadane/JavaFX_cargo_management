package org.sid.application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.sid.entities.Cargaison;
import org.sid.entities.CargaisonAerienne;
import org.sid.entities.CargaisonRoutiere;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AjouterCargaisonController implements Initializable {
	
	@FXML private Button bt_quit;
	@FXML private Button bt_accueil;
	@FXML private Button bt_ajout;
	@FXML private TextField tf_ref;
	@FXML private TextField tf_dist;
	@FXML private ComboBox<String> combo;
	private static SessionFactory factory;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<String> L = new ArrayList<>();
		try {
			L.add("Cargaison a�rienne");
			L.add("Cargaison routi�re");
			ObservableList<String> ol = FXCollections.observableArrayList();
			ol.addAll(L);
			combo.setItems(ol);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	
	@FXML
	private void handleButtonAjouterAction(ActionEvent event) throws IOException {

		File f = new File("C:/Users/El Mehdi/eclipse-workspace/Gestion_des_cargaisons/src/hibernate.cfg.xml");
	    factory = new Configuration().configure(f).buildSessionFactory();
		String ref = tf_ref.getText();
		String dist = tf_dist.getText();
		double dist1 = Double.parseDouble(dist);
		String nom_c = combo.getValue();
		if(nom_c.equals("Cargaison a�rienne")) {
			
			Cargaison carg = new CargaisonAerienne(ref, dist1);
			Session session = factory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(carg);
	        transaction.commit();
			
		}
		else {
			
			Cargaison carg = new CargaisonRoutiere(ref, dist1);
			Session session = factory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(carg);
	        transaction.commit();
			
		}
		
	}

}
