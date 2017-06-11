package miniAventura.frontEnd.gui;

import javax.swing.JPanel;
import miniAventura.backEnd.excepciones.ItemNoExistsException;

public class BorrarInventario extends MostrarInventario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 * @throws ItemNoExistsException 
	 */
	public BorrarInventario() throws ItemNoExistsException {
		super();
		setTitle("Borrando del inventario");
		borrar.setVisible(true);
		annadir.setVisible(false);
		
		
	
		
	}

}
