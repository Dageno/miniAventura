package miniAventura.backEnd.clases;

import java.io.Serializable;

import miniAventura.backEnd.enums.Crystal;
import miniAventura.backEnd.excepciones.NoDescriptionValidException;
import miniAventura.backEnd.excepciones.NoNameValidException;

public class KeyObject extends PrincipalObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Crystal crystal;
	
	public KeyObject(String name, String description, Crystal crystal) throws NoNameValidException, NoDescriptionValidException{
		super(name, description);
		setCrystal(crystal);
		
		
	}

	public KeyObject(String text) throws NoNameValidException {
		super(text);
	}

	public Crystal getCrystal() {
		return crystal;
	}

	public void setCrystal(Crystal crystal) {
		this.crystal = crystal;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+" "+ super.toString()+" crystal=" + crystal + "]";
	}
	
	
}
