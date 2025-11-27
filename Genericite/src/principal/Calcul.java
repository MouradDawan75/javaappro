package principal;

/*
 * Possibilité d'ajouter des contraintes sur le type T : Calcul<T extends Product> -> uniquement les classes filles de Product
 * 														 Calcul<T super Product> -> uniquement les classes supérieures à Product
 * 														 Calcul<T extends IProduct> -> uniquement les classes qui impémentent l'interface IProduct
 * 														Calcul<T extends User & IProduit > classe fille de user qui implèmente IProduit (classe en premier)
 * 
 */

public class Calcul<T> {

	public T a;
	public T b;
	
	public void swap() {
		T tmp = a;
		a = b;
		b = tmp;
	}
}
