package tableaux;

public class App {

	public static void main(String[] args) {
		//Tableau statique:
		
		int[] tab = new int[3]; //tableau de 4 cases -> index commence à 0
		tab[0] = 10;
		tab[1] = 20;
		
		//si le contenu est connu d'avance
		int[] tableau = {10,20,30,40};
		
		System.out.println("Premier élément: "+tableau[0]);
		System.out.println("Taille du tableau: "+tableau.length);
		
		//parcourir un tableau:
		
		System.out.println(">>> for each:");
		
		//for each: pour chaque élément contenu dans le tableau
		for(int i : tableau) {
			System.out.println(i);
		}
		
		System.out.println(">>> for:");
		for (int i = 0; i < tableau.length; i++) {
			System.out.println(tableau[i]);
		}
		
		System.out.println(">>>> tableau de tableaux:");
		// tableau à 2 dimensions: tableau de tableaux
		
		int[][] matrice = new int[2][]; // 2 lignes
		matrice[0] = new int[2];
		matrice[1] = new int[3];
		
		//si le contenu est connu d'avance:
		int[][] matrix = {{10,20} , {30,40,50}};
		
		//parcourir matrix:
		
		//fixer les lignes
		for (int ligne = 0; ligne < matrix.length; ligne++) {
			
			//fixer les colonnes
			for (int colonne = 0; colonne < matrix[ligne].length; colonne++) {
				System.out.println(matrix[ligne][colonne]);
			}
		}
		
		//Inconvénient: taille non variable
		

	}

}
