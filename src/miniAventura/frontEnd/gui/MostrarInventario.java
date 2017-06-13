package miniAventura.frontEnd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import miniAventura.backEnd.clases.Drop;
import miniAventura.backEnd.clases.KeyObject;
import miniAventura.backEnd.clases.Potion;
import miniAventura.backEnd.clases.PrincipalObject;
import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.excepciones.NoNameValidException;

public class MostrarInventario extends MostrarBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 * @throws ItemNoExistsException 
	 */
	public MostrarInventario() throws ItemNoExistsException {
		super();
		setTitle("Mostrando Inventario");
		medidas();
		
		
		rank = Drop.inventario.allObjects.listIterator();
		
		
		/**
		 * Limpiamos la ventana
		 */
		allInvisible();
		allDisable();
		
		/**
		 * Añadimos el primer elemento
		 */
		mostrarDatabase(rank.next());
		atras.setEnabled(false);
		
		
		borrar.setBounds(365, 66, 113, 23);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Drop.inventario.remove(object);
				
				comprobarBase();
			}

			private void comprobarBase() {
				if(Drop.inventario.isEmpty()){
					JOptionPane.showMessageDialog(contentPanel, "El inventario está vacío", "Error",
							JOptionPane.ERROR_MESSAGE);
					dispose();
				}else{
					try {
						rank = Drop.inventario.allObjects.listIterator();
						siguienteObject();
					} catch (Exception  e) {
						
					}
				}
				
			}

		});
		
		
		
	}

}
