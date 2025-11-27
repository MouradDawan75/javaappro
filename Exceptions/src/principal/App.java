package principal;

import exceptions.CalculException;

public class App {

	public static void main(String[] args) {
		/*
		 * Il exitse 3 types d'erreurs possibles: - Erreurs de compilation (syntaxe):
		 * elles sont détectées automiquement par l'IDE - Exceptions: se sont des
		 * erreurs qui provoquent l'arrêt de l'application - Code fonctionnel, qui
		 * renvoie un résultat inattendu -> debuggage
		 */

		/*
		 * Pour éviter l'arrêt de l'application une exception doit être gérer. Pour
		 * gérer une exception, on utilise le try/catch
		 */

		int[] tab = { 10, 20 };

		/*
		 * Il existe plusieurs types d'exceptions possible, chacune d'elle porte le nom
		 * de l'erreur génère. Il existe un type générique (anonyme) qui est le type
		 * Exception
		 */

		// Obligation: une ressource (fichier, BD) doit être libérée à la fin de son
		// utilisation
		/*
		 * Bonne pratqiue: prévoir un try/catch lors de manipulation de ressources
		 */

		try {
			System.out.println(5 / 5);
			System.out.println(tab[0]);

			// ouverture d'un fichier en lecture

		} catch (ArithmeticException e) {
			System.out.println("bloc catch.................");
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception tableau gérée........");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// file.close()
		} finally {
			// bloc optionnel qui s'exécute tout le temps
			System.out.println("Bloc finally.......");
			// file.close()
			/*
			 * Dans la pratique, le finally sert à libérer les ressources utilisées dans le
			 * try
			 */
		}
		
		try {
			division(0);
		} catch (Exception e) {
			// remplir un fichier de logs, une table......ect
			System.out.println(e.getMessage());
		}

		System.out.println("suite de l'application.....");

	}

	/**
	 * Méthode qui génère une exception si x = 0
	 * @param x
	 * @throws Exception
	 */
	private static void division(int x) throws CalculException {
		//option1: la méthode gère sa propre exception
		/*try {
		System.out.println(10 / x);
		}catch (Exception e) {
			System.out.println("Exception gérée par la méthode......");
		}*/
		
		//option2: faire une remontée d'exception
		if(x != 0) {
			System.out.println(10 / x);
		}else {
			//throw permet de déclencher une exception
			throw new CalculException("Tentative de division par 0");
		}
	}
}

