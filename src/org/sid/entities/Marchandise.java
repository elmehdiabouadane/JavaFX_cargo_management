package org.sid.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Marchandise implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;
	private double poids;
	private double volume;
	@ManyToOne
	private Cargaison cargaison;

	public Marchandise(Integer o, int poids, int volume, Cargaison carg) {
		super();
	}

	public Marchandise(int num, double poids, double volume, Cargaison cargaison) {
		this.num = num;
		this.poids = poids;
		this.volume = volume;
		this.cargaison = cargaison;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}
}
