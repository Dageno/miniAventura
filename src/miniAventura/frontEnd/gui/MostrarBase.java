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
import miniAventura.backEnd.clases.PrincipalObject;
import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.excepciones.ItemExistsException;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.excepciones.NoNameValidException;

public class MostrarBase extends Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JButton annadir = new JButton("Añadir");
	protected JButton borrar = new JButton("Eliminar");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarBase dialog = new MostrarBase();
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
	public MostrarBase() throws ItemNoExistsException {
		setTitle("Mostrando Base de datos completa");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		medidas();
		contentPanel.setBorder(backGroundImage());
		System.out.println(dataBase);
		/**
		 * labels
		 */
		contentPanel.add(lblNombre);
		contentPanel.add(lblTipoDeArma);
		contentPanel.add(lblDescripcinDelObjeto);
		contentPanel.add(lblTipoDeContenedor);
		contentPanel.add(lblTipoDeContenedor);
		contentPanel.add(lblTipoDePocion);
		contentPanel.add(lblTipoDeCristal);
		contentPanel.add(lblesteObjetoEs);
		contentPanel.add(lblPrecioDelObjeto);
		
		/**
		 * Jtextfield and text area
		 */
		contentPanel.add(name);
		contentPanel.add(description);
		contentPanel.add(precio);
		
		/**
		 * JComboBox
		 */
		contentPanel.add(classWeapon);
		contentPanel.add(classObject);
		classObject.setVisible(false);
		contentPanel.add(potionType);
		contentPanel.add(potionContainer);
		contentPanel.add(crystal);
		
		
		/**
		 * Jbuttons and panel
		 */
		annadir.setVisible(false);
		borrar.setVisible(false);
		contentPanel.add(panel);
		
		rank = dataBase.allObjects.listIterator();
		object = dataBase.get(0);
		
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
		
		
		/**
		 * Retrocede en el iterador
		 */
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					object = rank.previous();
					mostrarDatabase(object);
					actualizarBoton(atras, adelante);
			
		}});
		atras.setBounds(437, 337, 89, 23);
		contentPanel.add(atras);
		
		/**
		 * Avanza en el iterador
		 */
		adelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					object = rank.next();
					mostrarDatabase(object);
					actualizarBoton(atras, adelante);
				
			}
		});
		
		
		/**
		 * Boton clase hija añadirInventario
		 */
		annadir.setBounds(337, 66, 113, 23);
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inventario.addObject(object);
				} catch (ItemExistsException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}

		});
		contentPanel.add(annadir);
		contentPanel.add(borrar);
		adelante.setBounds(536, 337, 89, 23);
		contentPanel.add(adelante);
		panel.add(wood);
		panel.add(iron);
		panel.add(steel);
	
		
		
		
		
	}

	


}


