package encapsulation;

public class Rectangle {
	
	private double hauteur;
	private double largeur;
	
	public double getHauteur() {
		return hauteur;
	}



	public void setHauteur(double hauteur) {
		if(hauteur < 0) {
			System.out.println("Hauteur doit être positive");
		}
		this.hauteur = hauteur;
	}



	public double getLargeur() {
		return largeur;
	}



	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}



	public double surface() {
		return hauteur * largeur;
	}



	public Rectangle(double hauteur, double largeur) {
		setHauteur(hauteur);
		//setLargeur(largeur);
		this.largeur = largeur; //pas de contrôle dans le setter de largeur
	}


	public Rectangle() {

	}
	
	

}
