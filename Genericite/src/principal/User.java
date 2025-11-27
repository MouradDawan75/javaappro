package principal;

import java.io.Serializable;

public class User implements Serializable{

	private int id;
	private String nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public User(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + "]";
	}

}
