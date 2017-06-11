package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import miniAventura.backEnd.clases.Gestion;
import miniAventura.backEnd.enums.Crystal;

public class UpBase extends Template {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public UpBase() {
		setTitle("A\u00F1adir objeto a la DataBase");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		medidas();
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
		
		/**
		 * JComboBox
		 */
		contentPanel.add(classWeapon);
		contentPanel.add(classObject);
		contentPanel.add(potionType);
		contentPanel.add(potionContainer);
		contentPanel.add(crystal);
		crystal.removeItem(Crystal.YELLOW);
		
		/**
		 * Jbuttons and panel
		 */
		contentPanel.add(panel);
		panel.add(wood);
		panel.add(iron);
		panel.add(steel);
		
		
		
		{
			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				/**
				 * Crea un objeto segun la clase elegida
				 */
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switch (classObject.getSelectedItem().toString()) {
						case "Armas":
							forgeWeapon();
							break;
						case "Pociones":
							makePotion();
							break;
						case "Objetos Clave":
							makeKeyObject();
							break;
						default:
							makeFinalObject();
							break;
						}
						Gestion.setModificado(true);
						
						
					}

				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
