package metiers;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUITS")
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	private String designation;

	private double prix;

	private int qnatite;

	public Produit() {

	}

	public Produit(String designation, double prix, int qnatite) {
		super();

		this.designation = designation;
		this.prix = prix;
		this.qnatite = qnatite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQnatite() {
		return qnatite;
	}

	public void setQnatite(int qnatite) {
		this.qnatite = qnatite;
	}

}