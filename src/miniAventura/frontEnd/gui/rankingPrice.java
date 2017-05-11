package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import miniAventura.backEnd.clases.Drop;
import miniAventura.backEnd.clases.FinalObject;
import miniAventura.backEnd.clases.KeyObject;
import miniAventura.backEnd.clases.Potion;
import miniAventura.backEnd.clases.PrincipalObject;
import miniAventura.backEnd.clases.Weapon;
import miniAventura.backEnd.enums.Crystal;
import miniAventura.backEnd.excepciones.ItemNoExistsException;
import miniAventura.backEnd.interfaces.Valorable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rankingPrice extends MostrarBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton atras = new JButton("<");
	private JButton adelante = new JButton(">");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			rankingPrice dialog = new rankingPrice();
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
	public rankingPrice() throws ItemNoExistsException {
		
		setTitle("Ranking por precios");
		medidas();
		precio.setVisible(true);
		lblPrecioDelObjeto.setVisible(true);
		
		
		rankIterator = dataBase.ranking();
		
		
		
		/**
		 * Limpiamos la ventana
		 */
		allInvisible();
		allDisable();
		
		
		/**
		 * Añadimos el primer elemento
		 */
		mostrarDatabaseRanking(rankIterator.next());
		
		/**
		 * Actualizamos los botones
		 */
		actualizarBotonRanking(atras, adelante);
		
		
		/**
		 * Retrocede en el iterador
		 */
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					mostrarDatabaseRanking(rankIterator.previous());
					actualizarBotonRanking(atras, adelante);
			
		}});
		atras.setBounds(437, 337, 89, 23);
		contentPanel.add(atras);
		
		/**
		 * Avanza en el iterador
		 */
		adelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mostrarDatabaseRanking(rankIterator.next());
				actualizarBotonRanking(atras, adelante);
				
			}
		});
		contentPanel.add(adelante);
		
		
		
		
		
	}

	private void actualizarBotonRanking(JButton atras, JButton adelante) {
		if (!rankIterator.hasPrevious()) {
			rankIterator.next();
			atras.setEnabled(false);
		} else {

			atras.setEnabled(true);
		}

		if (!rankIterator.hasNext()) {
			rankIterator.previous();
			adelante.setEnabled(false);
		} else {

			adelante.setEnabled(true);
		}
		
	}

	
}
