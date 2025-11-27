package exceptions;
/*
 * Pour définir ses propres exception:
 * 1- Hériter de la classe Exception
 * 2- Appeler le constructeur de la classe mère et lui fournir un message en paramètres 
 */

public class CalculException extends Exception{

	public CalculException(String msg) {
		super(msg);
	}
}
