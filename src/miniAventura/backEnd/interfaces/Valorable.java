package miniAventura.backEnd.interfaces;
/**
 * Interfaz que evalua el precio de cada uno de los objetos.
 * Por el cual realizamos un ranking.
 * @author d16genod
 *
 */
public interface Valorable extends Comparable<Valorable> {
	
	int calculatePrice();
	
	String getName();

}
