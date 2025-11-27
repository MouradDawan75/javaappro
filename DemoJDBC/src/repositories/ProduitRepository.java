package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Produit;

public class ProduitRepository implements IProduitRepository {
	/*
	 * CRUD: Create - Read - Update - Delete
	 */

	@Override
	public void insert(Produit p) throws Exception {

		Connection cnx = ConnexionMySql.getConnection();

		String sql = "insert into produit(description,prix) values (?,?)";

		// objet permettant d'exécuter des commandes sql
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1, p.getDescription());
		ps.setDouble(2, p.getPrix());

		ps.executeUpdate(); // renvoie un int: nbre de lignes modifiées en BD

		cnx.close();
	}

	@Override
	public void update(Produit p) throws Exception {

		Connection cnx = ConnexionMySql.getConnection();

		String sql = "update produit set description=?,prix=? where id=?";

		// objet permettant d'exécuter des commandes sql
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1, p.getDescription());
		ps.setDouble(2, p.getPrix());
		ps.setInt(3, p.getId());

		ps.executeUpdate(); // renvoie un int: nbre de lignes modifiées en BD

		cnx.close();
	}

	@Override
	public void delete(int id) throws Exception {

		Connection cnx = ConnexionMySql.getConnection();

		String sql = "delete from produit where id=?";

		// objet permettant d'exécuter des commandes sql
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);

		ps.executeUpdate(); // renvoie un int: nbre de lignes modifiées en BD

		cnx.close();
	}
	
	@Override
	public List<Produit> getAll() throws Exception{
		
		List<Produit> lst = new ArrayList<Produit>();
		Connection cnx = ConnexionMySql.getConnection();

		String sql = "select * from produit";

		// objet permettant d'exécuter des commandes sql
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Produit p = new Produit(rs.getInt("id"), rs.getString("description"), rs.getDouble("prix"));
			lst.add(p);
		}
		
		rs.close();
		cnx.close();
		
		
		return lst;
	}
	
	@Override
	public Produit getById(int id) throws Exception{
		Produit p = null;
		Connection cnx = ConnexionMySql.getConnection();

		String sql = "select * from produit where id=?";

		// objet permettant d'exécuter des commandes sql
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			p = new Produit(rs.getInt("id"), rs.getString("description"), rs.getDouble("prix"));
		}
		
		rs.close();
		cnx.close();
		
		return p;
	}

}
