package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		
		List<Personne> personnes = new ArrayList<Personne>();
		personnes.add(new Personne("Marc", Genre.MASCULIN));
		personnes.add(new Personne("Marie", Genre.FEMININ));
		personnes.add(new Personne("Jean", Genre.MASCULIN));
		personnes.add(new Personne("Clara", Genre.FEMININ));
		
		//Approche impérative: on doit dire au compilateur ce qu'il doit faire et comment le faire
		
		System.out.println(">>>> Approche impérative:");
		List<Personne> feminins = new ArrayList<Personne>();
		
		for(Personne p : personnes) {
			if(p.getGenre().equals(Genre.FEMININ)) {
				feminins.add(p);
			}
		}
		
		for(var p : feminins) {
			System.out.println(p);
		}
		
		
		//Approche déclarative: on déclare ce qu'on veut au compilateur sans lui dire comment le faire
		/*
		 * En Java, pour pratiquer la programmation fonctionnelle, il faut utiliser l'api Stream et les interfaces fonctionnelles
		 */
		System.out.println(">>>> Approche déclarative:");
		
		personnes.stream()
		.filter(p -> p.getGenre().equals(Genre.FEMININ))
		.collect(Collectors.toList())
		.forEach(System.out::println);
		/*
		 * La programmation fonctionnelle repose sur l'utilisation d'interfaces fonctionnelles.
		 * Concept introduit de java 8 (java.util.function)
		 * Une interface fonctionnelle ne possède qu'une seule méthode abstraite
		 */
		
		/*
		 * Instancier une interface fonctionnelle:
		 */
		
		//option1: utiliser une classe qui implèmente l'interface
		
		ICalcul ic1 = new MyCalcul();
		ic1.add(10, 20);
		
		//option2: utiliser une classe anonyme -> syntaxe recommandée uniquement pour les interfaces fonctionnelles 
		//synatxe très utiliser dans les threads et Android
		
		ICalcul ic2 = new ICalcul() {
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
		
		ic2.add(15, 5);
		
		//option3: utiliser une expression lambda : méthode anonyme: (params) -> instructions;
		//syntaxe utilisée dans l'api stream
		
		ICalcul ic3 = (x,y) -> x+y;
		
		//option4: utiliser méthode réference -> réferencier une méthode possèdant la mm signture que celle définie dans
		//l'interface fonctionnelle
		//syntaxe utilisée dans l'api stream
		
		//utiliser une méthode d'instance:
		Compute compute = new Compute();
		ICalcul ic4 = compute::methodeInstance;
		
		//utiliser une méthode static
		
		ICalcul ic5 = Compute::methodeStatic;
		
		/*
		 * Définition de méthodes dans l'approche fonctionnelle
		 */
		
		//fonction
		Function<Personne, String> myFunction = (p) -> p.getNom();
		
		//procédure: void
		Consumer<Personne> afficherPersonne = (p) -> System.out.println(p);
		
		//predicate
		Predicate<Personne> verifNom = (p) -> p.getNom().length() >= 5;
		

	}

}
