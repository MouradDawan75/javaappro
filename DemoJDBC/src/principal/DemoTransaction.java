package principal;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

import repositories.ConnexionMySql;

public class DemoTransaction {
	
	public static void main(String[] args) throws Exception {
		/*
		 * Par défaut, dans le connecteur JDBC, le mode transactionnel est désactivé
		 */
		Connection cnx = ConnexionMySql.getConnection();
		
		cnx.setAutoCommit(false); //activer le mode transactionnel -> faire des commites explicites
		
		/*
		 * Statement: permet d'exécuter des commandes SQL non paramétrées -> mauvaise pratique
		 * PreparedStatement: permet d'exécuter des commandes sql paramétrées -> c'est protection contre les injections SQL
		 */
		
		String cmd1 = "insert into produit(description,prix) values ('tv samsung', 2999)";
		String cmd2 = "insert into produit(description,prix) values ('iphone 15', 899)";
		
		/*
		 * Si commande sql paramétrée: PreparedStatement
		 * Sinon: utiliser statement ou PreparedStatement
		 */
		Statement stm = cnx.createStatement();
		
		/*
		 * Possibilité de faire une sauvegarde, si besoin.
		 */
		
		Savepoint mySavePoint = cnx.setSavepoint("savePoint1");
		
		try {
			
			/*
			 * 2 options possibles
			 */
			//Option1: exécuter les commandes SQL séparemment
			stm.executeUpdate(cmd1);
			stm.executeUpdate(cmd2);
			
			//Option2: insérer les les commandes SQL dans un batch -> exécuter le bacth
			/*
			stm.addBatch(cmd1);
			stm.addBatch(cmd2);
			
			stm.executeBatch();*/
			
			cnx.commit(); //valider toutes commandes SQL - applique les modifs en BD
			
		} catch (Exception e) {
			
			cnx.rollback(mySavePoint); //annuler toutes commandes SQL + possibilité de restaurer le point de sauvegarde
		}finally {
			cnx.close();
		}
		
	}

}
