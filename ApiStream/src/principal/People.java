package principal;

public class People {

	private String nom;
	private int age;
	private Genre genre;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public People(String nom, int age, Genre genre) {
		super();
		this.nom = nom;
		this.age = age;
		this.genre = genre;
	}
	public People() {
		super();
	}
	@Override
	public String toString() {
		return "People [nom=" + nom + ", age=" + age + ", genre=" + genre + "]";
	}
	
	
}
