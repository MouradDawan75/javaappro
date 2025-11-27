package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileService {
	
	public static void scanRep(String chemin) throws Exception {
		File f = new File(chemin);
		if(f.exists()) {
			
			if(f.isDirectory()) {
				
				File[] files = f.listFiles();
				
				for(File file : files) {
					if(file.isFile()) {
						System.out.println("Fichier: "+file.getName());
					}else {
						System.out.println("Répertoire: "+file.getName());
						scanRep(file.getAbsolutePath());
					}
					
				}
				
			}else {
				System.out.println("Fichier: "+f.getName());
			}
			
			
		}else {
			//System.out.println("Chemin invalide....."); println: ne fonctionne qu'avec des applications consoles
			throw new Exception("chemin invalide.....");
			//f.mkdir();
		}
	}
	
	//méthode de lecture ligne/ligne
	/**
	 * Méthode qui renvoie le contenu d'un fichier texte
	 * @param chemin: chemin absolut du fichier à lire. Ex: c:\\rep\\file.txt
	 * @return: contenu du fichier
	 * @throws Exception: si fichier introuvable
	 */
	public static String lectureFichier(String chemin) throws Exception{
		
		String contenu = "";
		
		File f = new File(chemin);
		if(f.exists()) {
			
			FileReader fr = new FileReader(f);
			//Bonne pratique: Utilisation d'un buffer pour des questions de performences
			//Taille du buffer par défaut = 8192 (8 octets)
			//possibilité de modifier sa taille
			BufferedReader br = new BufferedReader(fr, 16384);
			
			String ligne = br.readLine();
			while(ligne != null) {
				contenu += ligne+"\n";
				ligne = br.readLine();
			}
			
			fr.close();
			
			return contenu;
			
		}else {
			throw new Exception("Fichier introuvable......");
		}
	}
	
	//méthode d'écriture ligne par ligne
	/**
	 * Méthode d'écriture dans un fichier texte
	 * @param chemin: chemin absolut du fichier.Ex: c:\\rep\\file.txt
	 * @param texte: contenu à insérer dans le fichier
	 * @param modeAjout: mettre à true pour ajouter dans une nouvelle ligne le texte dans le fichier
	 * @throws Exception: si chemin invalide
	 */
	public static void ecritureFichier(String chemin, String texte, boolean modeAjout) throws Exception{
		File f = new File(chemin);
		if(f.exists()) {
			
			if(modeAjout) {
				texte += "\n"+texte;
			}
			
			FileWriter fw = new FileWriter(f, modeAjout); //mode ajout
			BufferedWriter bw = new BufferedWriter(fw, 16384);
			bw.write(texte);
			
			bw.close(); //si buffer non fermé -> contenu non inséré dans le fichier
			fw.close();
			
			
		}else {
			throw new Exception("Chemin invalide......");
		}
	}
	
	//méthode de copie d'un fichier avec flux bianire: lecture/écriture char par char
	
	public static void copieFichier(String cheminSource, String cheminDestination) throws Exception{
		
		File f = new File(cheminSource);
		if(f.exists()) {
			
			FileInputStream fis = new FileInputStream(f);
			FileOutputStream fos = new FileOutputStream(cheminDestination); //si fichier inexistant -> il sera crée par FileOutputStream
			
			int tmp = fis.read(); //renvoie le code ascii du char lu
			while(tmp != -1) {
				fos.write(tmp);
				System.out.println(tmp+"("+(char)tmp+")");
				tmp = fis.read();
			}
			
			fis.close();
			fos.close();
			
		}else {
			throw new Exception("Fichier introuvable.........");
		}
	}

}
