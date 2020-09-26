package org.sid.entities;

import javax.persistence.Entity;
import java.io.Serializable;
@Entity
public class CargaisonRoutiere extends Cargaison implements Serializable {

	public CargaisonRoutiere() {
	}

	public CargaisonRoutiere(String ref, double distance) {
		super(ref, distance);
	}

	public double calculerCout(){

		double tp = 0.0, tv = 0.0;
		for(Marchandise marchandise :  marchandise){
			tp += marchandise.getPoids();
			tv += marchandise.getVolume();
		}
		if (tv < 380000){
			return 4*distance*tp;
		}
		return 6*distance*tp;
	}
}
