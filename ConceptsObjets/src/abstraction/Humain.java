package abstraction;

/**
 * Classes filles: Homme, Femme
 */
public abstract class Humain {

	private String nom;
	private String prenom;
	
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
	
	//néssaire pour les classes filles
	public Humain(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Humain() {
		super();
	}
	
	public void Test() {
		
	}
	
	//méthode abstraite: méthode non implémentée
	//Toutes classes filles doivent l'implémenter
	
	public abstract void identite();
	
	
}
