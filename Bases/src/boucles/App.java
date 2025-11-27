package boucles;

import java.util.Scanner;


public class App {
	
	public static void main(String[] args) {
		/*
		 * for: si nombre d'itérations connu d'avance
		 * for each: permet de parcourir tous les éléments d'une collection: tableau, liste.....
		 * while ou do while: boucle conditionnelle -> si nom bre d'itérations non connu -> mais traitement dépendant d'une condition
		 */
		
		// For: afficher hello 5 fois
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello");
		}
		
		
		// For each:
		int[] tab = {10,20,30,33,36,31,44};
		
		//affichez uniquement les nombres impairs
		for (int i : tab) {
			
			if(i % 2 == 0) {
				continue; //force le passage à l'itération suivante -< la site de la boucle n'est pas exécutée
			}
			
			System.out.println(i);
		}
		
		// while:
		//demandez la saisie d'un  nombre entre 1 et 10. Tant que le nombre saisi n'est pas valide, redemmandez la saisie d'un autre
		
		System.out.println(">>>>> While infinie:");
		
		//boucle infinie explicite
		while(true) {
		System.out.println("Nombre entre 1 et 10: ");
		Scanner sc = new Scanner(System.in);
		int nb = sc.nextInt();
			if(nb >= 1 && nb <= 10) {
				break;
			}
		}
		
		System.out.println(">>>>> While finie:");
		//boucle finie:
		
		int nombre = 0;
		while(!(nombre >= 1 && nombre <= 10)) {
			System.out.println("Nombre entre 1 et 10: ");
			Scanner sc = new Scanner(System.in);
			nombre = sc.nextInt();
		}
		
		//Do While: s'exécute au moins une fois
		
		int x = 0;
		
		do {
			System.out.println(x);
			x++;
		}while(x < 5);
		
	}

}
