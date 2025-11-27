package TP_Calcuatrice;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("""
				- Addition: tapez a
				- Soustraction: tapez s
				- Division: tapez d
				- Multiplication: tapez m
				- Quitter: tapez q
				""");
		
		String choix = sc.nextLine();
		//gestion du break du while
		
		if(choix.equals("q")) {
			System.out.println("Fin du programme....");
			break;
		}
		
		//gestion d'un choix invalide
		while(!(choix.equals("a") || choix.equals("s") || choix.equals("m") || choix.equals("d"))){
			System.out.println("Choix invalide. Saisissez un autre: ");
			choix = sc.nextLine();
			
		}
		
		//demandez 2 nombres
		
		System.out.println("Premier nombre: ");
		double nb1 = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Second nombre: ");
		double nb2 = sc.nextDouble();
		sc.nextLine();
		
		/*
		 * le nom d'une variable peut commencer: soit par une lettre, un undescore, un symbôle monétaire
		 */
		
		//gestion de la division par 0
		if(choix.equals("d") && nb2 == 0) {
			System.out.println("Attention, division par zéro.....");
			while(nb2 == 0) {
				System.out.println("Second nombre différent de 0");
				nb2 = sc.nextDouble();
				sc.nextLine();
			}
		}
		
		//Affichez le résultat:
		switch (choix) {
		case "a":
			System.out.println(nb1 + " + " + nb2 + " = " + (nb1+nb2));			
			break;
			
		case "s":
			System.out.println(nb1 + " - " + nb2 + " = " + (nb1-nb2));			
			break;
			
		case "m":
			System.out.println(nb1 + " x " + nb2 + " = " + (nb1*nb2));			
			break;
			
		case "d":
			System.out.println(nb1 + " / " + nb2 + " = " + (nb1/nb2));			
			break;

		}
		
		
		}
		
		
		
		/*
		 * Tant que le choix saisi est différent de q: l'application continue son exécution
		 * Tant que le choix saisi est invalide, demandez la saisie d'un autre
		 * Le programme doit gérer le cas d'une division par zéro: si choix = "d" -> nombre 2 doit être différent de 0
		 * demandez la saisie de 2 nombres et affichez le résultat
		 */
	}

}
