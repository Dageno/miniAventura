package miniAventura.backEnd.clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import miniAventura.backEnd.excepciones.ItemExistsException;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.excepciones.NoNameValidException;

public class Inventory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<PrincipalObject> allObjects = new ArrayList<PrincipalObject>();
	

	private static final String TOTAL_OBJECTS_OF_GAME = "DataBase of World Objects";

	public void addObject(PrincipalObject objectToAdd) throws ItemExistsException {

		if (!allObjects.contains(objectToAdd))
			allObjects.add(objectToAdd);
		else
			throw new ItemExistsException("Este objeto ya está introducido en el inventario. ");
	}
	
	public void removeObject(PrincipalObject objeto) throws ItemNoExistsException {

		if(objeto instanceof Weapon)
			removeWeapon(objeto.getName());
		else if (objeto instanceof Potion)
			removePotion(objeto.getName());
		else if(objeto instanceof KeyObject)
			removeKeyObject(objeto.getName());
	}

	public void removeWeapon(String name) throws ItemNoExistsException {

		try {
			if (!allObjects.remove(new Weapon(name)))
				throw new ItemNoExistsException("Error al borrar. Este objeto no está incluido en el juego. ");
		} catch (NoNameValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void removePotion(String name) throws ItemNoExistsException {
		try {
			if (!allObjects.remove(new Potion(name)))
				throw new ItemNoExistsException("Error al borrar. Este objeto no está incluido en el juego. ");
		} catch (NoNameValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

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

	public Weapon getWeapon(String string) throws ItemNoExistsException {

		try {
			return (Weapon) allObjects.get(allObjects.indexOf(new Weapon(string)));
		} catch (ArrayIndexOutOfBoundsException | NoNameValidException e) {
			throw new ItemNoExistsException("Error al buscar. Este objeto no está incluido en el juego. ");
		}

	}
	public Potion getPotion(String string) throws ItemNoExistsException {

		try {
			return (Potion) allObjects.get(allObjects.indexOf(new Potion(string)));
		} catch (ArrayIndexOutOfBoundsException | NoNameValidException e) {
			throw new ItemNoExistsException("Error al buscar. Este objeto no está incluido en el juego. ");
		}

	}
	
	public KeyObject getKeyObject(String text) throws ItemNoExistsException {
		try {
			return (KeyObject) allObjects.get(allObjects.indexOf(new KeyObject(text)));
		} catch (ArrayIndexOutOfBoundsException | NoNameValidException e) {
			throw new ItemNoExistsException("Error al buscar. Este objeto no está incluido en el juego. ");
		}
	}

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

	public void clearDrop() {
		allObjects.clear();
		
	}

	@Override
	public String toString() {
		return "Inventory list:  " + TOTAL_OBJECTS_OF_GAME + "[" + allObjects + "]\n";

	}
	



}
