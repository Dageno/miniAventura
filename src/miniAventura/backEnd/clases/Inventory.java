package miniAventura.backEnd.clases;

import java.util.ArrayList;
import miniAventura.backEnd.excepciones.ItemExistsException;

public class Inventory extends Drop {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<PrincipalObject> allObjects = new ArrayList<PrincipalObject>();
	

	private static final String TOTAL_OBJECTS_OF_GAME = "Your own bag";

	public void addObject(PrincipalObject objectToAdd) throws ItemExistsException {

		if (!allObjects.contains(objectToAdd) && allObjects.size()<10)
			allObjects.add(objectToAdd);
		else
			throw new ItemExistsException("Este objeto ya está introducido en el inventario. ");
	}
	

	@Override
	public String toString() {
		return TOTAL_OBJECTS_OF_GAME + " list: [" + allObjects + "]\n";

	}
	



}
