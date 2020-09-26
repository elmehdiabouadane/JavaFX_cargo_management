package org.sid.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;


public class Main extends Application {
	
	private static SessionFactory factory;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			File f = new File("D:\\Cours\\Cycle\\4�me ann�e\\Semestre 2\\JAVA\\eclipse-workspace\\Gestion_des_cargaisons\\src\\hibernate.cfg.xml");
	        factory = new Configuration().configure(f).buildSessionFactory();
	        
	        /*Cargaison carg = new CargaisonAerienne("CargA1", 5000);
	        Marchandise march = new Marchandise(1, 40000, 7000, carg);
	        Session session = factory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(carg);
	        session.save(march);
	        transaction.commit();*/
			
			primaryStage = StageSlider.getPrimaryStage();
	        Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
