package tp;

public class ManutARisque extends Manutentionnaire implements IPrime{


	public ManutARisque(String nom, String prenom, int age, String dateEntree, double heures) {
		super(nom, prenom, age, dateEntree, heures);
	}
	
	@Override
	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}

}
