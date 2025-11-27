package datatypes; 
// commentaire sur une ligne

import java.util.Scanner;

/*
 * Une classe fait forcément partie d'un package
 */

public class App {
	
	/*
	 * méthode main est le point d'entrée d'une application
	 */
	
	public static void main(String[] args) {
		
		//Variable: zone mémoire contenant une valeur typée
		
		// types de bases (types valeurs): entiers, réels, char, boolean -> possèdent une taille prédéfinie
		
		//entiers: byte (1 octet), short (2 octets), int (4 octets), long (8 octets)
		//Java utilise le typage statique: on doit spécifier le type d'une variable
		
		short myShort = 10;
		int myInt = 15;
		byte myByte = 20;
		long myLong = 40;
		
		var v = 10; //inférence de type: le compilateur détermine le type de la variable selon la valeur affectée
		
		//recommandation: à utiliser uniquement pour les variables locales (définie dans une méthode)
		
		char myChar = 'c';
		String s = "test";
		
		float myFloat = 15;
		double myDouble = 35;
		
		boolean myBoolean = false; // codé sur un octet
		
		
		//types complèxes (types références): string, tableaux, date, classes et objets
		
		//Constante: est une variable dont le contenu ne peut pas ^étre modifié
		
		final int x = 10;
		//x = 15; erreur de compilation
		
		//Variables nulles:
		
		//Par définition, les types simples ne sont nullables
		
		//Comment définir des types simples nullables
		//Java propose l'utilisation des Wrappers (sorte de type complèxe qui enveloppe un type simple)
		//Les wrappers permettent de manipuler les types simples comme étant des types complèxes
		/*
		 * int -> Integer
		 * char -> Character
		 * doube -> Double
		 * bool -> Boolean
		 * .
		 * .
		 * .
		 */
		
		Integer age = null;
		
		String st = null; //les types complèxes sont nullables par définit
		
		//générer des valeurs aléatoires
		double aleatoire = Math.random() * 100; //générer une valeur entre 0.0 et 100.0
		
		//Méthode d'affichage dans la console
		System.out.println("Votre nom: ");
		
		//Méthode de lecture
		Scanner sc = new Scanner(System.in);
		String nom = sc.next();
		
		System.out.println(nom);
	}

}
