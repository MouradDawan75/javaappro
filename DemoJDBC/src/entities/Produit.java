package entities;

public class Produit {
	
	/*
	 * public int id -> visible partout (dans tous les packages)
	 * protected int id; -> visible 
	 */
	
	private int id;
	private String description;
	private double prix;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit(int id, String description, double prix) {
		super();
		this.id = id;
		this.description = description;
		this.prix = prix;
	}
	public Produit() {
		super();
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", description=" + description + ", prix=" + prix + "]";
	}
	
	
	
	

}
