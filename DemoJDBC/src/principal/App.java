package principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.MysqlDataSource;

import entities.Produit;
import repositories.IProduitRepository;
import repositories.ProduitRepository;
/*
 * Importer les membres static d'une classe: méthodes static, variables static
 */
import static principal.MyMethods.methodeClasse; 
import static principal.MyMethods.PRIME;

public class App {
	
	static int x;
	
	//bloc d'initialisation static - exécuté avant le constructeur
	static {
		x = 10;
	}
	
	boolean b = false;

	//une méthode static ne peut utiliser que des variables static définies en dehors de la méthode
	public static void main(String[] args) throws Exception {
		
		//System.out.println(b);
		
		methodeClasse();
		double prm = PRIME;
		
		/*
		 * Une appli. java utilise le driver JDBC pour interagir avec une base de données 
		 * à récupérer via maven repository
		 */
		//String driver="com.mysql.cj.jdbc.Driver"; non nécessaire pour java > 1.7
		//String url="jdbc:mysql://localhost:3306/formationjava";
		//String user = "root";
		//String password = "";
		
		//Bonne pratique: extraire les params de connexion un fichier de configuration (conf.properties)
		/*
		Properties prop = new Properties(); //classe permettant de manipuler les fichiers .properties
		
		FileInputStream fis = new FileInputStream("conf.properties");
		prop.load(fis);
		
		//Class.forName(driver); non nécessaire pour java > 1.7
		Connection cnx = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
		
		//Possibilité d'utiliser la classe DataSource pour se connecter: classe fournie par tous les drivers JDBC
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl(prop.getProperty("url"));
		dataSource.setUser(prop.getProperty("user"));
		dataSource.setPassword(prop.getProperty("password"));
		Connection connection = dataSource.getConnection();
		*/
		/*
		ProduitRepository repo = new ProduitRepository();
		repo.insert(new Produit(0, "PC Dell", 1299));
		System.out.println("Produit inséré.........");
		*/
		
		IProduitRepository repo = new ProduitRepository();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			System.out.println("""
					1- Affichier tous les produits
					2- Ajouter un produit
					3- MAJ un produit
					4- Supprimer
					5- Rechercher un produit par son id
					6- Quitter
					""");
			
			int choix = Integer.parseInt( br.readLine());
			if(choix == 6) {
				System.out.println("Fin du programme.....");
				break;
			}
			
			
			switch(choix) {
			case 1:
				
				List<Produit> all = repo.getAll();
				if(all.size() == 0) {
					System.out.println("Aucun produit trouvé....");
				}else {
					System.out.println(all.size()+" produits trouvées.");
					all.forEach(p -> System.out.println(p));
				}
				
				break;
				
			case 2:
				System.out.println("Description: ");
				String description = br.readLine();
				System.out.println("Prix:");
				double prix = Double.parseDouble( br.readLine());
				
				Produit p = new Produit(0, description, prix);
				repo.insert(p);
				System.out.println("produit inséré....");
				
				break;
				
			case 3:
				System.out.println("Id:");
				int id = Integer.parseInt(br.readLine());
				
				if(repo.getById(id) == null) {
					System.out.println("Produit introuvable....");
				}else {
					System.out.println("Description: ");
					String descr = br.readLine();
					System.out.println("Prix:");
					double price = Double.parseDouble(br.readLine());
					
					Produit pr = new Produit(id, descr, price);
					repo.update(pr);
					System.out.println("Produit MAJ..........");
				}
				
				
				break;
				
			case 4:
				
				System.out.println("Id:");
				int id1 = Integer.parseInt(br.readLine());
				
				if(repo.getById(id1) == null) {
					System.out.println("Produit introuvable....");
				}else {
					
					repo.delete(id1);
					System.out.println("Produit supprimé..........");
				}
				
				break;
				
			case 5:
				System.out.println("Id:");
				int id2 = Integer.parseInt(br.readLine());;
				Produit pTrouve = repo.getById(id2);
				if(pTrouve == null) {
					System.out.println("Produit introuvable....");
				}else {
					System.out.println("Produit trouvé:");
					System.out.println(pTrouve);
				}
				
				break;
				
				default:
					System.out.println("choix invalide......");
					break;
			
			}
			
		}

	}

}
