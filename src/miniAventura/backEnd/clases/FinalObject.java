package miniAventura.backEnd.clases;

import miniAventura.backEnd.enums.Crystal;
import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoNameValidException;
/**
 * Clase del objeto final del juego
 * @author d16genod
 *
 */
public class FinalObject extends KeyObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinalObject() throws NoNameValidException, NoDescriptionValidException {
		super("Yellow Crystal of Salvation", "A powerfull crystal that can tear\n apart any nearly evil thing", Crystal.YELLOW);
	}

	public FinalObject(String string) throws NoNameValidException {
		super(string);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}
