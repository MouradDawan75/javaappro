package principal;

import java.io.File;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		/*
		 * l'API Java SE propose un certain nombre de classes permettant de manipuler des fichiers.
		 * Stream(flux): est une sorte de canal intermédiaire entre une source et une destination
		 * 2 types de Stream:
		 * flux binaire: lecture/écriture char par char -> FileInputStream - FileOutputStream
		 * flux caractère: lecture/écriture ligne par ligne -> FileReader (BufferedReader) - Filewriter (BufferedWriter)
		 * 
		 * Plus la classe Principale: File (permettant de manipuler des fichiers et des dossiers)
		 * 
		 * 
		 */
		
		//création d'un fichier:
		File fichier = new File("demon.txt"); //chemin relatif
		
		String homeDir = System.getProperty("home.dir");
		File f = new File(homeDir, "demo.txt");
		//f.createNewFile();
		
		try {
			fichier.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File fichier2 = new File("c:\\rep\\demo.txt"); //chemin absolut
		try {
			fichier2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//création d'un dossier
		File monRep = new File("rep\\rep1");
		monRep.mkdirs();
		
		try {
			FileService.scanRep("c:\\rep");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String contenu = FileService.lectureFichier("myfile.txt");
			System.out.println(contenu);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			FileService.ecritureFichier("writer.txt", "new content......", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			FileService.copieFichier("myfile.txt", "copie.txt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
 
	}
	
	//root/Desktop/demo.txt

}
