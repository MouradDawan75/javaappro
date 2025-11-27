package enumeration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Profil{
	ADMIN,
	MANAGER,
	CONSUTANT
}

enum Autorisation{
	LECTURE,
	ECRITURE,
	SUPPRESSION,
	MODIFICATION
}

class User{
	public String nom;
	public Profil profil;
	public List<Autorisation> autorisation = new ArrayList<Autorisation>();
}

public class App {
	
	public enum EtatProduit{
		NEUF, //index 0
		MAUVAIS,
		BON,
		EXCELLENT
	}
	

	public static void main(String[] args) {
		// enum: il s'agit d'une liste de valeurs constantes (connues d'avance)
		
		EtatProduit etat = EtatProduit.BON;
		System.out.println(etat);
		
		System.err.println("Code de votre erreur (0,1,2): ");
		Scanner sc = new Scanner(System.in);
		int code = sc.nextInt();
		
		Erreur er = Erreur.values()[code]; // la méthode values permet de convertir l'enum en tableau
		System.out.println("Votre erreur est: "+er);
		
		//index d'un élément d'une enum:
		
		System.out.println("Index de CRITIQUE: "+Erreur.CRITIQUE.ordinal());
		
		//parcourir une enm:
		Erreur[] tab = Erreur.values();
		
		
		for(Erreur e : tab) {
			System.out.println(e);
		}
		
		User u = new User();
		u.nom = "jean";
		u.profil = Profil.CONSUTANT;
		u.autorisation.add(Autorisation.LECTURE);
		u.autorisation.add(Autorisation.SUPPRESSION);
		
		if(u.autorisation.contains(Autorisation.SUPPRESSION)) {
			System.out.println("Suppression ok......");
		}else {
			System.out.println("Action interdite.....");
		}
		

	}
	
	//Bonne pratique: les déclarer dans des fichiers à part 

}
