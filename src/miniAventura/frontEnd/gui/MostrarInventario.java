package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import miniAventura.backEnd.clases.KeyObject;
import miniAventura.backEnd.clases.Potion;
import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.excepciones.ItemExistsException;
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
		
		
		rank = inventario.allObjects.listIterator();
		object = inventario.get(0);
		
		/**
		 * Limpiamos la ventana
		 */
		allInvisible();
		allDisable();
		
		/**
		 * Añadimos el primer elemento
		 */
		mostrarDatabase(object);
		
		/**
		 * Actualizamos los botones
		 */
		actualizarBoton(atras, adelante);
		
		borrar.setBounds(337, 66, 113, 23);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(object instanceof Weapon)
						inventario.removeWeapon(object.getName());
					else if (object instanceof Potion)
						inventario.removePotion(object.getName());
					else if(object instanceof KeyObject)
						inventario.removeKeyObject(object.getName());
					
					comprobarBase();
				} catch (ItemNoExistsException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private void comprobarBase() {
				if(inventario.isEmpty()){
					JOptionPane.showMessageDialog(contentPanel, "El inventario está vacío", "Error",
							JOptionPane.ERROR_MESSAGE);
					dispose();
				}else{
					try {
						rank = inventario.allObjects.listIterator();
						object = inventario.get(0);
						mostrarDatabase(object);
						actualizarBoton(atras, adelante);
					} catch (Exception  e) {
						
					}
				}
				
			}

		});
		
		
		
	}

}
