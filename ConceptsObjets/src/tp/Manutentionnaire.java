package tp;

public class Manutentionnaire extends Employe{
	
	
	private double heures;
	private static double TAUX_HORAIRE = 65;
	
	public Manutentionnaire(String nom, String prenom, int age, String dateEntree, double heures) {
		super(nom, prenom, age, dateEntree);
		this.heures = heures;
	}

	@Override
	public double calculerSalaire() {
		return heures * Manutentionnaire.TAUX_HORAIRE;
	}
	
	@Override
	public String getTitre() {
		return "Le manutentionnaire ";
	}

}
