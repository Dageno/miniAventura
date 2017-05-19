package miniAventura.backEnd.clases;

import miniAventura.backEnd.enums.Crystal;
import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoNameValidException;

public class FinalObject extends KeyObject{

	public FinalObject() throws NoNameValidException, NoDescriptionValidException {
		super("The Yellow Crystal of Salvation", "A powerfull crystal that can tear apart any nearly evil thing", Crystal.YELLOW);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	

}
