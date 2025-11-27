package principal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {

	public static void main(String[] args) throws Exception {
		/*
		 * Reflection (introspection): mécanisme permettant de découvrir des types (classes) et d'invoquer leur membres
		 * dynamiquement
		 * 
		 */
		
		//Etape 1: récupérer la classe du type à parcourir
		Class<Employe> employeClasse = Employe.class;
		
		System.out.println(">>>>> Méthodes de la classe employe:");
		
		Method[] methods = employeClasse.getMethods();
		
		for(Method m : methods) {
			System.out.println(m.getName());
		}
		
		System.out.println(">>>>>> Attributs de la classe Employe:");
		
		Field[] fields = employeClasse.getDeclaredFields();
		
		for(Field f : fields) {
			System.out.println(f.getName());
		}
		
		System.out.println(">>>>> Appeler la méthode identite de la classe Employe:");
		
		Method methodIdentite = employeClasse.getMethod("identite", String.class); //String: car ele prend un param de type String
		
		/*
		 * identite est une méthode d'instance: instancier la classe Employe
		 */
		
		Employe emp = employeClasse.getDeclaredConstructor().newInstance(); //appel du constructeur sans params
		
		methodIdentite.invoke(emp, "Java");
		
		Constructor<Employe> constructor = employeClasse.getDeclaredConstructor(String.class, String.class);
		Employe emp2 = constructor.newInstance("Dawan", "Bordeaux");
		
		
		methodIdentite.invoke(emp2, "Formation");

	}

}
