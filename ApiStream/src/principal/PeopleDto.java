package principal;

public class PeopleDto {
	
	private String nom;
	private int age;
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
	public PeopleDto(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}
	public PeopleDto() {
		super();
	}
	@Override
	public String toString() {
		return "PeopleDto [nom=" + nom + ", age=" + age + "]";
	}
	
	

}
