package tp;

public class Technicien extends Employe{
	
	
	private double unites;
	private static double FACTEUR_UNITE = 5;
	
	public Technicien(String nom, String prenom, int age, String dateEntree, double unites) {
		super(nom, prenom, age, dateEntree);
		this.unites = unites;
	}

	@Override
	public double calculerSalaire() {
		return unites * Technicien.FACTEUR_UNITE;
	}
	
	@Override
	public String getTitre() {
		return "Le technicien ";
	}
	

}
