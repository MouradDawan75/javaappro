package principal;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class SerialService {
	
	//sérialisation binaire
	
	public static void exportBin(String chemin, List<Produit> lst) {
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
	public static List<Produit> importBin(String chemin){
		List<Produit> lst = new ArrayList<Produit>();
		try {
		FileInputStream fis = new FileInputStream(chemin);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		lst = (List<Produit>) ois.readObject();
		
		ois.close();
		fis.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return lst;
	}
	
	//sérialisation xml
	
	public static void exportXml(String chemin, List<Produit> lst) {
		try {
			
			FileOutputStream fos = new FileOutputStream(chemin);
			XMLEncoder xml = new XMLEncoder(fos);
			xml.writeObject(lst);
			xml.close();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//désérialisation xml
	public static List<Produit> importXml(String chemin){
		List<Produit> lst = new ArrayList<Produit>();
		try {
		FileInputStream fis = new FileInputStream(chemin);
		XMLDecoder ois = new XMLDecoder(fis);
		
		lst = (List<Produit>) ois.readObject();
		
		ois.close();
		fis.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return lst;
	}
	
	//sérialisation JSON
	public static void exportJson(String chemin, List<Produit> lst) {
		try {
			
			FileWriter fw = new FileWriter(chemin);
			
			Gson gson = new Gson();
			gson.toJson(lst, fw);
			
			fw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//désérialisation JSON
	public static List<Produit> importJson(String chemin){
		try {
			
			Gson gson = new Gson();
			FileReader fr = new FileReader(chemin);
			
			Produit[] tab = gson.fromJson(fr, Produit[].class);;
			
			return Arrays.asList(tab);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
