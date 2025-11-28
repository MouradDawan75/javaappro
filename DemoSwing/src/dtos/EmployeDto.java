package dtos;

/*
 * DTO: Data Transfert Object -> objets métiers
 */
public class EmployeDto {
	
	private int id;
	private String nom;
	private String prenom;
	private double salaire;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public EmployeDto(int id, String nom, String prenom, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	public EmployeDto() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeDto [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + "]";
	}
	
	
	
	

}
