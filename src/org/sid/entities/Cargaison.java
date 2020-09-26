package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Cargaison implements Serializable {

	@Id
	protected String ref;
	protected double distance;
	@OneToMany(mappedBy = "cargaison", cascade = CascadeType.ALL)
	protected List<Marchandise> marchandise;

	public Cargaison() {
		super();
	}

	public Cargaison(String ref, double distance) {
		super();
		this.ref = ref;
		this.distance = distance;
		marchandise = new ArrayList<>();
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

    public List<Marchandise> getMarchandise() {
        return marchandise;
    }

    public void setMarchandise(List<Marchandise> marchandise) {
        this.marchandise = marchandise;
    }
}
