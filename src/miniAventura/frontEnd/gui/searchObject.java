package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class searchObject extends Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public searchObject() {
		medidas();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Buscar objeto de la dataBase");
		contentPanel.setBorder(backGroundImage());
		
		/**
		 * labels
		 */
		contentPanel.add(lblSeleccionarObjeto);
		contentPanel.add(lblNombre);
		contentPanel.add(lblTipoDeArma);
		contentPanel.add(lblDescripcinDelObjeto);
		contentPanel.add(lblTipoDeContenedor);
		contentPanel.add(lblTipoDeContenedor);
		contentPanel.add(lblTipoDePocion);
		contentPanel.add(lblTipoDeCristal);
		contentPanel.add(lblesteObjetoEs);
		
		/**
		 * Jtextfield and text area
		 */
		contentPanel.add(name);
		contentPanel.add(description);
		description.setEnabled(false);
		
		/**
		 * JComboBox
		 */
		contentPanel.add(classWeapon);
		contentPanel.add(classObject);
		contentPanel.add(potionType);
		contentPanel.add(potionContainer);
		contentPanel.add(crystal);
		classObject.removeItem("Objeto Final");
		classObject.removeItem("Objetos Clave");
		classWeapon.setEnabled(false);
		classWeapon.setSelectedItem(null);
		potionType.setEnabled(false);
		potionContainer.setEnabled(false);
		
		/**
		 * Jbuttons and panel
		 */
		wood.setEnabled(false);
		iron.setEnabled(false);
		steel.setEnabled(false);
		panel.add(wood);
		panel.add(iron);
		panel.add(steel);
		panel.setEnabled(false);
		contentPanel.add(panel);
		
		
		
		
		search.setVisible(true);
		
		
		contentPanel.add(search);
		
{
			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.remove(okButton);
			{
							
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
	}

}
