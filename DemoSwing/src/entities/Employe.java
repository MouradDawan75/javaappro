package entities;

import java.io.Serializable;

public class Employe implements Serializable{
	
	private int id;
	private String nom;
	private String prenom;
	private Poste poste;
	private double salaire;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public Employe(int id, String nom, String prenom, Poste poste, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.salaire = salaire;
	}
	public Employe() {
		super();
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", poste=" + poste + ", salaire=" + salaire
				+ "]";
	}
	
	

}
