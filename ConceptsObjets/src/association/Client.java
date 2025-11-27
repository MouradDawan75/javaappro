package association;

public class Client {
	
	private String nom;
	/*
	 * Composition - association: c'est le fait qu'un objet de type Adresse puisse faire partie des attributs d'un objet de type Client
	 */
	private Adresse adresse;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Client(String nom, Adresse adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}
	public Client() {
		super();
	} 
	
	

}
