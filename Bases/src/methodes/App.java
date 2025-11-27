package methodes;

import java.util.Optional;
import java.util.Scanner;

public class App {

	public static void main(String... args) {
		/*
		 * Méthode: est un ensemble d'instructions réutilisable
		 * 2 types de méthodes:
		 * Procédure: méthode qui ne renvoie aucun résultat (void)
		 * Fonction: méthode qui renvoie un résultat
		 * 
		 * Syntaxe:
		 * 
		 * visibilité [static] void (type de retour) nomMethode(params) {instructions;}
		 * 
		 */
		
		//Appelle d'une méthode d'instance
		MesMethodes m = new MesMethodes(); // m est une instance de la classe MesMethodes
		m.afficher();
		
		//Appelle d'une méthode de classe (static)
		int r = MesMethodes.somme(10,20);
		System.out.println("résultat = "+r);
		
		int[] tab = {10,2,7,5,12,11};
		MesMethodes.afficher(tab);
		
		System.out.println("Somme tab = "+MesMethodes.sommeTableau(tab));
		System.out.println("Moyenne tab = "+MesMethodes.moyenneTableau(tab));
		System.out.println("Min tab = "+MesMethodes.minTableau(tab));
		
		int value = 3;
		MesMethodes.modifierEntier(value);
		
		System.out.println("value = "+value);
		
		MesMethodes.modifierTableau(tab);
		
		System.out.println("tab[0] = "+tab[0]); //20
		
		value = MesMethodes.modifierInt(value);
		
		//Le type Optional ne fonctionne qu'avec les types complèxes
		
		System.out.println("Votre nom: ");
		Scanner sc = new Scanner(System.in);
		String nom = "dddd"; //lecture d'une cellule vide dans une table
		
		Optional<String> op = Optional.ofNullable(nom);
		
		if(op.isEmpty()) {
			System.out.println("Aucune saisie");
		}else {
			System.out.println("Vous avez saisi: "+op.get()); //\n
		}
		
		//params optionnels -> option1:
		MesMethodes.printName("DUPONT", Optional.of("Jean"));
		MesMethodes.printName("DUPONT", Optional.empty());
		
		//params optionels: option2:
		MesMethodes.imprimerNom("DURAND", "Patrice");
		MesMethodes.imprimerNom("DURAND", null);
		
		//Appelle de la méthode avec un nbre variable de params:
		System.out.println(MesMethodes.sum(10,20));
		System.out.println(MesMethodes.sum(10,20,30));
		System.out.println(MesMethodes.sum(10,20,30,40));
		
		
		
		
		

	}

}
