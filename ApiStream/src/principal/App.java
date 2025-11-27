package principal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws Exception {
		/*
		 * L'api Stream permet d'effectuer des opérations sur une source de données (filtrer, transformer...) et de récupérer 
		 * le résultat final, sans modifier la source de départ.
		 * 
		 * 2 types de streams:
		 * -Séquentiel
		 * -Parallel
		 * 
		 */
		
		//Stream à partir d'une liste de valeurs constantes
		
		Stream<String> streamOfValues = Stream.of("a1","a2","a3");
		
		//Stream à partir d'un tableau
		String[] tab = {"a1","a2","a3"};
		Stream<String> streamOfArray = Arrays.stream(tab);
		
		//Stream à partir d'un fichier
		File f = new File("a.tmp");
		Stream<String> streamOfFile = Files.lines(Paths.get(f.getAbsolutePath()));
		
		//Stream à partir Collection
		
		Collection<String> myCollection = new ArrayList<String>();
		Stream<String> streamOfCollection = myCollection.stream();
		
		testFilterAndCount();
		testMap();
		testSkipLimit(); //mise en place d'une pagination
		testDistinct();
		testReduce();
		testParallelStream();
		
		/*
		 * Pour créer des collections de types numériques:
		 */
	
		//séquentiel
		System.out.println(IntStream.rangeClosed(1, 10).reduce(-10, Integer::sum)); //réduire de 10 la somme de tous les éléments
		
		//parallel
		/*
		 * réduire de 10 chaque élément -> les additionner à la fin
		 */
		System.out.println(IntStream.rangeClosed(1, 10).parallel().reduce(-10, Integer::sum));
		
		/*
		 * ParallelStream pratique pour applique un traitement à l'ensemble des objets d'une collection
		 */

	}

	private static void testParallelStream() {
		System.out.println(">>>>>> Test Parallel Stream:");
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		
		/*
		 * chaque élément de la collection est traité par un thread à part
		 */
		numbers.parallelStream()
		.forEach(n -> System.out.println(n+" "+Thread.currentThread().getName()));
		
	}

	private static void testReduce() {
		System.out.println(">>>>>> Test Reduce:");
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		
		Integer result = numbers.stream()
		.reduce(-5, Integer::sum);
		
		System.out.println("result = "+result);
		
	}

	private static void testDistinct() {
		System.out.println(">>>>>>> Test Distinct:");
		Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");
		
		collection.stream()
		.distinct()
		.forEach(e -> System.out.println(e));
		
	}

	private static void testSkipLimit() {
		
		System.out.println(">>>>>>> Test Skip et Limit:");
		Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");
		
		collection.stream()
		.limit(2)
		.forEach(e -> System.out.println(e));
		
		//pagination
		System.out.println(">>> pagination:");
		collection.stream()
		.skip(0)
		.limit(2)
		.forEach(e -> System.out.println(e));
		
		System.out.println(">> les 2 éléments suivants:");
		
		collection.stream()
		.skip(2)
		.limit(2)
		.forEach(e -> System.out.println(e));
		
	}

	private static void testMap() {
		
		System.out.println(">>>>>>>>>>>>> Test Map:");
		
		List<People> peoples = new ArrayList<People>();
		peoples.add(new People("William", 16, Genre.MAN));
		peoples.add(new People("John", 26, Genre.MAN));
		peoples.add(new People("Helene", 42, Genre.WOMAN));
		peoples.add(new People("Peter", 69, Genre.MAN));
		
		List<PeopleDto> dtos = peoples.stream()
		.map(p -> new PeopleDto(p.getNom(), p.getAge()))
		.collect(Collectors.toList());
		
		dtos.forEach(d -> System.out.println(d));
		
	}

	private static void testFilterAndCount() {
		System.out.println(">>>> Test filter and count:");
		
		Collection<String> collection = Arrays.asList("a1","a2","a3","a1","a1");
		
		//compter le nombre de a1:
		long count = collection.stream()
		.filter(e -> e.equals("a1"))
		//.filter("a1"::equals)
		.count();
		
		System.out.println("Nombre de a1: "+count);
		
		List<People> peoples = new ArrayList<People>();
		peoples.add(new People("William", 16, Genre.MAN));
		peoples.add(new People("John", 26, Genre.MAN));
		peoples.add(new People("Helene", 42, Genre.WOMAN));
		peoples.add(new People("Peter", 69, Genre.MAN));
		
		//Le nombre et la liste de people apte pour le service militaire: age entre 18 et 27 - genre MASCULIN
		
		List<People> result = peoples.stream()
		.filter(p -> p.getAge()>=18 && p.getAge()<=27 && p.getGenre().equals(Genre.MAN))
		.collect(Collectors.toList());
		
		System.out.println("Nombre apte pour le service militaire: "+result.size());
		result.forEach(p -> System.out.println(p));
		
		//Le nombre de people pouvant travailler: age minimum 18, max 60 pour les hommes et 55 pour les femmes
		long nbPeoplePouvantTravailer = peoples.stream()
		.filter(p -> p.getAge() >= 18)
		.filter((p) -> (p.getAge() <= 55 && p.getGenre().equals(Genre.WOMAN)) || ( p.getAge() <= 60 && p.getGenre().equals(Genre.MAN)))
		.count();
		
		System.out.println("People pouvant travailler: "+nbPeoplePouvantTravailer);
		
		
	}

}
