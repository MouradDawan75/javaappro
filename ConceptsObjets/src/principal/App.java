package principal;

import abstraction.Femme;
import abstraction.Homme;
import abstraction.Humain;
import association.Adresse;
import association.CleintFichierImpl;
import association.Client;
import association.ClientDbImpl;
import association.IClient;
import encapsulation.Rectangle;
import heritage.A;
import heritage.Animal;
import heritage.B;
import heritage.C;
import heritage.Chat;
import heritage.Chien;
import heritage.Giraffe;
import heritage.MyClasse;

public class App {
	
	public static void main(String[] args) {
		/*
		 * Approche procédurale: repose sur l'utilisation de paramètres et de fonctions
		 * 
		 * Approche objet: repose sur l'utilisation de classes et d'objets
		 * 
		 * Classe est un type de données. Sa tâche principale est de décrire d'un objet. Elle définie une sorte de template
		 * à partir duquel on crée des objets (des instances).
		 * 
		 * Une classe contient généralement 3 choses:
		 * - Attributs (propriétés): représentent l'état de l'objet
		 * - Méthodes: représentent le comportement de l'objet
		 * - Une méthode spéciale qui porte le nom de la classe, appelée construteur permettant d'instancier la classe en question. 
		 * Le rôle du constructeur est d'initialiser tous les attributs de l'objet à construire
		 * 
		 * 
		 */
		
		System.out.println(User.profil);
		
		User u1 = new User(); // nom = null prenom =  null age = 0
		
		User u2 = new User("DUPONT", "Jean", 45);
		
		u2.afficherInfos();
		
		User.modifierProfil("Manager");
		
		System.out.println(u2);
		
		User u3 = new User("DUPONT", "Jean", 60);
		
		System.out.println(u2.equals(u3));
		
		u2 = null;
		
		//Appel explicite du garbage collector: rien ne garantie son passage immédiat
		System.gc();
		
		User u4 = new User("nom", "prenom", 999);
		
		
		/*
		 * Concepts Objets: Encapsulation - Héritage - Polymorphisme - Abstraction - Composition ou association d'objets)
		 */
		
		System.out.println(">>>>>>>>>>>>>>> encapsulation:");
		
		//Approche procédurale:
		
		double hauteur = 10;
		double largeur = 15;
		double surf = surface(hauteur,largeur);
		
		//Encapsulation: concerne les attributs d'une classe objet
		/*
		 * 1- Regrouper dans une seule et mm classe les params et les fonctions concernent le mm objet
		 * 2- Pas d'accès publique aux attributs d'une classe. L'accès passe forcément par les accésseurs (getter/setter)
		 * avec la possibilité d'ajouter des contrôles
		 */
		
		
		Rectangle rec = new Rectangle();
		rec.setHauteur(-10);
		rec.setLargeur(15);
		rec.surface();
		
		Rectangle rec1 = new Rectangle(-20, 25);
		
		System.out.println(">>>>>>>>>>>>>>>>>>> Héritage:");
		
		Animal a = new Animal();
		a.setNom("a");
		a.setAge(5);
		a.emettreSon();
		
		Chat c = new Chat();
		c.setNom("c");
		c.setAge(3);
		c.emettreSon();
		
		/*
		 * Une classe via l'héritage à accès aux attributs et méthodes définis dans la classe mère
		 * Une classe mère définie une sorte de structure de base aux classes filles. Contient les éléments communs aux classes filles
		 * 
		 * - Une classe fille, en plus des attributs définis dans la classe mère, elle peut avoir des attributs qui lui sont spécifiques
		 * - Une classe fille, en plus des méthodes définies dans la classe mère, elle peut avoir des méthodes qui lui sont spécifiques
		 * - En cas de besoin, une classe peut redéfinir les méthodes définies dans la classe mère
		 */
		
		Animal a2 = new Animal("a2", 4);
		Chat c2 = new Chat("c2", 2, "Gris");
		
		c2.emettreSon();
		
		Animal a3 = new Animal();
		Animal a4 = new Chat();
		Animal a5 = new Chien();
		
		System.out.println(c2 instanceof Chat); //true
		System.out.println(c2 instanceof Animal);//true
		System.out.println(a2 instanceof Animal);//true
		System.out.println(a2 instanceof Chat);//false
		
		
		
		//Polymorphisme: c'est le fait qu'un objet puisse prendre plusieurs formes.
		/*
		 * C'est une conséquence de l'héritage, c'est l'objet parent qui peut prendre la forme de tous les objets enfants
		 * 
		 * Permet d'obtenir des application facile à étendre, qui ne nécessitent beaucoup de modifications
		 */
		
		//Collection polymorphique:
		Animal[] animaux = new Animal[10];
		animaux[0] = new Animal();
		animaux[1] = new Chat();
		animaux[2] = new Chien();
		animaux[3] = new Giraffe();
		
		son(new Animal());
		son(new Chat());
		son(new Chien());
		son(new Giraffe());
		
		A[] tabA = new A[2];
		B[] tabB = new B[2];
		C[] tabC = new C[2];
		
		MyClasse[] collectionPolymorphique = new MyClasse[10];
		
		System.out.println(">>>>>>>>>>>>>> Abstraction:");
		/*
		 * Une classe abstraite est une classe non instanciable. Pour l'instancier, on doit utiliser une de ses classes filles.
		 */
		Homme hm = new Homme();
		Femme fm = new Femme();
		Humain humain = new Femme();
		
		System.out.println(">>>>>>>>>>> Association");
		
		Client cl = new Client("Carrefour", new Adresse(11, "rue machin 75001 Paris"));
		
		IClient ic = new CleintFichierImpl();
		ic.insert(cl);
		ic.update(cl);
		ic.delete(cl);
		
		
		
		
	}

	private static double surface(double hauteur, double largeur) {
		// TODO Auto-generated method stub
		return hauteur * largeur;
	}
	
	//Polymorphisme par sous typage
	
	private static void son(Animal a) {
		a.emettreSon();
	}
	
	//Polymorphisme ad-hoc: déconseiller en pratique, car nécessite un contrôle + un CAST
	
	private static void son2(Object o) {
		if(o instanceof Animal) {
			Animal a = (Animal) o;
			((Animal) o).emettreSon();
		}
	}
	
	private static void mA(A a) {
		
	}
	
private static void mB(B b) {
		
	}

private static void mC(C c) {
	
}

private static void methodePolymorphique(MyClasse m) {
	
}

}
