package principal;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		/*
		 * Sérialisation: mécanisme permettant de sauvegarder l'état d'un objet dans un support physique de
		 * persistance.
		 * 3 types de sérialisations:
		 * binaire: ObjectInputStream - ObjectOutputstreal
		 * xml: XMLEncoder - XMLDecoder
		 * json: pas de classe fournie par l'api se (solution: utiliser une bibliothèque externe (gson))
		 * 
		 * 
		 */
		
		List<Produit> lst = new ArrayList<Produit>();
		lst.add(new Produit(1, "PC Dell", 1599));
		lst.add(new Produit(2, "Ecran", 79));
		
		System.out.println(">>>>>>>>>>>>>>> Binaire:");
		
		SerialService.exportBin("produits.bin", lst);
		
		for(Produit p : SerialService.importBin("produits.bin")){
			System.out.println(p);
		}
		
		System.out.println(">>>>>>>>> XML:");
		SerialService.exportXml("produits.xml", lst);
		
		for(Produit p :  SerialService.importXml("produits.xml")) {
			System.out.println(p);
		}
		
		System.out.println(">>>>>>>> JSON:");
		SerialService.exportJson("produits.json", lst);
		
		for(Produit p : SerialService.importJson("produits.json")) {
			System.out.println(p);
		}

	}

}
