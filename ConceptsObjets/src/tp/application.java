package tp;

import java.util.Scanner;

public class application {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		IPersonnel service ;
		
		System.out.println("""
				1- Tableau: tapez 1
				2- Fichier: tapez 2
				""");
		
		int choixService = sc.nextInt();
		
		switch(choixService) {
		case 1:
			service = new Personnel(10);
			break;
			
		case 2:
			service = new PersonnelFichier();
			break;
			
			default:
				service = new Personnel(10); //tableau par défaut
				break;
		}
		
		while(true) {
			
		System.out.println("""
				1- Ajouter un employé
				2- Afficher le salaire de chaque employé
				3- Afficher le salaire moyen
				4- Quitter
				""");
		
		int choix = sc.nextInt();
		
		if(choix == 4) {
			System.out.println("Fin du programme....");
			break;
		}
		
		switch (choix) {
		case 1:
			System.out.println("Nom: ");
			String nom = sc.next();
			
			System.out.println("Prénom: ");
			String prenom = sc.next();
			
			System.out.println("Age: ");
			int age = sc.nextInt();
			
			System.out.println("Date d'entrée: ");
			String dateEntree = sc.next();
			
			System.out.println("""
					Pour vendeur: tapez v
					Pour représentant: tapez r
					Pour technicien: tapez t
					Pour manutentionnaire: tapez m
					""");
			
			String typeEmploye = sc.next();
			double ca = 0;
			Employe e = null;
			
				switch(typeEmploye) {
				
					case "v":
						System.out.println("Chiffre d'affaire:");
						ca = sc.nextDouble();
						e = new Vendeur(nom, prenom, age, dateEntree, ca);
						break;
						
					case "r":
						System.out.println("Chiffre d'affaire:");
						ca = sc.nextDouble();
						e = new Representant(nom, prenom, age, dateEntree, ca);
						break;
						
					case "t":
						System.out.println("Nombre d'unités:");
						double unites = sc.nextDouble();
						e = new Technicien(nom, prenom, age, dateEntree, unites);
						break;
						
					case "m":
						System.out.println("Nombre d'heures:");
						double  heures = sc.nextDouble();
						e = new Manutentionnaire(nom, prenom, age, dateEntree, heures);
						break;
				
				}
				
				service.ajouterEmploye(e);
			
			break;
			
		case 2:
			service.calculerSalaires();
			break;
			
		case 3:
			double salaireMoyen = service.salaireMoyen();
			System.out.println("Salaire moyen = "+salaireMoyen);
			break;

		default:
			System.out.println("Choix invalide.....");
			break;
		}
		
		}
	}

}
