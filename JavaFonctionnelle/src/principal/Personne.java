package principal;

public class Personne {
	
	private String nom;
	private Genre genre;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Personne(String nom, Genre genre) {
		super();
		this.nom = nom;
		this.genre = genre;
	}
	public Personne() {
		super();
	}
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", genre=" + genre + "]";
	}
	
	

}
