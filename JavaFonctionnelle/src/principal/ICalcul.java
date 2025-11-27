package principal;

@FunctionalInterface
public interface ICalcul {
	
	int add(int a, int b);
	
	default void m1() {}; //implèmentation par défaut que les classes filles peuvent redéfinir 
	static void m2() {}; //une interface peut contenir des méthodes static

}
