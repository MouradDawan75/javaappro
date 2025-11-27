package principal;

import java.io.Serializable;

public class Produit implements Serializable{
	
	private int id;
	private String desciption;
	private double prix;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit(int id, String desciption, double prix) {
		super();
		this.id = id;
		this.desciption = desciption;
		this.prix = prix;
	}
	public Produit() {
		super();
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", desciption=" + desciption + ", prix=" + prix + "]";
	}
	
	

}
