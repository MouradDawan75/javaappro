package principal;

import java.util.Collection;
import java.util.Iterator;

public class MyMethods {
	
	public static void parcourirCollection(Collection collection) {
		//Collection est la classe supérieure à toutes les collections
		Iterator myIterator = collection.iterator();
		while(myIterator.hasNext()) {
			System.out.println(myIterator.next());
		}
	}

}
