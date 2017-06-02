package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ListIterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import miniAventura.backEnd.clases.Drop;
import miniAventura.backEnd.clases.FinalObject;
import miniAventura.backEnd.clases.KeyObject;
import miniAventura.backEnd.clases.Potion;
import miniAventura.backEnd.clases.PrincipalObject;
import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.enums.Classes;
import miniAventura.backEnd.excepciones.ItemExistsException;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.excepciones.NoNameValidException;
import miniAventura.backEnd.excepciones.NoObjectToShowException;
import miniAventura.backEnd.interfaces.Valorable;

public class MostrarBase extends Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	protected Valorable objeto;
	
	/**
	 * Botones de inventario
	 */
	JButton annadir = new JButton("Añadir");
	protected JButton borrar = new JButton("Eliminar");
	
	/**
	 * JComboBox de tipos de objeto.
	 */
	JComboBox<String> cajaPorClase = new JComboBox<String>();
	
	/**
	 * Iterador PorClase
	 */
	ListIterator<PrincipalObject> iteratorClase;
	
	/**
	 * Botones de MostrarPorClase
	 */
	JButton btnAtras = new JButton("<<");
	JButton btnAdelante = new JButton(">>");
	
	/**
	 * Botones para el Ranking
	 */
	JButton btnAtrasRanking = new JButton("<<");
	JButton btnAdelanteRanking = new JButton(">>");

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
	 * 
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
		contentPanel.add(lblSeleccionarObjeto);
		lblSeleccionarObjeto.setVisible(false);

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
		cajaPorClase.setVisible(false);
		contentPanel.add(cajaPorClase);
		cajaPorClase.setBounds(306, 17, 122, 20);

		/**
		 * Jbuttons and panel
		 */
		annadir.setVisible(false);
		borrar.setVisible(false);
		btnAdelante.setVisible(false);
		btnAtras.setVisible(false);
		contentPanel.add(panel);
		contentPanel.add(annadir);
		contentPanel.add(borrar);
		panel.add(wood);
		panel.add(iron);
		panel.add(steel);

		rank = dataBase.allObjects.listIterator();

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

		///// BOTONES DE ITERADORES /////

		/**
		 * Retrocede en el iterador RANK
		 */
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				anteriorObject();

			}
		});
		atras.setBounds(437, 337, 89, 23);
		contentPanel.add(atras);

		/**
		 * Retrocede en el iterador ITERAPORCLASE
		 */
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				anteriorObjectPorClase();

			}
		});
		btnAtras.setBounds(437, 337, 89, 23);
		contentPanel.add(btnAtras);

		/**
		 * Avanza en el iterador RANK
		 */
		adelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				siguienteObject();

			}
		});
		adelante.setBounds(536, 337, 89, 23);
		contentPanel.add(adelante);

		/**
		 * Avanza en el iterador iteraPorClase
		 */
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				siguienteObjectPorClase();

			}
		});
		btnAdelante.setBounds(536, 337, 89, 23);
		contentPanel.add(btnAdelante);
		
		
		/**
		 * Retrocede en el iterador RANKITERATOR
		 */
		btnAtrasRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				anteriorObjetoRanking();
			
		}});
		btnAtrasRanking.setBounds(437, 337, 89, 23);
		contentPanel.add(btnAtrasRanking);
		
		/**
		 * Avanza en el iterador
		 */
		btnAdelanteRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				siguienteObjetoRanking();
				
			}
		});
		btnAdelanteRanking.setBounds(536, 337, 89, 23);
		contentPanel.add(btnAdelanteRanking);
		
		
		
		
	

	


		////////////////////////////////////

		/**
		 * Boton clase hija añadirInventario
		 */
		annadir.setBounds(337, 66, 113, 23);
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Drop.inventario.addObject(object);
				} catch (ItemExistsException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		
		
		/**
		 * JComboBox que cambia la vista de los iteradores POR CLASE
		 */
		cajaPorClase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {

					switch (cajaPorClase.getSelectedItem().toString()) {

					case "Armas":

						iteratorClase = dataBase.porClase(new Weapon("Aux"));
						break;
					case "Pociones":
						iteratorClase = dataBase.porClase(new Potion("Aux"));
						break;
					case "Objetos Clave":
						iteratorClase = dataBase.porClase(new KeyObject("Aux"));
						break;
					default:
						iteratorClase = dataBase.porClase(new FinalObject("Aux"));
						break;
						
					}
					mostrarDatabase(iteratorClase.next());
					if (iteratorClase.hasNext())
						btnAdelante.setEnabled(true);
					else
						btnAdelante.setEnabled(false);
					btnAtras.setEnabled(false);

				} catch (NoObjectToShowException e1) {
					allInvisible();
					object = null;
					iteratorClase = null;
					btnAdelante.setEnabled(false);
					btnAtras.setEnabled(false);
				} catch (NoNameValidException e1) {

				}

			}

		});
		cajaPorClase.setModel(new DefaultComboBoxModel<String>(Classes.getOpciones()));

	}

	////// FUNCIONALIDAD MOSTRAR POR CLASE /////

	/**
	 * Funcionalidad de Botón siguiente por Clase
	 */

	protected void siguienteObjectPorClase() {
		if (iteratorClase.hasNext()) {
			object = iteratorClase.next();
			if (object.getName().equals(name.getText()) && iteratorClase.hasNext())
				object = iteratorClase.next();

			mostrarDatabase(object);

		}

		if (!iteratorClase.hasNext())
			btnAdelante.setEnabled(false);
		else
			btnAdelante.setEnabled(true);
		if (!iteratorClase.hasPrevious())
			btnAtras.setEnabled(false);
		else
			btnAtras.setEnabled(true);

	}

	/**
	 * Funcionalidad de boton anterio por clase.
	 */
	protected void anteriorObjectPorClase() {
		if (iteratorClase.hasPrevious()) {
			object = iteratorClase.previous();
			if (object.getName().equals(name.getText()) && iteratorClase.hasPrevious())
				object = iteratorClase.previous();

			mostrarDatabase(object);

		}
		if (!iteratorClase.hasNext())
			btnAdelante.setEnabled(false);
		else
			btnAdelante.setEnabled(true);
		if (!iteratorClase.hasPrevious())
			btnAtras.setEnabled(false);
		else
			btnAtras.setEnabled(true);
	}
	
	//////////////////////////////////////////////
	
	
	///// FUNCIONALIDAD RANKING /////
	/**
	 * Funcionalidad de boton adelante de ranking
	 */
	private void siguienteObjetoRanking() {
		if (rankIterator.hasNext()) {
			objeto = rankIterator.next();
			if (objeto.getName().equals(name.getText()) && rankIterator.hasNext())
				objeto = rankIterator.next();

			mostrarDatabaseRanking(objeto);

		}

		if (!rankIterator.hasNext())
			btnAdelanteRanking.setEnabled(false);
		else
			btnAdelanteRanking.setEnabled(true);
		if (!rankIterator.hasPrevious())
			btnAtrasRanking.setEnabled(false);
		else
			btnAtrasRanking.setEnabled(true);
		
	}
	/**
	 * Funcionalidad de boton atras de ranking
	 */
	protected void anteriorObjetoRanking(){
		if (rankIterator.hasPrevious()) {
			objeto = rankIterator.previous();
			if (objeto.getName().equals(name.getText()) && rankIterator.hasPrevious())
				objeto = rankIterator.previous();

			mostrarDatabaseRanking(objeto);

		}
		if (!rankIterator.hasNext())
			btnAdelanteRanking.setEnabled(false);
		else
			btnAdelanteRanking.setEnabled(true);
		if (!rankIterator.hasPrevious())
			btnAtrasRanking.setEnabled(false);
		else
			btnAtrasRanking.setEnabled(true);
	}
	
	////////////////////////////////////

}
