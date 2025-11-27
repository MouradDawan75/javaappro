package operateurs;

public class App {

	public static void main(String[] args) {
		
		System.out.println("---- opérateurs arithmétiques:");
		//+, -, *, /, %(modulo)
		int i = 25, j = 15;
		int somme = i + j;
		int soustraction = i - j;
		int multipication = i * j;
		double division = i / j;
		int modulo = i % j; // reste de la division entière
		/*
		 * PascalCase: classes
		 * camelCase: variables, méthodes
		 * snake_case: convention utilisée par python
		 */
		
		System.out.println("*** incrémentation et décrementation");
		
		int x = 10, y = 15;
		System.out.println(x++); // 10 - post incrémentation -> utilise le x et l'incrémente par la suite
		System.out.println(x); //
		System.out.println(++y); // 16 - pré incrémentation -> incrémente y et ensuite l'utilise
		
		System.out.println(x--); //post décrementation
		System.out.println(--y); // pré décrementation
		
		x++; // syntaxe simplifiée de: x = x + 1
		x += 5; // syntaxe simplifiée de: x = x + 5
		
		System.out.println("**** Opérateurs de comparaison:");
		// >, >=, <, <=, == (égalité), != (différent) -> renvoient un boolean
		
		System.out.println("**** Opérateurs logiques");
		// && (et logique), || (ou logique), ! (non logique) -> renvoient un boolean
	}
}
