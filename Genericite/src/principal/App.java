package principal;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		/*
		 * La généricité permet de d'exprimer des méthodes, des classes ou interfaces identiques sur le plan algorithmique
		 * mais différents sur la base des types
		 */
		
		Calcul<Integer> c1 = new Calcul<Integer>();
		c1.a = 10;
		c1.b = 15;
		
		
		Calcul<String> c2 = new Calcul<String>();
		c2.a = "a";
		c2.b = "b";
		
		List<User> users = new ArrayList<User>();
		users.add(new User(1, "DUPONT"));
		users.add(new User(2, "MELLO"));
		
		SerialServiceGeneric.exportBin("users.bin", users);
		
		SerialServiceGeneric.importBin("users.bin").forEach(u -> System.out.println(u));

	}

}
