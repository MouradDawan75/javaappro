package principal;

import java.util.Objects;

// classe objet
public class User extends Object{
	
	//attributs d'instance
	public String nom;
	public String prenom;
	public int age;
	
	//attributs communs a toutes les instances 
	public static String profil = "admin"; //instancié 1 seule fois en mémoire
	
	//constructeurs
	public User(String nom, String prenom, int age) {
		
		//this: mot clé qui pointe vers l'objet en cours d'utilisation
		
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	

	public User(String nom) {
		
		this.nom = nom;
	}


	//nécessaire pour des librairies externes
	public User() {
	
	}
	
	
	
	//Méthode d'instance: est une méthode qui agit sur une instance particulière
	public void afficherInfos() {
		System.out.println("Nom: "+nom+" Prénom: "+prenom);
	}
	
	public static void modifierProfil(String newProfil) {
		User.profil = newProfil;
	}



	
	//ToString: permet de personnaliser l'affichage d'un objet -> choisir es attributs à afficher
	
	@Override
	public String toString() {
		
		return "Nom: "+" Prénom: "+prenom+" Age: "+age;
	}



	//garantie l'égalité parfaite de 2 User
	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}


	//Destructeur de la classe: méthode appelée lors du passage du Garbage Collector
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize -- Nom: "+nom);
	}
	
	
	
	

	
	

}
