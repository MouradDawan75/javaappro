package abstraction;

public class Homme extends Humain{
	
	public Homme(String nom, String prenom) {
		super(nom,prenom);
	}
	
	public Homme() {
		
	}

	@Override
	public void identite() {
		System.out.println("Homme......");
		
	}
	

}
