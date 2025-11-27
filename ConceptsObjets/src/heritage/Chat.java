package heritage;

public class Chat extends Animal{
	/*
	 * nom et age sont définis dans la classe Animal -> c'est elle qui doit les initialiser
	 *
	 */
	
	private String couleur;
	
	
	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Chat(String nom, int age, String couleur) {
		//super: fait réference à la classe mère
		super(nom,age);
		this.couleur = couleur;
	}
	
	public Chat() {
		
	}
	
	public void dormir() {
		System.out.println("Chat: dormir.......");
	}

	//Redéfinir une méthode définie dans la classe supérieure
	@Override
	public void emettreSon() {
		
		System.out.println("Miauller............");
	}
	
	

}
