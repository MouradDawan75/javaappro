package principal;

public class Employe extends Object{

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

	public Employe(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Employe() {
		nom = "DUPONT";
		prenom = "Jean";
	}

	public void identite(String param) {
		System.out.println("Nom: " + nom + " Prénom: " + prenom+" "+param);
	}
}
