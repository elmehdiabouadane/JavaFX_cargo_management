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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.sid.entities.Cargaison;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListCargaisonsController implements Initializable {
	
	@FXML private Button bt_quit;
	@FXML private Button bt_accueil;
	@FXML private TableView<Cargaison> tbl_c;
	@FXML private TableColumn<Cargaison, String> col_ref;
	@FXML private TableColumn<Cargaison, Double> col_dist;
	@FXML private TableColumn<String, String> col_type;
	private static SessionFactory factory;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		File f = new File("C:/Users/El Mehdi/eclipse-workspace/Gestion_des_cargaisons/src/hibernate.cfg.xml");
	    factory = new Configuration().configure(f).buildSessionFactory();
	    Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
		/*col_ref.setCellValueFactory(new PropertyValueFactory<>("R�f�rence"));
		col_dist.setCellValueFactory(new PropertyValueFactory<>("Distance"));
		col_type.setCellValueFactory(new PropertyValueFactory<>("Type de cargaison"));*/
		Query query = session.createQuery("from Cargaison");
	    List results = query.list();
	    ObservableList<Cargaison> ol_c = FXCollections.observableArrayList();
		ol_c.addAll(results);
		System.out.println(ol_c);
		//tbl_c.setItems(ol_c);
		transaction.commit();

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
