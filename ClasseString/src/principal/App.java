package principal;

public class App {

	public static void main(String[] args) {
		
		String s = "test"; //possibilté d'instancier la classe String sans faire appel au constructeur, via une chaine littérale
		s = s.toUpperCase();
		System.out.println(s);
		// Le type String par définition est immuable
		
		String chaine = " hello ";
		
		//quelques méthodes de la classe String
		System.out.println("taille: "+chaine.length()); //7
		System.out.println("Suppression d'éspace en début et fin de chaine: "+chaine.trim());
		System.out.println(chaine.toLowerCase());
		System.out.println(chaine.toUpperCase());
		System.out.println(chaine.startsWith("h")); //false
		System.out.println(chaine.endsWith("o ")); //true
		System.out.println(chaine.isEmpty());
		System.out.println(chaine.replace('e', 'a'));
		System.out.println(chaine.replace("ello", "ome"));
		System.out.println(chaine.equals(" hello "));
		System.out.println(chaine.equalsIgnoreCase(" HELLO "));
		
		//un objet String est un tableau de char en mémoire
		char c1 = chaine.charAt(1);
		
		//convertir une chaine en tableau de char
		char[] tab = chaine.toCharArray();
		char c2 = tab[0];
		
		System.out.println("Sous chaine: "+chaine.substring(2)); // du char 2 jusqu'à la fin
		System.out.println("Autre sous chaine: "+chaine.substring(1,3)); // de char 1 à  char 3
		
		//Découpage d'une chaine: split
		
		String chaineCsv = "word1,word2,word3";
		String[] mots = chaineCsv.split(",");
		
		for(String m:mots) {
			System.out.println(m);
		}
		
		String autreCsv = "mot1,mot2 mot3:mot4;mot5";
		String[] resultat = autreCsv.split("[, :;]");
		
		for(String e : resultat) {
			System.out.println(e);
		}
		
		//Join: construire une chaine
		System.out.println(String.join(" ", "m1","m2","m3"));
		
		System.out.println(MyMethods.nombreMots("m1 m2 m3"));
		System.out.println(MyMethods.inverserChaine("bonjour"));
		System.out.println(MyMethods.verifPalindrome("Sms"));
		System.out.println(MyMethods.nombreOccurrences("dawan", "Dawan test dawan test dawan. dawan:"));
		
		System.out.println(">>>>>>>> StringBuilder:");
		
		//Contrairement au type String, le type StringBuilder est muable
		
		StringBuilder sb = new StringBuilder();
		sb.append("test");
		sb.append("e");
		System.out.println(sb.toString());
		
		
	}

}
