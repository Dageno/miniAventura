package miniAventura.backEnd.clases;

import java.io.Serializable;

import miniAventura.backEnd.enums.Crystal;
import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoNameValidException;

public class FinalObject extends KeyObject implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FinalObject() throws NoNameValidException, NoDescriptionValidException {
		super("The Yellow Crystal of Salvation", "A powerfull crystal that can tear apart any nearly evil thing", Crystal.YELLOW);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}
