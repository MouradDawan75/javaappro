package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Employe;
import entities.Poste;

public class EmployeRepository implements IEmployeRepository {

	@Override
	public void insert(Employe e) throws Exception {
		Connection cnx = ConnexionMySql.getConnection();
		String sql = "insert into employe(nom,prenom,poste,salaire) values(?,?,?,?)";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1, e.getNom());
		ps.setString(2, e.getPrenom());
		ps.setString(3, e.getPoste().toString());
		ps.setDouble(4, e.getSalaire());

		ps.executeUpdate();
		cnx.close();
	}

	@Override
	public void update(Employe e) throws Exception {
		Connection cnx = ConnexionMySql.getConnection();
		String sql = "update employe set nom=?,prenom=?,poste=?,salaire=? where id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setString(1, e.getNom());
		ps.setString(2, e.getPrenom());
		ps.setString(3, e.getPoste().toString());
		ps.setDouble(4, e.getSalaire());
		ps.setInt(5, e.getId());

		ps.executeUpdate();
		cnx.close();
	}

	@Override
	public void delete(int id) throws Exception {
		Connection cnx = ConnexionMySql.getConnection();
		String sql = "delete from employe where id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		cnx.close();
	}

	@Override
	public List<Employe> getAll() throws Exception {

		List<Employe> lst = new ArrayList<Employe>();
		Connection cnx = ConnexionMySql.getConnection();
		String sql = "select * from employe";
		PreparedStatement ps = cnx.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Employe e = new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
					Poste.valueOf(rs.getString("poste")), rs.getDouble("salaire"));
			lst.add(e);
		}

		rs.close();
		cnx.close();

		return lst;
	}

	@Override
	public Employe getById(int id) throws Exception {

		Employe e = null;
		Connection cnx = ConnexionMySql.getConnection();
		String sql = "select * from employe where id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			e = new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
					Poste.valueOf(rs.getString("poste")), rs.getDouble("salaire"));

		}

		rs.close();
		cnx.close();

		return e;
	}

}
