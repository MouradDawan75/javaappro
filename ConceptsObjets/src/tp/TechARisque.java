package tp;

public class TechARisque extends Technicien implements IPrime{
	

	public TechARisque(String nom, String prenom, int age, String dateEntree, double unites) {
		super(nom, prenom, age, dateEntree, unites);
		
	}
	
	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}

}
