package methodes;

import java.util.Optional;

// classe service

/**
 * Classe qui propose des méthodes très utiles
 */
public class MesMethodes {
	
	//visibilité [static] void (type de retour) nomMethode(params) {instructions;}
	
	/*
	 * Une classe peut contenir 2 types de méthodes:
	 * - méthode d'instance: est une méthode accéssible via une instance de la classe
	 * - méthode de classe (static): est une méthode accéssible via la classe
	 */
	
	//méthode d'instance
	public  void afficher() {
		System.out.println("méthode afficher........");
	}
	
	//méthode de classe
	
	/**
	 * Méthode qui renvoie la somme de 2 entiers
	 * @author Mourad
	 * @param x: est un entier
	 * @param y: est une entier
	 * @return: renvoie x + y
	 */
	public static int somme(int x, int y) {
		return x + y;
	}
	
	/*
	 * Surcharge (overload) de méthode: pouvoir définir a mm méthode dans la mm classe, en modifiant la liste des params
	 * soit en nombre, soit en type
	 */
	
	//surcharge en modifiant le nombre de params
	public static  void afficher(int[] tab) {
		for(int i : tab) {
			System.out.println(i);
		}
	}
	
	//surcharge en modifiant le type des params
	public static  void afficher(String texte) {
			System.out.println(texte);

	}
	
	public static int somme(int x, int y, int z) {
		return x + y + z;
	}
	
	public static double somme(double x, double y) {
		return x + y;
	}
	
	//Méthode qui renvoie la somme des éléments d'un tableau d'entiers
	
	public static int sommeTableau(int[] tab) {
		int somme = 0;
		for(int e : tab) {
			somme += e;
		}
		return somme;
	}
	
	//Méthode qui renvoie la moyenne des éléments d'un tableau d'entiers
	
	public static double moyenneTableau(int[] tab) {
		double somme = sommeTableau(tab);
		int taille = tab.length;
		return somme/taille;
	}
	
	//Méthode qui renvoie l'élément le plus petit d'un tableau d'entiers
	
	public static int minTableau(int[] tab) {
		
		int min = Integer.MAX_VALUE;
		for(int e : tab) {
			if(e < min) {
				min = e;
			}
		}
		
		return min;
	}
	
	//Méthode pour modifier le contenu d'un entier
	//Passage de paramètres par valeur
	public static void modifierEntier(int x) {
		//méthode qui manipule la valeur de la variable de type int
		x += 10;
	}
	
	public static int modifierInt(int x) {
		return x += 10;
	}
	
	//passage de paramètres par référence	
	public static void modifierTableau(int[] tab) {
		
		//méthode qui manipule la tableau en mémoire
		tab[0] += 10;
	}
	
	//méthode avec des params optionnels
	//option1: lors de l'appel -> Optiona.isEmpty() - optional.of(prenom) -> moins utilisée
	//fournir le type optionnel via les params de la méthode
	
	public static void printName(String nom, Optional<String> optionelPrenom) {
		if(optionelPrenom.isEmpty()) {
			System.out.println("nom: "+nom);
		}else {
			System.out.println("nom: "+nom+" Prénom: "+optionelPrenom.get());
			
		}
	}
	
	//option2: syntaxe recommandée -> gérer le type optionnel dans la méthode
	
	public static void imprimerNom(String nom, String prenomOptionnel) {
		
		Optional<String> op = Optional.ofNullable(prenomOptionnel); //prénom n'est pas obligatoire
		if(op.isPresent()) {
			System.out.println("Nom: "+nom+" Prénom: "+op.get());
		}else {
			System.out.println("Nom: "+nom);
		}
	}
	/*
	public static int sum(int x, int y) {
		return x+y;
	}
	
	public static int sum(int x, int y, int z) {
		return x+y+z;
	}
	
	public static int sum(int x, int y, int z, int v) {
		return x+y+z+v;
	}
	*/
	
	//méthode avec un nombre variable de paramètres
	public static int sum(int...entiers) {
		
		//entiers: est un tableau à taille variable de int
		
		int s = 0;
		for(int e : entiers) {
			s += e;
		}
		return s;
		
	}
	
	public static void test(String nom, String...chaines) {
		
	}
	
	//méthode récursive
	
	public static int factoriel(int value) {
		if(value == 0) {
			return 1;
		}else {
			return value * factoriel(value - 1);
		}
	}

}
