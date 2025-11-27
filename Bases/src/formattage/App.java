package formattage;

public class App {
	
	public static void main(String[] args) {
		
		int age = 35;
		String prenom = "Marie";
		
		//chaine à afficher: Prénom: Marie Age: 35
		
		//1- Concaténation: concaténer des chaines avec des variables
		System.out.println("Prénom: "+prenom+" Age: "+age);
		
		//2- Utiliser la fonction format de la classe String: lien doc https://www.w3schools.com/java/ref_string_format.asp
		String format = "Prénom: %s Age: %d";
		String resultat = String.format(format, prenom,age);
		
		System.out.println(resultat);
		
		//3- Caractères d'echappement
		/*
		 * /n: retour à la ligne
		 * /t: tabulation
		 * /s: space
		 *  /b: backspace
		 */
		
		System.out.println("\tceci est une chaine\nsur plusieurs lignes.");
		
		//pratiquent pour la gestion des paths
		String chemin = "c:\\test\\notes.txt";
		System.out.println(chemin);
		
		/*
		 * Depuis Java 15: ajout de text block: permet de définir des chaines multilignes - chaines verbatimes
		 */
		
		String bloc = """
					ceci est une
				chaine sur plusieurs
				lignes.
				""";
		
		System.out.println(bloc);
	}

}
