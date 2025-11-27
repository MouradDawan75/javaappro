package conversions;

public class App {
	
	public static void main(String[] args) {
		
		/*
		 * 2 types de conversions
		 */
		
		//conversion implicite: concerne le passage d'un type inférieur à un type supérieur
		
		byte myByte = 15;
		int myInt = myByte;
		
		float myFloat = 15.6f;
		double myDouble = myFloat;
		
		
		//conversion explicite: concerne le passage d'un type supérieur à un type inférieur
		//Utiliser le CAST: (byte), (int)...... -> risque de perte de données
		int i = 15;
		byte b = (byte) i;
		
		//Utiliser les Wrappers qui fournissent des méthodes de conversion
		String s = "50";
		int v = Integer.parseInt(s);
		double d = Double.parseDouble(s);
		
		/*
		 * Les wrappers permettent de savoir les valeurs min et max des types numériques
		 */
		
		int maxInt = Integer.MAX_VALUE;
		int minInt = Integer.MIN_VALUE;
		
		byte minByte = Byte.MIN_VALUE;
		
	}

}
