package miniAventura.backEnd.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import miniAventura.backEnd.excepciones.ItemExistsException;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.excepciones.NoNameValidException;
import miniAventura.backEnd.excepciones.NoObjectToShowException;
import miniAventura.backEnd.interfaces.Valorable;
/**
 * Clase que guarda todos los objetos disponibles para el juego
 * @author d16genod
 *
 */
public class Drop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<PrincipalObject> allObjects = new ArrayList<PrincipalObject>();
	public static Inventory inventario = new Inventory();
	
	

	private static final String TOTAL_OBJECTS_OF_GAME = "DataBase of World Objects";
	/**
	 * Añade objetos al arraylist
	 * @param objectToAdd
	 * @throws ItemExistsException
	 */
	public void addObject(PrincipalObject objectToAdd) throws ItemExistsException {
		
		if (!allObjects.contains(objectToAdd))
			allObjects.add(objectToAdd);
		else
			if(objectToAdd instanceof Potion)
				((Potion) objectToAdd).setQuantity(1);
			else
				throw new ItemExistsException("Este objeto ya está introducido en el juego. ");
	}
	/**
	 * Borra armas del arraylist
	 * @param name
	 * @throws ItemNoExistsException
	 */
	public void removeWeapon(String name) throws ItemNoExistsException {

		try {
			if (!allObjects.remove(new Weapon(name)))
				throw new ItemNoExistsException("Error al borrar. Este objeto no está incluido en el juego. ");
		} catch (NoNameValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Borra pociones del arrayList
	 * @param name
	 * @throws ItemNoExistsException
	 */
	public void removePotion(String name) throws ItemNoExistsException {
		try {
			if (!allObjects.remove(new Potion(name)))
				throw new ItemNoExistsException("Error al borrar. Este objeto no está incluido en el juego. ");
		} catch (NoNameValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Borra objetos clave del arrayList
	 * @param name
	 * @throws ItemNoExistsException
	 */
	public void removeKeyObject(String name) throws ItemNoExistsException {
		try {
			if (!allObjects.remove(new KeyObject(name)))
				throw new ItemNoExistsException("Error al borrar. Este objeto no está incluido en el juego. ");
		} catch (NoNameValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public int size() {
		return allObjects.size();
	}
	
	/**
	 * Obtiene un arma que pertenece al arraylist
	 * @param string
	 * @return
	 * @throws ItemNoExistsException
	 */
	public Weapon getWeapon(String string) throws ItemNoExistsException {

		try {
			return (Weapon) allObjects.get(allObjects.indexOf(new Weapon(string)));
		} catch (ArrayIndexOutOfBoundsException | NoNameValidException e) {
			throw new ItemNoExistsException("Error al buscar. Este objeto no está incluido en el juego. ");
		}

	}
	/**
	 * 
	 * Obtiene una pocion que pertenece al arraylist
	 * @param string
	 * @return
	 * @throws ItemNoExistsException
	 */
	public Potion getPotion(String string) throws ItemNoExistsException {

		try {
			return (Potion) allObjects.get(allObjects.indexOf(new Potion(string)));
		} catch (ArrayIndexOutOfBoundsException | NoNameValidException e) {
			throw new ItemNoExistsException("Error al buscar. Este objeto no está incluido en el juego. ");
		}

	}
	/**
	 * Obtiene un objeto clave que pertenece al arraylist
	 * @param text
	 * @return
	 * @throws ItemNoExistsException
	 */
	public KeyObject getKeyObject(String text) throws ItemNoExistsException {
		try {
			return (KeyObject) allObjects.get(allObjects.indexOf(new KeyObject(text)));
		} catch (ArrayIndexOutOfBoundsException | NoNameValidException e) {
			throw new ItemNoExistsException("Error al buscar. Este objeto no está incluido en el juego. ");
		}
	}
	/**
	 * Devuelve objeto padre si se encuentra en el arraylist
	 * @param index
	 * @return
	 * @throws ItemNoExistsException
	 */
	public PrincipalObject get(int index) throws ItemNoExistsException {

		try {
			return allObjects.get(index);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ItemNoExistsException("Error al buscar. Este objeto no está incluido en el juego. ");
		}

	}
	
	public void modificar(PrincipalObject modify) {

		allObjects.set(allObjects.indexOf(modify.getIdentify()), modify);

	}

	public boolean isEmpty() {

		return allObjects.isEmpty();
	}
	/**
	 * Limpia el arraylist
	 */
	public void clearDrop() {
		allObjects.clear();
		
	}

	@Override
	public String toString() {
		return "Drop list:  " + TOTAL_OBJECTS_OF_GAME + "[" + allObjects + "]\n";

	}
	/**
	 * Ranking de objetos por precio
	 * @return
	 */
	public ListIterator<Valorable> ranking(){
		ArrayList<Valorable> valorable = new ArrayList<Valorable>();
		for(PrincipalObject obj: allObjects){
			if(obj instanceof Valorable){
				valorable.add((Valorable) obj);
			}
		}
		
		Collections.sort(valorable, Collections.reverseOrder());
		
		
		return valorable.listIterator();
		
	}
	/**
	 * Divide el arraylist por clase de objeto
	 * @param objeto
	 * @return
	 * @throws NoObjectToShowException
	 */
	public ListIterator<PrincipalObject> porClase(PrincipalObject objeto) throws NoObjectToShowException{
		
		ArrayList<PrincipalObject> porClase = new ArrayList<PrincipalObject>();
		
		if(objeto instanceof Weapon){
			for(PrincipalObject obj: allObjects)
				if(obj instanceof Weapon)
					porClase.add(obj);
		}
		else if(objeto instanceof Potion){
			for(PrincipalObject obj: allObjects)
				if(obj instanceof Potion)
					porClase.add(obj);
		}else if(objeto instanceof KeyObject){
			for(PrincipalObject obj: allObjects)
				if(obj instanceof KeyObject)
					porClase.add(obj);
		}
	
		if(porClase.isEmpty())
			throw new NoObjectToShowException("No hay objetos para mostrar");
		return porClase.listIterator(0);
		
	}
	
	




	

	

	
	

}
