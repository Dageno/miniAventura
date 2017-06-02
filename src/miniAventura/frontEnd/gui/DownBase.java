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

import miniAventura.backEnd.clases.Gestion;
import miniAventura.backEnd.enums.Classes;
import miniAventura.backEnd.enums.Crystal;


public class DownBase extends Template {

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
			DownBase dialog = new DownBase();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DownBase() {
		medidas();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Eliminar objeto de la dataBase");
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
		classObject.removeItem(Classes.FINAL_OBJECT);
		classObject.setEnabled(false);
		classWeapon.setSelectedItem(null);
		classWeapon.setEnabled(false);
		potionType.setEnabled(false);
		potionContainer.setEnabled(false);
		crystal.removeItem(Crystal.YELLOW);
		
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
		
		
		allInvisible();
		name.setVisible(true);
		search.setVisible(true);
		
		
		contentPanel.add(search);
	
		{
			
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.remove(okButton);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (object != null) {
							try {	
								switch (classObject.getSelectedItem().toString()) {
								case "Armas":
									dataBase.removeWeapon(object.getName());
									break;
								case "Pociones":
									dataBase.removePotion(object.getName());
									break;
								case "Objetos Clave":
									dataBase.removeKeyObject(object.getName());
									break;
								}
								Gestion.setModificado(true);
								cleanFieldsAdd();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(contentPanel, "Error al eliminar el objeto.", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(contentPanel, "Debe buscar un objeto para eliminar.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
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
