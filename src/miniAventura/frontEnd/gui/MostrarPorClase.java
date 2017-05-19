package miniAventura.frontEnd.gui;

import javax.swing.JDialog;
import javax.swing.JPanel;

import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.excepciones.NoNameValidException;
import miniAventura.backEnd.excepciones.NoObjectToShowException;

public class MostrarPorClase extends MostrarBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final JPanel contentPanel = new JPanel();
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarPorClase dialog = new MostrarPorClase();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @throws ItemNoExistsException
	 */
	public MostrarPorClase() throws ItemNoExistsException {
	
		
		
		
		cajaPorClase.setVisible(true);
		lblPrecioDelObjeto.setVisible(false);
		precio.setVisible(false);
		lblSeleccionarObjeto.setVisible(true);
		atras.setVisible(false);
		adelante.setVisible(false);
		btnAtras.setVisible(true);
		btnAdelante.setVisible(true);
		try {
			iteratorClase = dataBase.porClase(new Weapon("Aux"));
			object = iteratorClase.next();
			if(iteratorClase.hasNext())
				btnAdelante.setEnabled(true);
			else
				btnAdelante.setEnabled(false);
			mostrarDatabase(object);
			
			btnAtras.setEnabled(false);
		} catch (NoObjectToShowException | NoNameValidException e1) {
			allInvisible();
		}
	
		

	}


	
	
	
	
}
