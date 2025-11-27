package conditions;

public class App {
	
	public static void main(String[] args) {
		/*
		 * Bloc conditionnel: est un enseble d'instruction qui ne s'exécute que si une condition est vérifiée
		 * if else if - else --- switch case
		 */
		
		//if / else:
		int x = 0;
		if(x > 0) {
			System.out.println("positif");
		}else if(x < 0) {
			System.out.println("négatif"); //aucune limité sur le nombre de else if
		}else {
			System.out.println("zéro");
		}
		
		//opérateur ternaire: non recommandée en pratique (condition)? valeur si true: valeur si false
		
		int y = 10, z = 20;
		int resultat = (y<z)? y : z;
		
		//switch case:
		int note = 10;
		switch (note) {
		case 0:
			System.out.println("nulle.....");
			break;
			
		case 10:
			System.out.println("Juste la moyenne");
			
		case 11:
		case 12:
		case 13,14:
			System.out.println("Bien");
			break;

		default:
			System.out.println("Excellent....");
			break;
		}
		
		//Depuis Java 13: ajout de switch expression
		
		int experience = 3;
		switch(experience) {
		case 1,2 -> {
			System.out.println("Débutant");
			System.out.println("Junior");
		}
		case 3,4 -> System.out.println("confirmé ou sénior");
		case 5 -> System.out.println("Expert");
		default -> System.out.println("Valeur invalide.....");
		}
		
		/*
		 * Avec switch expression, on a la possibilité d'affecter le résultat à une variable
		 * le mot clé yield, permet de sortir d'un switch expression en retournant une valeur -> fonctionne comme un return 
		 */
		
		String result = switch(experience) {
		case 1,2 -> "Débutant et junior";
		case 3,4 -> "Confirmé ou sénior";
		case 5 ->  { yield "Expert"; } //accolades nécessaires pour le yield
		default -> "Valeur invalide.....";
		};
		
	}

}
