package miniAventura.frontEnd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import miniAventura.backEnd.clases.Drop;
import miniAventura.backEnd.clases.KeyObject;
import miniAventura.backEnd.clases.Potion;
import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.excepciones.ItemNoExistsException;

public class MostrarInventario extends MostrarBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarInventario dialog = new MostrarInventario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		siguienteObject();
		atras.setEnabled(false);
		
		
		borrar.setBounds(337, 66, 113, 23);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(object instanceof Weapon)
						Drop.inventario.removeWeapon(object.getName());
					else if (object instanceof Potion)
						Drop.inventario.removePotion(object.getName());
					else if(object instanceof KeyObject)
						Drop.inventario.removeKeyObject(object.getName());
					
					comprobarBase();
				} catch (ItemNoExistsException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
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
