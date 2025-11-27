package repositories;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnexionMySql {
	
	public static Connection getConnection() throws Exception{
	Properties prop = new Properties(); //classe permettant de manipuler les fichiers .properties
		
		FileInputStream fis = new FileInputStream("conf.properties");
		prop.load(fis);
		
		//Class.forName(driver); non nécessaire pour java > 1.7
		Connection cnx = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
		
		return cnx;
	}

}
