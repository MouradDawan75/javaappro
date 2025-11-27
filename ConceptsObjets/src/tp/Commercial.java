package tp;

public abstract class Commercial extends Employe{
	
	private double chiffreAffaire;
	
	
	
	public double getChiffreAffaire() {
		return chiffreAffaire;
	}



	public Commercial(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
		super(nom, prenom, age, dateEntree);
		this.chiffreAffaire = chiffreAffaire;
	}

}
