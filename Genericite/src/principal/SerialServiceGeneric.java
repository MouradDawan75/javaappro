package principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerialServiceGeneric {
	
	//sérialisation binaire
	
		public static <T extends Serializable> void exportBin(String chemin, List<T> lst) {
			try {
				
				FileOutputStream fos = new FileOutputStream(chemin); //permet d'écrire du texte dans un fichier
				ObjectOutputStream oos = new ObjectOutputStream(fos); //permet d'écrire des objets dans un fichier
				oos.writeObject(lst);
				oos.close();
				fos.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//désérialisation binaire
		public static <T extends Serializable> List<T> importBin(String chemin){
			List<T> lst = new ArrayList<T>();
			try {
			FileInputStream fis = new FileInputStream(chemin);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			lst = (List<T>) ois.readObject();
			
			ois.close();
			fis.close();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return lst;
		}

}
