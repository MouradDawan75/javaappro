package principal;

public class MyMethods {
	
	//méthode qui renvoie le nombre de mots dans une chaine
	public static int nombreMots(String chaine) {
		return chaine.trim().replace("  ", " ").split(" ").length;
	}
	
	//méthode qui renvoie la chaine inversée
	public static String inverserChaine(String chaine) {
		String chaineInversee = "";
		for (int i = chaine.length() - 1; i >= 0; i--) {
			chaineInversee += chaine.charAt(i);
		}
		return chaineInversee;
	}
	
	//méthode qui vérifie si une chaine est un palindrôme: sms, sos....
	
	public static boolean verifPalindrome(String chaine) {
		return chaine.equalsIgnoreCase(inverserChaine(chaine));
	}
	
	//méthode qui renvoie le nombre d'occurrences d'un mot dans un paragraphe
	
	public static int nombreOccurrences(String mot, String paragraphe) {
		
		String[] words = paragraphe.split("[ .,;:!?]");
		
		int count = 0;
		
		for(String word : words) {
			if(word.equalsIgnoreCase(mot)) {
				count++;
			}
		}
		
		return count;
	}

}
