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
import org.hibernate.query.Query;
import org.sid.entities.Cargaison;
import org.sid.entities.CargaisonAerienne;
import org.sid.entities.CargaisonRoutiere;
import org.sid.entities.Marchandise;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AjouterMarchandiseController implements Initializable {
	
	@FXML private Button bt_quit;
	@FXML private Button bt_accueil;
	@FXML private Button bt_ajout;
	@FXML private TextField tf_num;
	@FXML private TextField tf_poids;
	@FXML private TextField tf_vol;
	@FXML private ComboBox<String> combo;
	private static SessionFactory factory;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		File f = new File("C:/Users/El Mehdi/eclipse-workspace/Gestion_des_cargaisons/src/hibernate.cfg.xml");
	    factory = new Configuration().configure(f).buildSessionFactory();
		Session session = factory.openSession();
	    Transaction transaction = session.beginTransaction();
	    String hql = "SELECT C.ref FROM Cargaison C";
	    Query query = session.createQuery(hql);
	    List results = query.list();
	    transaction.commit();
		try {
			ObservableList<String> ol = FXCollections.observableArrayList();
			ol.addAll(results);
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
	    Session session = factory.openSession();
		String num = tf_num.getText();
		String poids = tf_poids.getText();
		String volume = tf_vol.getText();
		int num1 = Integer.parseInt(num);
		double poids1 = Double.parseDouble(poids);
		double volume1 = Double.parseDouble(volume);
		String nom_c = combo.getValue();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Cargaison C where C.ref = '" + nom_c + "'");
		List<Cargaison> carg = query.list();
		Cargaison result = carg.get(0);
		String r1 = result.getClass().getName();
		if(r1.equals("org.sid.entities.CargaisonAerienne")) {
			Cargaison c1 = new CargaisonAerienne(result.getRef(), result.getDistance());
			Marchandise march = new Marchandise(num1, poids1, volume1, c1);
			session.save(march);
		}
		else {
			Cargaison c1 = new CargaisonRoutiere(result.getRef(), result.getDistance());
			Marchandise march1 = new Marchandise(num1, poids1, volume1, c1);
			session.save(march1);
		}
		transaction.commit();
	    
	}

}
