package org.sid.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class CargaisonAerienne extends Cargaison implements Serializable {

	public CargaisonAerienne() {
	}

	public CargaisonAerienne(String ref, double distance) {
		super(ref, distance);
	}

	public double calculerCout(){

		return 0;
	}

}
