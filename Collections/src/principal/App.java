package principal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class App {

	public static void main(String[] args) {
		/*
		 * Tous les objets de type collection sont des tableaux dynamiques qui peuvent
		 * contenir que des types complèxes. 2 types de cllections: type mapping:
		 * Association clé:valeur -> Map type array: ArrayList, List, Set, Queue, Stack
		 * 
		 * Toutes les collections de type Array (ArrayList, List, Set, Stack et Queque) dérivent de la même Interface
		 * Collection
		 * 
		 * 
		 */
		 
		
		Collection myCollection = new ArrayList();
		myCollection = new HashSet();
		myCollection = new Stack();
		myCollection = new LinkedList();

		System.out.println(">>>>>>>>>>>> ArrayList:");

		/*
		 * ArrayList: collection polymorphique, ordonnée avec doublons autorisés
		 */

		ArrayList myArray = new ArrayList(); // collection polymorphique

		System.out.println("Taiile: " + myArray.size());

		// ajouts:
		myArray.add("test");
		myArray.add(10);
		myArray.add(true);

		myArray.add(1, "chaine");

		// modifications:
		myArray.set(0, 45.5);

		// suppression:

		System.out.println("array contient 10 ?" + myArray.contains(10)); // true
		System.out.println("index de 10: " + myArray.indexOf(10));

		myArray.remove(new Integer(10));

		System.out.println("array contient 10 après remove ?" + myArray.contains(10));// false

		myArray.add("demo");
		myArray.add("demo");
		myArray.add("demo");

		for (Object o : myArray) {
			System.out.println(o);
		}

		System.out.println("index demo: " + myArray.indexOf("demo"));

		myArray.remove("demo");

		System.out.println("array contient demo ? " + myArray.contains("demo"));

		// Comment supprimer toutes les occurrences d'un élément dans une collection:
		// removeAll()

		System.out.println(">>>>>>>>>>> après remove:");

		ArrayList ar = new ArrayList();
		ar.add("demo");

		myArray.removeAll(ar);

		for (Object o : myArray) {
			System.out.println(o);
		}

		myArray.addAll(ar);
		System.out.println("array contient demo ? " + myArray.contains("demo"));

		System.out.println(">>>>>>>>>>>>>>>>> List:");
		/*
		 * List: collection fortement typée, ordonnée avec doublons autorisés
		 */

		List<String> myList = new ArrayList<String>(); // collection fortement typée -> contient les mm méthodes que
														// ArrayList

		myList.add("test");
		myList.add("test1");
		myList.add("test2");

		// for each
		for (String s : myList) {
			System.out.println(s);
		}

		// for
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}

		System.out.println(">>>>>>>> Set:");
		/*
		 * Set: collection fortement typée, non ordonnée sans doublons -> même
		 * focntionnement qu'une liste
		 */

		Set<Integer> entiers = new HashSet<Integer>();

		entiers.add(10);
		entiers.add(10);
		entiers.add(20);
		entiers.add(20);
		entiers.add(30);

		System.out.println("Taille du set: " + entiers.size());

		for (Integer i : entiers) {
			System.out.println(i);
		}

		// entiers.indexof(10); erreur car pas d'index dans un Set

		System.out.println(">>>>>>>>>>>>>>> Stack:");
		/*
		 * Collection ordonnée, avec doublons autorisés avec un fonctionnement LIFO:
		 * Last In First Out Elle existe en 2 types: polymorphique et fortement typée
		 */

		Stack<String> myStack = new Stack<String>();

		System.out.println("taille de la stack: " + myStack.size());

		myStack.add("test");
		myStack.add(1, "test1");
		myStack.push("test2");

		// suppression:
		myStack.pop(); // supprime le dernier par défaut

		System.out.println("stack contient test2 ?" + myStack.contains("test2")); // false

		System.out.println("Prochain élément à supprimer: " + myStack.peek()); // test1

		System.out.println(">>>>>>>>>>>> Queue:");
		/*
		 * Collection ordonnée, avec doublons autorisés avec un fonctionnement FIFO:
		 * First In First Out Elle existe en 2 types: polymorphique et formetement typée
		 */
		Queue<Integer> myQueue = new LinkedList<Integer>();
		System.out.println("Taille: " + myQueue.size());

		myQueue.add(10);
		myQueue.add(20);
		myQueue.add(30);

		myQueue.poll(); // supprime le premier par défaut

		System.out.println("Queue contient 10 ? " + myQueue.contains(10)); // false
		System.out.println("Prochain élément à supprimer: " + myQueue.peek());

		System.out.println(">>>>>>>>>>>>>>>>>>>>>< Iterator:");
		/*
		 * Iterator: permet de parcourir une collection sans tenir compte de son type,
		 * ne prend pas en compte l'index et ne prends pas en compte le type d'objets contenus
		 * dans la collection
		 */

		// ArrayList:
		System.out.println("___ArrayList iterator:");
		Iterator myIterator = myArray.iterator();

		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}

		// List
		System.out.println("___List iterator:");

		myIterator = myList.iterator();
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}

		// Set
		System.out.println("___Set iterator:");

		myIterator = entiers.iterator();
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}

		// Stack
		System.out.println("___Stack iterator:");

		myIterator = myStack.iterator();
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}

		// Queue
		System.out.println("___Queue iterator:");

		myIterator = myQueue.iterator();
		while (myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}
		
		MyMethods.parcourirCollection(myArray);
		MyMethods.parcourirCollection(myList);
		MyMethods.parcourirCollection(entiers);
		MyMethods.parcourirCollection(myStack);
		MyMethods.parcourirCollection(myQueue);
		
		System.out.println(">>>>>>>>>>>>>> Collection Map:");
		/*
		 * Map est une collection qui fonctionne par association clé:valeur
		 */
		Map<String, String> myMap = new HashMap<String, String>();
		
		System.out.println("taille de la map: "+myMap.size());
		myMap.put("server", "192.168.15.20");
		myMap.put("user", "admin");
		myMap.put("password", "@@pwd@@");
		myMap.put("password", "??pwd??"); //clé password existe: valeur écrasée -> les cés ont uniques dans une Map
		
		System.out.println(">> parcourir les valeurs:");
		
		for(String v : myMap.values()) {
			System.out.println(v);
		}
		
		System.out.println(">> Parcourir les clés:");
		
		for(String k : myMap.keySet()) {
			System.out.println("Clé: "+k+" Valeur: "+myMap.get(k));
		}
		
		if(myMap.containsKey("password")) {
			System.out.println(myMap.get("password"));
		}
		
		/*
		 * Pratique pour la gestion des paramètres de configutation
		 * Pratqiue pour classifier des objets par catégorie
		 */

	}

}
