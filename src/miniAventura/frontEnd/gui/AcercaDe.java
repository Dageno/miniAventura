package miniAventura.frontEnd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaDe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setTitle("Acerca de...");
		setBounds(100, 100, 348, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblConcesionarioRealizadoEn = new JLabel("Creador de contenido de BoV realizado en el curso 1\u00BA de DAW");
			lblConcesionarioRealizadoEn.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblConcesionarioRealizadoEn.setBounds(26, 11, 264, 14);
			contentPanel.add(lblConcesionarioRealizadoEn);
		}
		{
			JLabel lblAutor = new JLabel("Autor:");
			lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblAutor.setBounds(26, 52, 77, 14);
			contentPanel.add(lblAutor);
		}
		{
			JLabel lblDanielGestinoNotario = new JLabel("Daniel Gestino Notario");
			lblDanielGestinoNotario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDanielGestinoNotario.setBounds(92, 77, 154, 14);
			contentPanel.add(lblDanielGestinoNotario);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
