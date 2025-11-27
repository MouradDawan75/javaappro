package interfaces;

public interface Vehicule {
	
	/*
	 * Interface: c'est pseudo classe abstraite qui ne contient que des méthodes abstraites
	 */
	
	void accelerer();
	void decelerer();
	
	//une interface peut contenir aussi des variables constantes
	final int x = 10;

}
